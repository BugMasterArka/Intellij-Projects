public class BST {
    static TreeNode insert(TreeNode root,int val){
        if(root==null){
            return new TreeNode(val);
        }
        else if(val<root.val){
            root.left=insert(root.left,val);
        }else if(val>root.val){
            root.right=insert(root.right,val);
        }
        return root;
    }

    static void inOrder(TreeNode root){
        if(root.left!=null)
            inOrder(root.left);
        System.out.print(root.val+" ");
        if(root.right!=null)
            inOrder(root.right);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(10);
        root=insert(root,10);
        root=insert(root,5);
        root=insert(root,15);
        root=insert(root,3);
        root=insert(root,12);
        root=insert(root,17);
        root=insert(root,8);

        inOrder(root);
    }
}
