package song.questionbank.leetcode_niuke;

/**
 * Created by Song on 2017/6/28.
 * There are N gas stations along a circular route, where the amount of gas at station i is gas[i].
 You have a car with an unlimited gas tank and it costs cost[i]of gas to travel from station i to its next station (i+1).
 You begin the journey with an empty tank at one of the gas stations.
 Return the starting gas station's index if you can travel around the circuit once, otherwise return -1.
 Note:
 The solution is guaranteed to be unique.
 */
public class Solution17 {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int start = 0;
        for(int i=0;i<gas.length;i++){
            flag = false;
            boolean res = canCompeteNextStation(gas,cost,i,0,i);
            if(res) return i;
        }
        return -1;
    }

    boolean flag = false;
    public boolean canCompeteNextStation(int [] gas,int [] cost,int curStation,int curGas,int end){
        if(curStation>=gas.length) curStation = 0;
        if(flag && curStation == end ) return true;
        if(!flag) flag = true;
        curGas+=gas[curStation];
        curGas-=cost[curStation];
        if(curGas<0) return false;
        return canCompeteNextStation(gas, cost, curStation+1, curGas, end);
    }

    public static void main(String [] args){
        Solution17 sol = new Solution17();
        System.out.println(sol.canCompleteCircuit(new int[]{2,4},new int[]{3,4}));
    }

}
