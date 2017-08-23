package song.questionbank.leetcode_niuke;

import java.util.ArrayList;

/**
 * Created by Song on 2017/8/22.
 * Given an array of words and a length L, format the text such that each line has exactly L characters and is fully (left and right) justified.
 You should pack your words in a greedy approach; that is, pack as many words as you can in each line. Pad extra spaces' 'when necessary so that each line has exactly L characters.
 Extra spaces between words should be distributed as evenly as possible. If the number of spaces on a line do not divide evenly between words, the empty slots on the left will be assigned more spaces than the slots on the right.
 For the last line of text, it should be left justified and no extra space is inserted between words.
 For example,
 words:["This", "is", "an", "example", "of", "text", "justification."]
 L:16.
 Return the formatted lines as:
 [
 "This    is    an",
 "example  of text",
 "justification.  "
 ]

 Note: Each word is guaranteed not to exceed L in length.
 click to show corner cases.
 Corner Cases:

 A line other than the last line might contain only one word. What should you do in this case?
 In this case, that line should be left-justified.
 */
 /*         理解题意：首先要做的就是确定每一行能放下的单词数，这个不难， 就是比较n个单词的长度和加上n -1个空格的长度跟给定的长度L来比较即可，
         *         找到了一行能放下的单词个数，然后计算出这一行存在的空格的个数， 是用给定的长度L减去这一行所有单词的长度和。得到了空格的个数之后，
         *         就要在每个单词后面插入这些空格，这里有两种情况， 比如某一行有两个单词"to"和
         *         "a"，给定长度L为6，如果这行不是最后一行，那么应该输出"to a"， 如果是最后一行，则应该输出 "to a"，
         *         所以这里需要分情况讨论，最后一行的处理方法和其他行之间略有不同。
         *         最后一个难点就是，如果一行有三个单词，这时候中间有两个空，如果空格数不是2的倍数，
         *         那么左边的空间里要比右边的空间里多加入一个空格，那么我们只需要用总的空格数除以空间个数，
         *         能除尽最好，说明能平均分配，除不尽的话就多加个空格放在左边的空间里
         *
         */
 //懒得看，直接复制过来的
public class Solution81 {
    public ArrayList<String> fullJustify(String[] words, int maxWidth) {
        ArrayList<String> res = new ArrayList<String>();

        int n = words.length;
        int i = 0;

        while (i < n) {
            StringBuilder sb = new StringBuilder();
            int last = i + 1;
            int len = words[i].length();
            while (last < n && len + 1 + words[last].length() <= maxWidth) {
                len += 1 + words[last].length();
                last++;
            }
            // 最后一行
            if (last == n) {
                for (int j = i; j < n; j++) {
                    sb.append(words[j] + " ");
                }
                sb.deleteCharAt(sb.length() - 1);
                for (int j = sb.length(); j < maxWidth; j++) {
                    sb.append(" ");
                }
            } else {
                // 只有一个word
                if (last - i == 1) {
                    sb.append(words[i]);
                    for (int j = words[i].length(); j < maxWidth; j++)
                        sb.append(" ");
                } else {// 有多个单词
                    int wordNum = last - i;
                    int wordTotal = 0;
                    for (int j = i; j < last; j++) {
                        wordTotal += words[j].length();
                    }
                    // eachSpace为每个单词间的空格数；r是余数，表示前r个空格数为eachSpace+1
                    int eachSpace = (maxWidth - wordTotal) / (wordNum - 1);
                    int r = (maxWidth - wordTotal) % (wordNum - 1);

                    for (int j = i; j < last; j++) {
                        sb.append(words[j]);
                        if (j < last - 1) {
                            for (int k = 0; k < eachSpace + ((j - i) < r ? 1 : 0); k++) {
                                sb.append(" ");
                            }
                        }
                    }
                }
            }
            res.add(sb.toString());
            i = last;
        }
        return res;
    }
}
