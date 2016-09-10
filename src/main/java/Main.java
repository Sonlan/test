/**
 * Created by Song on 2016/8/29.
 * 自增长测试
 */
public class Main {
    public static void main (String [] args) {
        AddressUtil.decode("湖北省武汉市洪山区珞瑜东路884-附2");
        AddressUtil.decode("浙江省-宁波市-市辖区");
        AddressUtil.decode("湖北省武汉市");
        AddressUtil.decode("北京市-东城区");
        AddressUtil.decode("内蒙古自治区-呼伦贝尔市-新巴尔虎右旗");
        AddressUtil.decode("新疆维吾尔自治区-哈密地区-伊吾县");
        AddressUtil.decode("澳门特别行政区-澳门半岛-望德堂区");
    }
}
