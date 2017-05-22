package song.mode.adapterMode;

/**
 * Created by Song on 2017/1/18.
 * 交易报表
 */
public class TradingStatement {
    public void report(IRMBDeal deal){
        String str = new String();
        StringBuffer sb = new StringBuffer();
        StringBuilder stringBuilder = new StringBuilder();
        System.out.println("交易省份："+deal.getProvince());
        System.out.println("交易城市："+deal.getCity());
        System.out.println("交易金额（RMB）："+deal.getRMB());
    }
}
