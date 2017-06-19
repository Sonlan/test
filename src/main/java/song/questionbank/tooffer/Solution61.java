package song.questionbank.tooffer;

/**
 * Created by Song on 2017/6/18.
 * 请实现两个函数，分别用来序列化和反序列化二叉树
 */
/*
public class TreeNode {
    int val = 0;
    TreeNode left = null;
    TreeNode right = null;

    public TreeNode(int val) {
        this.val = val;

    }

}
*/
public class Solution61 {
    String Serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        if(null != root)
            serializeCore(root,sb);
        return sb.toString();
    }
    //先序
    private void serializeCore(TreeNode node,StringBuilder sb){
        if(null == node) {sb.append("#,");return;}
        sb.append(node.val+",");
        serializeCore(node.left,sb);
        serializeCore(node.right, sb);
    }
    TreeNode Deserialize(String str) {
        if(null == str || 0 == str.length()) return null;
        return deserializeCore(str.split(","));
    }

    int index = -1;
    private TreeNode deserializeCore(String [] strs){
        index++;
        if(index<strs.length && !strs[index].equals("#")){
            TreeNode node = new TreeNode(Integer.parseInt(strs[index]));
            node.left = deserializeCore(strs);
            node.right = deserializeCore(strs);
            return node;
        }
        return null;
    }

    public static void main(String [] args){

    }
}
