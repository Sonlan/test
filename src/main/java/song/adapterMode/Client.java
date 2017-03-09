package song.adapterMode;

/**
 * Created by Song on 2017/1/18.
 * 场景测试类
 */
public class Client {
    public static void main(String [] args){
        TradingStatement ts = new TradingStatement();
        IRMBDeal deal = new RMBDealAdapter();
        ts.report(deal);
    }
}
