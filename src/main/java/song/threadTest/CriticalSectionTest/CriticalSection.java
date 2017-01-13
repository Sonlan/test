package song.threadTest.CriticalSectionTest;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by Song on 2016/10/14.
 */
public class CriticalSection {
    static void testAproaches(PairManager pm1,PairManager pm2){
        ExecutorService es = Executors.newCachedThreadPool();
        PairManipulator pman1 = new PairManipulator(pm1),
                        pman2 = new PairManipulator(pm2);
        PairChecker pchecker1 = new PairChecker(pm1),
                    pchecker2 = new PairChecker(pm2);
        es.execute(pman1);es.execute(pman2);
        es.execute(pchecker1);es.execute(pchecker2);
        try{
            TimeUnit.MILLISECONDS.sleep(500);
        }catch (InterruptedException e){
            System.out.println("Sleep is interrupted");
        }
        System.out.println("pman1:"+pman1+"\npman2:"+pman2);
        System.exit(0);
    }

    public static void main(String [] args){
        PairManager pm1 = new PairManager1(),
                    pm2 = new PairManager2();
        testAproaches(pm1,pm2);
    }
}

class Pair{
    //成员变量
    private int x,y;
    //构造器
    public Pair(int x, int y){this.x = x;this.y = y;}
    public Pair(){this(0,0);}
    //getter方法
    public int getX() {return x;}
    public int getY() {return y;}
    //递增操作
    public void incrementX(){ this.x++;}
    public void incrementY(){this.y++;}
    //返回成员变量值
    public String toString(){return "X:"+this.x+" Y:"+this.y;}
    //内部类，自定义异常
    public class PairValuesNotEqualException extends RuntimeException{
        public PairValuesNotEqualException(){super("Pair values not equal "+Pair.this);}
    }
    //测试方法,判断两值是否相等
    public void checkState(){
        if(x!=y) throw new PairValuesNotEqualException();
    }
}

abstract class PairManager{
    //成员变量
    AtomicInteger checkConter = new AtomicInteger(0);
    protected Pair p = new Pair();
    private List<Pair> storage = Collections.synchronizedList(new ArrayList<Pair>());
    //获取由当前Pair对象初始化得到的新Pair对象
    public synchronized Pair getPair(){return new Pair(p.getX(),p.getY());}
    //模拟耗时操作
    protected void store(Pair p){
        storage.add(p);
        try{
            TimeUnit.MILLISECONDS.sleep(100);
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }
    //抽象方法
    public abstract void increment();
}

class PairManager1 extends PairManager{
    @Override
    public synchronized void increment() {
        p.incrementX();
        p.incrementY();
        store(getPair());
    }
}

class PairManager2 extends PairManager{
    @Override
    public void increment() {
        Pair temp;
        synchronized (this){
            p.incrementX();
            p.incrementY();
            temp = getPair();
        }
        store(temp);
    }
}

class PairManipulator implements Runnable{
    private PairManager pm;
    public PairManipulator(PairManager pairManager){this.pm = pairManager;}

    public void run() {
        while (true){
           pm.increment();
        }
    }
    public String toString(){
        return "Pair: "+pm.getPair()+"CheckConter: "+pm.checkConter.get();
    }
}

class PairChecker implements Runnable{
    private PairManager pm;
    public PairChecker(PairManager pm){this.pm = pm;}
    public void run() {
        while (true){
            pm.checkConter.incrementAndGet();
            pm.getPair().checkState();
        }
    }
}

