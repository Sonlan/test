package song.questionbank.leetcode_niuke;

import java.util.*;
public class Solution24_1 {
    public ArrayList<ArrayList<String>> findLadders(String start, String end, HashSet<String> dict) {
        HashMap<String, ArrayList<String>> h = new HashMap();
        Set<String> set1 = new HashSet(), set2 = new HashSet();
        set1.add(start); set2.add(end);
        BFS(set1, set2, dict, h, true);
        ArrayList<ArrayList<String>> ans = new ArrayList();
        List<String> cur = new ArrayList();
        cur.add(start);
        DFS(start, end, h, cur, ans);
        return ans;
    }

    private void BFS(Set<String> set1, Set<String> set2, Set<String> wordList, HashMap<String, ArrayList<String>> h, boolean forward) {
        if (set1.size() > set2.size()) {
            BFS(set2, set1, wordList, h, !forward);
            return;
        }
        wordList.removeAll(set1);
        wordList.removeAll(set2);
        boolean connected = false;
        Set<String> set3 = new HashSet();

        for (String s : set1) {
            char[] c = s.toCharArray();
            for (int i = 0, len = c.length; i < len; i++) {
                char ch = c[i];
                for (char x = 'a'; x <= 'z'; x++)
                    if (x != ch) {
                        c[i] = x;
                        String cand = new String(c);
                        if (set2.contains(cand) || (!connected && wordList.contains(cand))) {
                            if (set2.contains(cand))
                                connected = true;
                            else
                                set3.add(cand);
                            String cand1 = forward ? cand : s;
                            String s1 = forward ? s : cand;
                            ArrayList<String> cur = h.containsKey(s1) ? h.get(s1) : new ArrayList();
                            cur.add(cand1);
                            h.put(s1, cur);
                        }
                    }
                c[i] = ch;
            }
        }
        if (!connected && !set3.isEmpty())
            BFS(set3, set2, wordList, h, forward);
    }

    private void DFS(String str, String ed, HashMap<String, ArrayList<String>> h, List<String> cur, ArrayList<ArrayList<String>> ans) {
        if (str.equals(ed)) {
            ans.add(new ArrayList(cur));
            return;
        }

        if (!h.containsKey(str)) return;
        List<String> next = h.get(str);
        for (String i : next) {
            cur.add(i);
            DFS(i, ed, h, cur, ans);
            cur.remove(cur.size() - 1);
        }
    }

    public static void main(String [] args){
        Solution24_1 sol = new Solution24_1();
        HashSet<String> dict = new HashSet<String>();
        dict.add("hot");dict.add("dot");dict.add("dog");
        dict.add("lot");dict.add("log");
        System.out.println(sol.findLadders("hit","cog",dict));
    }
}
