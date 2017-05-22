package song.framework;

import org.zeromq.ZMQ;

import java.io.UnsupportedEncodingException;

/**
 * Created by Song on 2016/7/25.
 */
public class ZeromqMain {

    public static void main(String [] args){
        final ZMQ.Context context = ZMQ.context(1);

        //采用ZMQ的router/dealer模式,多线程处理请求
        ZMQ.Socket router = context.socket(ZMQ.ROUTER);
        ZMQ.Socket dealer = context.socket(ZMQ.DEALER);

        router.bind("tcp://*:5555");
        dealer.bind("tcp://*:5556");

        //共创造10个dealer线程
        for (int i = 0; i < 10; i++) {
            new Thread(new Runnable(){
                public void run() {
                    ZMQ.Socket response = context.socket(ZMQ.REP);
                    response.connect("tcp://*:5556");
                    while (!Thread.currentThread().isInterrupted()) {
                        System.out.println("waitting for data");
                        byte[] requestBytes = response.recv();
                        String str;
                        try{
                            str = new String(requestBytes,"utf-8");
                        }catch (UnsupportedEncodingException e){
                            e.printStackTrace();
                            str = "ERROR";
                        }
                        System.out.println("接到数据,长度"+requestBytes.length+" "+str);
                        try {
                            response.send(requestBytes);
                            System.out.println("返回数据  长度:"+requestBytes.length);

                        } catch (Exception e) {
                            System.out.println("发生其他其他未知错误");
                            continue;
                        }
                    }
                    response.close();
                }

            }).start();
        }
        ZMQ.proxy(router, dealer, null);
        router.close();
        dealer.close();
        context.term();
    }
}
