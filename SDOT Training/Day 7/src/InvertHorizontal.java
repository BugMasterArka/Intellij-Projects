import java.util.Scanner;

public class InvertHorizontal {

    static TreeNode invert(TreeNode root){
        if(root.left!=null)
            root.left=invert(root.left);
        if(root.right!=null)
            root.right=invert(root.right);
        TreeNode temp=null;
        temp=root.left;
        root.left=root.right;
        root.right=temp;
        return root;
    }

    static TreeNode insert(TreeNode root,int val){
        if(root==null){
            if(val!=-1)
                return new TreeNode(val);
            else
                return null;
        }
        else if(val<root.val){
            root.left=insert(root.left,val);
        }else if(val>root.val){
            root.right=insert(root.right,val);
        }
        return root;
    }

    static void preOrder(TreeNode root){
        System.out.print(root.val+" ");
        if(root.left!=null)
            preOrder(root.left);
        if(root.right!=null)
            preOrder(root.right);
    }

    static void inOrder(TreeNode root){
        if(root.left!=null)
            inOrder(root.left);
        System.out.print(root.val+" ");
        if(root.right!=null)
            inOrder(root.right);
    }

//    static TreeNode insertLevel(TreeNode root,int val){
//        if(root==null){
//            if(val!=-1)
//                return new TreeNode(val);
//            else
//                return null;
//        }
//        else if(root.left==null)
//            root.left=new TreeNode(val);
//        else if(root.right==null)
//            root.right=new TreeNode(val);
//        else if(root.left!=null)
//            root.left=insertLevel(root.left,val);
//        else if(root.right!=null)
//            root.right=insertLevel(root.right,val);
//        return root;
//    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        String[] str = s.split(" ");
        int[] arr = new int[str.length];
        int index=0;
        for(String input: str){
            arr[index++]=Integer.parseInt(input);
        }

        TreeNode root = new TreeNode(arr[0]);
         for(int i=1;i<arr.length;i++){
             insert(root,arr[i]);
         }

        inOrder(root);
//
//        System.out.println();

        invert(root);

        preOrder(root);

    }
}
