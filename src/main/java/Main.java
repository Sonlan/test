
import net.sf.json.JSONObject;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.message.BasicNameValuePair;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.*;

/**
 * Created by Song on 2016/8/29.
 * 自增长测试
 */
public class Main{
    private final static String AK = "3deWvCqvGO2LrYkYpgeeQ3up";

    {
        int i = 0;
        System.out.println("第一次");
    }
    public Main(){
        j=1;
        System.out.println("构造器");
    }
    static int j=0;
    {
        j=2;
        System.out.println("第二次");
    }
    static {
        j=3;
        System.out.println("静态区");
    }
    public static void main (String [] args) {
        String path = System.getProperty("user.dir");
        new Main();
        Map<String,String> map = new HashMap<String, String>();
        StringBuffer sb = new StringBuffer("one");
        String str = "one";
        map.put("origin","one");
        test(map,sb,str);
        System.out.println(sb);
        for (Map.Entry<String,String> entry:map.entrySet()){
            System.out.println(entry.getKey()+" "+entry.getValue());
        }
    }
    private static void test(Map<String,String > map,StringBuffer sb,String str){
        str = "two";
        map.put("extra","test");
        sb.append("extra");
    }

}

/**
 * 基于HttpClient实现GET以及POST请求
 */
class NetReqUtil {

    public static JSONObject get(String url){
        InputStream is = null;
        CloseableHttpClient httpClient = HttpClientBuilder.create().build();
        HttpGet httpGet = new HttpGet(url);
        try{
            HttpResponse response = httpClient.execute(httpGet);
            HttpEntity httpEntity = response.getEntity();
            is = httpEntity.getContent();
            int size =is.available();
            byte[] jsonBytes =new byte[size];
            is.read(jsonBytes);
            String message=new String(jsonBytes,"UTF-8");

            return JSONObject.fromObject(message);
        }catch (IOException e){
            //获取response异常
        }finally {
            try {
                if (null != is) is.close();
                if(null != httpGet) httpGet.releaseConnection();
                if(null != httpClient) httpClient.close();
            }catch (IOException e){
                e.printStackTrace();
            }
        }
        return null;
    }

    public static JSONObject post(String url, Map<String,String> data){
        InputStream is = null;
        CloseableHttpClient httpClient = HttpClientBuilder.create().build();
        HttpPost httpPost = new HttpPost(url);
        try {
            List<NameValuePair> nameValuePairs = new ArrayList<NameValuePair>();
            for (String key : data.keySet()) {
                nameValuePairs.add(new BasicNameValuePair(key, data.get(key)));
            }
            httpPost.setEntity(new UrlEncodedFormEntity(nameValuePairs));
            HttpResponse response = httpClient.execute(httpPost);

            HttpEntity httpEntity = response.getEntity();
            is = httpEntity.getContent();
            int size =is.available();
            byte[] jsonBytes =new byte[size];
            is.read(jsonBytes);
            String message=new String(jsonBytes,"UTF-8");

            return JSONObject.fromObject(message);
        }catch (UnsupportedEncodingException e){
            // 数据赋值错误
        }catch (IOException e){
            //获取response异常
        }finally {
            try {
                if(null != httpPost) httpPost.releaseConnection();
                if(null != httpClient) httpClient.close();
                if (null != is) is.close();
            }catch (IOException e){
                e.printStackTrace();
            }
        }
        return null;
    }
}

/**
 * 实现GET以及POST请求
 */
class UrlReqUtil {
    public static JSONObject get(String url){
        HttpURLConnection http = null;
        InputStream is = null;
        try {
            URL urlGet = new URL(url);
            http = (HttpURLConnection) urlGet.openConnection();

            http.setRequestMethod("GET");
            http.setRequestProperty("Content-Type","application/x-www-form-urlencoded");
            http.setDoOutput(true);
            http.setDoInput(true);
            System.setProperty("sun.net.client.defaultConnectTimeout", "30000");
            System.setProperty("sun.net.client.defaultReadTimeout", "30000");

            http.connect();

            is =http.getInputStream();
            int size =is.available();
            byte[] jsonBytes =new byte[size];
            is.read(jsonBytes);
            String message=new String(jsonBytes,"UTF-8");
            return JSONObject.fromObject(message);
        } catch (Exception e) {
            return null;
        }finally {
            if(null != http) http.disconnect();
            try {
                if (null != is) is.close();
            }catch (IOException e){
                e.printStackTrace();
            }
        }

    }

    public static JSONObject post(String url,String data){
        HttpURLConnection http = null;
        PrintWriter out = null;
        BufferedReader reader = null;
        try {
            //创建连接
            URL urlPost = new URL(url);
            http = (HttpURLConnection) urlPost
                    .openConnection();
            http.setDoOutput(true);
            http.setDoInput(true);
            http.setRequestMethod("POST");
            http.setUseCaches(false);
            http.setInstanceFollowRedirects(true);
            http.setRequestProperty("Content-Type",
                    "application/x-www-form-urlencoded");

            http.connect();

            //POST请求
            OutputStreamWriter outWriter = new OutputStreamWriter(http.getOutputStream(), "utf-8");
            out = new PrintWriter(outWriter);
            out.print(data);
            out.flush();
            out.close();
            out = null;

            //读取响应
            reader = new BufferedReader(new InputStreamReader(
                    http.getInputStream()));
            String lines;
            StringBuffer sb = new StringBuffer("");
            while ((lines = reader.readLine()) != null) {
                lines = new String(lines.getBytes(), "utf-8");
                sb.append(lines);
            }
            reader.close();
            reader = null;
            return JSONObject.fromObject(sb);
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            return null;
        }finally {
            if(null != http) http.disconnect();
            if(null != out) out.close();
            try{
                if(null != reader) reader.close();
            }catch (IOException e){
                e.printStackTrace();
            }
        }

    }
}
