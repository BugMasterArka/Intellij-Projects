
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
 }

public class SameTree {
    static boolean val=true;
    public static void traversal(TreeNode p,TreeNode q){
        if(p==null && q==null)
            return;
        else if((p==null && q!=null) || (p!=null && q==null)){
            val=false;
            return;
        }
        if(p.val!=q.val){
            val=false;
            return;
        }
        if(p.left!=null || q.left!=null)
            traversal(p.left,q.left);
        if(p.right!=null || q.right!=null)
            traversal(p.right,q.right);
    }
    public static boolean isSameTree(TreeNode p, TreeNode q){

        return val;
    }

    public static void main(String[] args) {
        TreeNode t1 = new TreeNode(1);
        TreeNode t2 = new TreeNode(2);
        TreeNode t3 = new TreeNode(1);
        t1.left=t2;
        t1.right=t3;

        TreeNode t4 = new TreeNode(1);
        TreeNode t5 = new TreeNode(1);
        TreeNode t6 = new TreeNode(2);
        t4.left=t5;
        t4.right=t6;


    }
}


//    public void traversal(TreeNode root,ArrayList<Integer> list){
//        if(root==null)
//            return;
//        list.add(root.val);
//        if(root.left!=null)
//            traversal(root.left,list);
//        if(root.right!=null)
//            traversal(root.right,list);
//    }
//    public boolean isSameTree(TreeNode p, TreeNode q) {
//        ArrayList<Integer> tree1 = new ArrayList<>();
//        ArrayList<Integer> tree2 = new ArrayList<>();
//        traversal(p,tree1);
//        traversal(q,tree2);
//        if(tree1.size()!=tree2.size())
//            return false;
//        boolean validity=true;
//        for(int i=0;i<tree1.size();i++){
//            if(tree1.get(i)!=tree2.get(i))
//                validity=false;
//        }
//        return validity;
//    }
