public class CompleteBinaryTree {
    static TreeNode root;

    public static int countNodes(TreeNode cur){
        if(cur==null)
            return 0;
        else
            return 1+countNodes(cur.left)+countNodes(cur.right);
    }

    public static boolean isComplete(TreeNode cur, int index, int totalNodes){
        if(cur==null)
            return true;
        if(index>totalNodes)
            return false;

        return isComplete(cur.left,2*index,totalNodes) && isComplete(cur.right,2*index+1,totalNodes);
    }

    public static void main(String[] args) {
        root = new TreeNode(1);
        TreeNode a = new TreeNode(2);
        TreeNode b = new TreeNode(3);
        TreeNode c = new TreeNode(4);
        TreeNode d = new TreeNode(5);
        root.left=a;
        root.right=b;
//        a.left=c;
        a.right=d;
        int nodes = countNodes(root);
        System.out.println(isComplete(root,1,nodes));
    }
}
