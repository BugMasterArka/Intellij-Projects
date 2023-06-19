import java.util.LinkedList;
import java.util.Queue;

public class BST {
    static BinaryNode root=null;

    public static BinaryNode insert(BinaryNode root, int value){
        if(root==null){
            root  = new BinaryNode();
            root.value = value;
            return root;
        }
        else if(value<= root.value)
            root.left = insert(root.left,value);
        else
            root.right = insert(root.right,value);
        return root;
    }

    public static void preOrder(BinaryNode root){
        if(root!=null)
        System.out.print(root.value+" ");
        if(root.left!=null)
            preOrder(root.left);
        if(root.right!=null)
            preOrder(root.right);
    }

    public static void inOrder(BinaryNode root){
        if(root.left!=null)
            inOrder(root.left);
        System.out.print(root.value+" ");
        if(root.right!=null)
            inOrder(root.right);
    }

    public static void postOrder(BinaryNode root){
        if(root.left!=null)
            postOrder(root.left);
        if(root.right!=null)
            postOrder(root.right);
        System.out.print(root.value+" ");
    }

    public static void levelOrder(){
        Queue<BinaryNode> q = new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()){
            BinaryNode cur = q.remove();
            System.out.print(cur.value+" ");
            if(cur.left!=null) q.add(cur.left);
            if(cur.right!=null) q.add(cur.right);
        }
    }

    public static BinaryNode search(BinaryNode root,int value){
        if(root==null){
            System.out.println("not found");
            return null;
        }
        else if(root.value==value){
            System.out.println("found");
            return root;
        }
        else if(value<=root.value)   return search(root.left,value);
        else    return search(root.right,value);
    }

    public static BinaryNode minimumNode(BinaryNode root){
        if(root.left==null)
            return root;
        else
            return minimumNode(root.left);
    }

    public static BinaryNode deleteNode(BinaryNode root, int value){
        if(root==null){
            System.out.println("node doesn't exist");
            return null;
        }
        if(value < root.value)
            root.left = deleteNode(root.left,value);
        else if(value > root.value)
            root.right = deleteNode(root.right,value);
        else{
            if(root.left!=null && root.right!=null){
                BinaryNode successor = minimumNode(root.right);
                root.value = successor.value;
                root.right = deleteNode(root.right,successor.value);
            }else if(root.left!=null)
                root = root.left;
            else if(root.right!=null)
                root = root.right;
            else
                root=null;
        }
        return root;
    }

    public void deleteBST(){
        root = null;
        System.out.println("tree deleted");
    }

    public static void main(String[] args) {
        root=insert(root,50);
        root=insert(root,30);
        root=insert(root,40);
        root=insert(root,70);
        root=insert(root,20);
        root=insert(root,60);
        root=insert(root,90);
        preOrder(root);
        System.out.println();
        inOrder(root);
        System.out.println();
        postOrder(root);
        System.out.println();
        levelOrder();
        System.out.println();
        search(root,60);
        deleteNode(root,50);
        inOrder(root);
        System.out.println();
    }
}
