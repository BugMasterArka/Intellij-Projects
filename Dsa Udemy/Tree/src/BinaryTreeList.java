import java.util.LinkedList;
import java.util.Queue;

public class BinaryTreeList {
    BinaryNode root;

    public BinaryTreeList(){
        this.root = null;
    }

    public void preOrder(BinaryNode root){
        System.out.print(root.value+" ");
        if(root.left!=null) preOrder(root.left);
        if(root.right!=null) preOrder(root.right);
    }

    public void inOrder(BinaryNode root){
        if(root.left!=null) inOrder(root.left);
        System.out.print(root.value+" ");
        if(root.right!=null) inOrder(root.right);
    }

    public void postOrder(BinaryNode root){
        if(root.left!=null) postOrder(root.left);
        if(root.right!=null) postOrder(root.right);
        System.out.print(root.value+" ");
    }

    public void levelOrder(){
        Queue<BinaryNode> q = new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()){
            BinaryNode node = q.remove();
            System.out.print(node.value+" ");
            if(node.left!=null) q.add(node.left);
            if(node.right!=null) q.add(node.right);
        }
    }

    public void search(int key){
        if(root==null){
            System.out.println("empty tree");
        }else{
            Queue<BinaryNode> q = new LinkedList<>();
            q.add(root);
            while(!q.isEmpty()){
                BinaryNode node = q.remove();
                if(node.value==key){
                    System.out.println("found");
                    return;
                }
                if(node.left!=null) q.add(node.left);
                if(node.right!=null) q.add(node.right);
            }
            System.out.println("not found");
        }
    }

    public void insert(int value){
        BinaryNode newNode = new BinaryNode(value);
        if(root==null){
            root=newNode;
        }else{
            Queue<BinaryNode> q = new LinkedList<>();
            q.add(root);
            while(!q.isEmpty()){
                BinaryNode present = q.remove();
                if(present.left==null){
                    present.left = newNode;
                    return;
                }else if(present.right==null){
                    present.right = newNode;
                    return;
                }
                q.add(present.left);
                q.add(present.right);
            }
        }
    }

    public BinaryNode getDeepestNode(){
        if(root==null)
            return null;
        else{
            Queue<BinaryNode> q = new LinkedList<>();
            BinaryNode node = null;
            q.add(root);
            while(!q.isEmpty()){
                node = q.remove();
                if(node.left!=null) q.add(node.left);
                if(node.right!=null) q.add(node.right);
            }
            return node;
        }
    }

    public void deleteDeepestNode(){
        Queue<BinaryNode> q = new LinkedList<>();
        q.add(root);
        BinaryNode prev = null, cur = null;
        while(!q.isEmpty()){
            prev = cur;
            cur = q.remove();
            if(cur.left == null) {
                prev.right = null;
                return;
            }
            else if(cur.right == null) {
                cur.left = null;
                return;
            }
            q.add(cur.left);
            q.add(cur.right);
        }
    }

    public void deleteNode(int value){
        Queue<BinaryNode> q = new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()){
            BinaryNode node = q.remove();
            if(node.value == value){
                node.value = getDeepestNode().value;
                deleteDeepestNode();
                System.out.println("deleted");
                return;
            }else{
                if(node.left!=null) q.add(node.left);
                if(node.right!=null) q.add(node.right);
            }
        }
        System.out.println("node doesn't exist");
    }

    public void deleteTree(){
        this.root = null;
        System.out.println("tree deleted");
    }

    public static void main(String[] args) {
        BinaryTreeList t = new BinaryTreeList();
        t.insert(1);
        t.insert(2);
        t.insert(3);
        t.insert(4);
        t.insert(5);
        t.insert(6);
        t.insert(7);
        t.insert(8);
        t.insert(9);
        t.preOrder(t.root);
        System.out.println();
        t.inOrder(t.root);
        System.out.println();
        t.postOrder(t.root);
        System.out.println();
        t.search(5);
        t.deleteNode(3);
        t.inOrder(t.root);
    }
}
