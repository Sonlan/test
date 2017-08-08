package song.alibaba;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.regex.Pattern;

/**
 * Created by Song on 2017/8/3.
 */
public class IPDetect {
    //队列，存储每行文本
    private final Queue<String> queue = new ConcurrentLinkedQueue<String>();
    //结果集
    private final List<String> result = new LinkedList<String>();
    //是否读文件完成
    private volatile boolean isFinished = false;
    //工作线程数量
    private final int THREAD_COUNT = 10;
    //Ipv4正则表达式
    private String IPV4 = "(25[0-5]|2[0-4]\\d|[0-1]\\d{2}|[1-9]?\\d)\\.(25[0-5]|2[0-4]\\d|[0-1]\\d{2}|[1-9]?\\d)\\.(25[0-5]|2[0-4]\\d|[0-1]\\d{2}|[1-9]?\\d)\\.(25[0-5]|2[0-4]\\d|[0-1]\\d{2}|[1-9]?\\d)";
    private final Pattern pattern = Pattern.compile(IPV4);

    /**
     * 多线程，从队列中取出每行文本，若为IP在放入结果列表中
     */
    public void process(){
        for (int i=0;i<THREAD_COUNT;i++){
            new Thread(new Runnable() {
                public void run() {
                    while (!isFinished || !queue.isEmpty()){
                        if(!queue.isEmpty()) {
                            String curStr = queue.poll();
                            if(validate(curStr)){
                                synchronized (result){
                                    result.add(curStr);
                                }
                            }
                        }
                    }
                }
            }).start();
        }
    }

    /**
     * IPv4地址判断
     * @param str
     * @return
     */
    public boolean validate(String str){
        if(null == str || str.length() < 7 || str.length() > 15)
        {
            return false;
        }
        return pattern.matcher(str).matches();
    }

    /**
     * 读文本，将每行结果放入队列中
     * @param path 文件路径
     * @throws FileNotFoundException
     * @throws IOException
     */
    public void read(String path) throws FileNotFoundException,IOException{
        BufferedReader br = new BufferedReader(new FileReader(path));
        try {
            String str;
            while (null != (str = br.readLine())){
                queue.add(str);
            }
        }finally {
            br.close();
            isFinished = true;
        }
    }

    public List<String> getResult() {
        return result;
    }

    public static void main(String [] args){
        String path = "";
        IPDetect detect = new IPDetect();
        try {
            detect.read(path);
        }catch (FileNotFoundException e){
            //TODO
        }catch (IOException e){
            //TODO
        }
        detect.process();
        //结果集
        List<String> list = detect.getResult();
    }
}
