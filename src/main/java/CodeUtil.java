import java.security.MessageDigest;

/**
 * 校验消费码的有效性
 * Created by Song on 2016/7/20.
 */
public class CodeUtil {
    /**
     * 校验消费码有效性
     * @param code
     * @return
     */
    public static boolean validate(String code){
        code = format(code,16);
        //字符校验
        for (char c:code.toCharArray()) {
                if(c<'0'||c>'9')
                    return false;
        }
        //规则校验
        String a = code.substring(code.length()-4,code.length());
        String s = generate(code.substring(0,code.length()-4));
        if(!code.equals(generate(code.substring(0,code.length()-4))))
            return false;
        return true;
    }

    /**
     * 产生校验位
     * @param s 顺序数
     * @return 顺序数+校验位（4）
     */
    public final static String generate(String s) {
        s=format(s,12);
        char hexDigits[] = {'8', '3', '1', '5', '6', '2', '4', '7', '9', '0', '4', '2', '7', '1', '6', '2'};
        try {
            byte[] btInput = s.getBytes();
            // 获得MD5摘要算法的 MessageDigest 对象
            MessageDigest mdInst = MessageDigest.getInstance("MD5");
            // 使用指定的字节更新摘要
            mdInst.update(btInput);
            // 获得密文
            byte[] md = mdInst.digest();
            // 把密文转换成十六进制的字符串形式
            int j = md.length;
            char str[] = new char[4];
            int k = 0;
            for (int i = 0; i < j;) {
                byte byte0 = md[i];
                byte byte1 = md[i+1];
                byte byte2 = md[i+2];
                byte byte3 = md[i+3];
                str[k++] = hexDigits[(byte0&byte1|byte2&byte3) >>> 4 & 0xf];
                i+=4;
            }
            String validate = new String(str);
            return format(s+validate,16);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * 以0补齐字符创长度
     * @param origin  原始字符串长度
     * @param length 返回的字符串长度
     * @return
     */
    public static String format(String origin,int length){
        String index = "000000000000000000";
        if(length>origin.length()){
            return index.substring(0,length-origin.length()).concat(origin);
        }else return origin.substring(0,length);
    }
}
