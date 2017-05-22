package song.questionbank.tooffer;

/**
 * Created by Song on 2017/3/10.
 * 二叉搜索树的后续遍历序列
 * 输入一个整数数组，判断该数组是不是某二叉搜索树的后序遍历的结果。如果是则输出Yes,否则输出No。假设输入的数组的任意两个数字都互不相同。
 * 解题思路：（1）所谓后续遍历，即顺序为左右根，二叉搜索树特点，左<根<右
 *          （2）所有树的问题，先找根元素。此例中，即为末尾元素。遍历数组与之比较，将原数组划分为连续的两个子数组，一个全小于根节点，一个全大于根节点，注意是连续。依次遍历，注意边界
 */
public class Solution23 {
    public boolean VerifySquenceOfBST(int [] sequence) {
        if(0== sequence.length) return false;
        return isValidate(sequence,0,sequence.length-1);
    }

    private boolean isValidate(int [] sequence,int start,int end){
        int length = end-start+1;
        if(1 >= length) return true;
        int root = sequence[end];
        int i=start,split = -1;
        while (i<=end){
            if(split<0) {
                if (sequence[i] > root) {
                    split = i;
                }
            }else {
                if(sequence[i]<root)
                    return false;
            }
            i++;
        }
        if(split<0) split = end;
        return isValidate(sequence,0,split-1) && isValidate(sequence,split,end-1) ;
    }

    public static void main(String [] args){
        int [] seq = new int[]{1};
        Solution23 solution23 = new Solution23();
        System.out.println(solution23.VerifySquenceOfBST(seq));
    }
}
