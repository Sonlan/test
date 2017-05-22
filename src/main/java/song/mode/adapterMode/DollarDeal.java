package song.mode.adapterMode;

/**
 * Created by Song on 2017/1/18.
 * 新业务（发生在美国，以美元结算的业务)
 */
public class DollarDeal {
    //交易发生的州
    public String getState(){
        return "Washington State";
    }
   //交易发生的城市
    public String getCity(){
        return "Washington City";
    }
   //交易美金
    public int getDollar(){
        return 100;
    }
}
