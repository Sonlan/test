package song.alibaba;

/**
 * Created by Song on 2017/8/3.
 * 过年的时候地主给长工发工钱，地主打算切开一根金条，按照长工的工作量每人分一部分。只有金匠才能切开金条，每切一次，金匠要收金条长度个铜币，比如长度为15的金条切开一次要收15个铜币。地主希望找到一种切分方法，使得完成切分后能给金匠最少的铜币。
 举例说明，比如金条长30，需要分给4位长工，每人分到的分别为6，7，8，9。一种切分方式是先切成15和15，然后再分别切分成6和9，7和8，此时地主需要给金匠铜币数最少，一共60个。
 */
import java.util.*;
public class Main {
/** 请完成下面这个函数，实现题目要求的功能 **/
    /** 当然，你也可以不按照这个模板来作答，完全按照自己的想法来 ^-^  **/
    //哈夫曼
    static int cut(int[] parts) {
        if(null == parts || 0==parts.length) return 0;
        if(1 == parts.length) return 0;
        int tmp=0,total=0;
        Arrays.sort(parts);
        while (parts[1]!=Integer.MAX_VALUE){
            tmp=parts[0]+parts[1];
            parts[0] = tmp;
            total+=parts[0];
            parts[1] = Integer.MAX_VALUE;
            Arrays.sort(parts);
        }
        return total;
    }
    public static void main(String[] args){
/*        Scanner in = new Scanner(System.in);
        int pieces = Integer.parseInt(in.nextLine().trim());
        int[] parts = new int[pieces];
        for (int i = 0; i < pieces; i++) {
            parts[i] = Integer.parseInt(in.nextLine().trim());
        }
        System.out.println(cut(parts));*/
        System.out.println(cut(new int[]{1,2,3,4}));
    }
}
