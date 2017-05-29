package song.questionbank.tooffer;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

/**
 * Created by Song on 2017/5/22.
 * 输入一个字符串,按字典序打印出该字符串中字符的所有排列。例如输入字符串abc,则打印出由字符a,b,c所能排列出来的所有字符串abc,acb,bac,bca,cab和cba。
 * 输入一个字符串,长度不超过9(可能有字符重复),字符只包括大小写字母。
 */
public class Solution27 {
    public static ArrayList<String> Permutation(String str) {
        ArrayList<String> list = new ArrayList<String>();
        perm(str.toCharArray(),0,list);
        for(int i=0;i<list.size();i++){
            if(list.indexOf(list.get(i))!=i) {
                list.remove(i);
                i--;
            }
        }
        Collections.sort(list);
        return list;
    }

    public static void perm(char [] strs, int start, List<String> list){
        if(start>=strs.length-1) {
            list.add(new String(strs));
            return;
        }
        for(int i=start;i<strs.length;i++){
            swap(strs,start,i);
            perm(strs,start+1,list);
            swap(strs,start,i);
        }
    }

    public static void swap(char [] strs,int i,int j){
        if(i*j<0 || i>strs.length-1 || j >strs.length-1) return;

        char temp = strs[i];
        strs[i] = strs[j];
        strs[j] = temp;
    }

    public static void main(String [] args){
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        ArrayList<String> list = Permutation(str);
        for(String s:list){
            System.out.println(s);
        }
    }
}
