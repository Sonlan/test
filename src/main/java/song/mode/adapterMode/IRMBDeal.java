package song.mode.adapterMode;

/**
 * Created by Song on 2017/1/18.
 * 一宗人民币交易
 */
public interface IRMBDeal {
    //获取交易省份
    String getProvince();
    //获取交易城市
    String getCity();
    //获取交易金额（人民币）
    int getRMB();
}
