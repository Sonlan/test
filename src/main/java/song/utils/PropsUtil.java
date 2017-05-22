package song.utils;

import java.io.*;
import java.net.URL;
import java.util.Properties;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Song on 2016/11/2.
 * @since v0.0
 */
public final class PropsUtil {
    private static final Pattern PATTERN = Pattern.compile("\\$\\{([^\\}]+)\\}");

    /**
     * 加载资源文件
     * @param fileName 资源文件名
     * @return
     */
    public static Properties loadProps(String fileName){
        Properties pros = null;
        InputStream is = null;
        try{
            is = Thread.currentThread().getContextClassLoader().getResourceAsStream(fileName);
            if(null == is){
                throw new FileNotFoundException(fileName+" file is not found");
            }
            pros = new Properties();
            pros.load(is);
        }catch (IOException e){
            System.err.println("load peoperties file failed");
            e.printStackTrace();
        }finally {
            if(null != is){
                try {
                    is.close();
                }catch (IOException e){
                    System.err.println("close input stream failed");
                    e.printStackTrace();
                }
            }
        }
        return pros;
    }

    /**
     * 获取资源文件值
     * @param key 键名
     * @param prop 资源文件句柄
     * @return
     */
    public static String getProperty(String key,Properties prop) {
        String value = prop.getProperty(key);
        Matcher matcher = PATTERN.matcher(value);
        StringBuffer buffer = new StringBuffer();
        while (matcher.find()) {
            String matcherKey = matcher.group(1);
            String matchervalue = prop.getProperty(matcherKey);
            if (matchervalue != null) {
                matcher.appendReplacement(buffer, matchervalue);
            }
        }
        matcher.appendTail(buffer);
        return buffer.toString();
    }

    public static boolean setProperty(String key,String value,String fileName) throws Exception{
        URL url = PropsUtil.class.getResource("setting/token.properties");
        Properties properties = new Properties();
        properties.setProperty(key, value);
        properties.store(new FileOutputStream(new File(url.toURI())),"");
        return true;
    }
}
