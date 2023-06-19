import org.w3c.dom.Node;

import java.util.LinkedList;
import java.util.Queue;

public class AVLTree {
    BinaryNode root;

    AVLTree(){
        root=null;
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
        System.out.print(root.right);
    }

    public void levelOrder(){
        Queue<BinaryNode> q = new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()){
            BinaryNode cur = q.remove();
            System.out.print(cur.value+" ");
            if(cur.left!=null) q.add(cur.left);
            if(cur.right!=null) q.add(cur.right);
        }
    }

    public BinaryNode search(BinaryNode cur, int value){
        if(cur==null){
            System.out.println("not found");
            return null;
        }
        if(cur.value == value){
            System.out.println("found");
            return cur;
        }else if(value > cur.value) return search(cur.right,value);
        else return search(cur.left,value);
    }

    public int getHeight(BinaryNode node){
        if(node == null)
            return 0;
        return node.height;
    }

    public BinaryNode rotateRight(BinaryNode disbalancedNode){
        BinaryNode newRoot = disbalancedNode.left;
        disbalancedNode.left=disbalancedNode.left.right;
        newRoot.right=disbalancedNode;

        disbalancedNode.height = 1 + Math.max(getHeight(disbalancedNode.left),getHeight(disbalancedNode.right));

        newRoot.height = 1 + Math.max(getHeight(newRoot.left),getHeight(newRoot.right));

        return newRoot;
    }

    public BinaryNode rotateLeft(BinaryNode disbalancedNode){
        BinaryNode newRoot = disbalancedNode.right;
        disbalancedNode.right = disbalancedNode.right.left;
        newRoot.left = disbalancedNode;

        disbalancedNode.height = 1 + Math.max(getHeight(disbalancedNode.left),getHeight(disbalancedNode.right));

        newRoot.height = 1 + Math.max(getHeight(newRoot.left),getHeight(newRoot.right));

        return newRoot;
    }

    public int getBalance(BinaryNode node){
        if(node == null)
            return 0;
        return getHeight(node.left) - getHeight(node.right);
    }

    public BinaryNode insertNode(BinaryNode node, int value){
        if(node == null){
            BinaryNode newNode = new BinaryNode();
            newNode.value = value;
            newNode.height = 1;
            return newNode;
        }
        else if(value <= node.value)
            node.left = insertNode(node.left,value);
        else
            node.right = insertNode(node.right,value);

        node.height = 1 + Math.max(getHeight(node.left),getHeight(node.right));

        int balance = getBalance(node);

        if(balance>1 && value<node.left.value)
            return rotateRight(node);
        else if(balance>1 && value>node.left.value){
            node.left = rotateLeft(node.left);
            return rotateRight(node);
        }else if(balance<-1 && value>node.right.value)
            return rotateLeft(node);
        else if(balance<-1 && value<node.right.value){
            node.right = rotateRight(node.right);
            return rotateLeft(node);
        }

        return node;
    }

    public void insert(int value){
        root = insertNode(root,value);
    }

    public BinaryNode getMinimumNode(BinaryNode node) {
        if (node.left == null)
            return node;
        return getMinimumNode(node.left);
    }

    public BinaryNode deleteNode(BinaryNode node,int value){
        if(node==null){
            System.out.println("Node doesn't exist");
            return null;
        }else if(value<node.value)
            node.left = deleteNode(node.left,value);
        else if(value>node.value)
            node.right = deleteNode(node.right,value);
        else{
            if(node.left!=null && node.right!=null){
                BinaryNode successor = getMinimumNode(node.right);
                node.value = successor.value;
                node.right = deleteNode(node.right, successor.value);
            }
            else if(node.left!=null)
                node = node.left;
            else if(node.right!=null)
                node = node.right;
            else
                node = null;
        }

        int balance = getBalance(node);

        if(balance>1 && getBalance(node.left)>=0)
            return rotateRight(node);
        if(balance>1 && getBalance(node.left)<0){
            node.left = rotateLeft(node.left);
            return rotateRight(node);
        }
        if(balance<-1 && getBalance(node.right)<=0)
            return rotateLeft(node);
        if(balance<-1 && getBalance(node.right)>0){
            node.right = rotateRight(node.right);
            return rotateLeft(node);
        }
        return node;
    }

    public void delete(int value){
        root = deleteNode(root,value);
    }

    public void deleteAVL(int value){
        root=null;
        System.out.println("tree deleted");
    }

    public static void main(String[] args) {
        AVLTree t = new AVLTree();
        t.insert(5);
        t.insert(10);
        t.insert(15);
        t.insert(20);
        t.levelOrder();
        System.out.println();
        t.delete(5);
        t.levelOrder();
        System.out.println();
        System.out.println(t.root.value);
        System.out.println(t.root.height);
    }

}
