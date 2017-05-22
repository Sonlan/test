package song.mode.strategyMode;

/**
 * Created by Song on 2016/10/28.
 * 策略枚举
 */
public enum EnumStrategy {
    ADD{
        @Override
        public int execute(int x, int y) {
            return x+y;
        }
    },
    SUB{
        @Override
        public int execute(int x, int y) {
            return x-y;
        }
    };
    public abstract int execute(int x,int y);

    //测试分别调用加减法操作
    public static void main(String [] args){
        System.out.println("1+2="+EnumStrategy.ADD.execute(1,2));
        System.out.println("1-2="+EnumStrategy.SUB.execute(1,2));
    }
}
