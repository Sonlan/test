
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
    public static void main (String [] args) {
/*        try{
            Map<String,String> map = new HashMap<String, String>();
            JSONObject baiduCode = NetReqUtil.get("http://api.map.baidu.com/geoconv/v1/?ak="+AK+"&coords="+109.102+","+39.12).getJSONArray("result").getJSONObject(0);
            Double blog = baiduCode.getDouble("x");
            Double blat = baiduCode.getDouble("y");
            JSONObject addressInfo = NetReqUtil.get("http://api.map.baidu.com/geocoder/v2/?output=json&pois=1&ak="+AK+"&location="+blat+","+blog).getJSONObject("result");
            map.put("fullAddr",addressInfo.getString("formatted_address"));
            JSONObject addressDetail = addressInfo.getJSONObject("addressComponent");
            map.put("province",addressDetail.getString("province"));
            map.put("city",addressDetail.getString("city"));
            System.out.println(addressInfo.getString("formatted_address"));
        }catch (Exception e){
            e.printStackTrace();
        }*/
        /*Map<String,String> params = new HashMap<String, String>();
        params.put("appid","wxd930ea5d5a258f4f");
        params.put("mch_id","10000100");
        params.put("device_info","1000");
        params.put("body","test");
        params.put("nonce_str","ibuaiVcKdpRxkhJA");
        System.out.println(PayWxUtil.getSign(params,"192006250b4c09247ec02edce69f6a2d"));

        for(int i=0;i<10;i++){
            System.out.println(PayWxUtil.getNonceStr());
        }

        System.out.println(PayWxUtil.getMchBillno("0123456789-"));*/
        /*Properties properties = PropsUtil.loadProps("setting/token.properties");
        try {
            System.out.println(PropsUtil.getProperty("access_token",properties));
            PropsUtil.setProperty("access_token", "test3", "setting/token.properties");
            properties = PropsUtil.loadProps("setting/token.properties");
            System.out.println(PropsUtil.getProperty("access_token",properties));
        }catch (Exception e){
            e.printStackTrace();
        }*/
        System.out.println(CodeUtil.generate(1+"")+CodeUtil.validate(CodeUtil.generate(1+"")));
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
