package song.mode.adapterMode;

/**
 * Created by Song on 2017/1/18.
 * 适配器类，将DollarDeal实例转化为IRMBDeal实例
 */
public class RMBDealAdapter extends DollarDeal implements IRMBDeal {
    public String getProvince() {
        return super.getState();
    }

    public String getCity() {
        return super.getCity();
    }

    public int getRMB() {
        return super.getDollar()/7;
    }
}
