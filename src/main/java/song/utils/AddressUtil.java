package song.utils;

import java.util.HashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Song on 2016/9/2.
 * 地址格式转化工具类
 */
public class AddressUtil {
    /**
     * 传入一个完整的地址描述字符串，返回一个哈希表，拆分记录省,市,其他三个等级的信息
     * @param address
     * @return
     */
    public static HashMap<String,String> decode(String address){
        String regx="(.*?)省(.*?)[市区盟县](.*)";
        HashMap<String,String> map = new HashMap<String, String>();
        map.put("province","");
        map.put("city","");
        map.put("detail","");
        if(address.contains("省")){
            regx = "(.*?)省(.*?)[市区盟县](.*)";
        }else if(address.contains("自治区")){
            regx = "(.*?)自治区(.*?)[市区盟县](.*)";
        }else if(address.contains("行政区")){
            regx = "(.*?)行政区(.*?)[市区盟县](.*)";
        }else{//直辖市
            regx = "(.*?)省(.*?)市(.*?)";
        }
        Pattern pattern = Pattern.compile(regx,Pattern.DOTALL);
        Matcher matcher = pattern.matcher(address);
        if(matcher.find()){
            System.out.println(matcher.group(0)+"            "+matcher.group(1)+"           "+matcher.group(2)+"        "+matcher.group(3));
        }
        return map;
    }
}
