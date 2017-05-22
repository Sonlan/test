package song.basis.threadTest.ThreadEndTest;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * Created by Song on 2016/10/18.
 */
public class OrnamentalGarden {
    public static void main(String [] args) throws Exception{
        ExecutorService es = Executors.newCachedThreadPool();
        for (int i=0;i<10;i++){
            es.execute(new Entrance(i));
        }
        TimeUnit.SECONDS.sleep(3);
        Entrance.cancel();
        es.shutdown();
        if(!es.awaitTermination(250,TimeUnit.MILLISECONDS))
            System.out.println("some entrances not closed");
        System.out.println("sum of entrances :"+Entrance.getTotalCount());
        System.out.println("sum of entrances person: " +Entrance.sumEntrances());
    }
}

class Count{
    private  int count = 0;
    private Random random = new Random(47);

    public   int increment(){
        int temp = this.count;
        if(random.nextBoolean()) Thread.yield();
        return this.count=++temp;
    }
    public  int value(){return this.count;}
}

class Entrance implements Runnable{
    private  Count count = new Count();
    private static List<Entrance> entrances = new ArrayList<Entrance>();
    private int number = 0;
    private final int id;
    private static volatile boolean canceled = false;

    public static void cancel(){canceled=true;}
    public Entrance(int id){this.id=id;entrances.add(this);}
    public void run() {
        while (!canceled){
            synchronized (this){++this.number;}
            System.out.println(this+ "  Total :"+count.increment());
            try {
                TimeUnit.MILLISECONDS.sleep(100);
            }catch (InterruptedException e){
                System.out.println("sleep interrupted");
            }
        }
        System.out.println("Stopping "+this);
    }
    public int getValue(){return this.number;}
    public String toString(){return "Entrance "+id+" : "+this.getValue();}
    public static int getTotalCount(){
        /*return count.value();*/
        int sum=0;
        for (Entrance entrance:entrances){
            sum+=entrance.count.value();
        }
        return sum;
    }
    //统计所有入口的人数
    public static int sumEntrances(){
        int sum=0;
        for (Entrance entrance:entrances){
            sum+=entrance.getValue();
        }
        return sum;
    }
}


