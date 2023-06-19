import java.util.Arrays;

public class BinaryTree {
    static int startIndex = 1;
    public int[] arr = null;
    int lastUsedIndex;

    public BinaryTree(int size){
        this.lastUsedIndex = 0;
        this.arr = new int[size+1];
        Arrays.fill(this.arr,Integer.MIN_VALUE);
    }

    public boolean isFull(){
        return (lastUsedIndex+1) == arr.length;
    }

    public void insert(int value){
        if(!isFull()){
            arr[++lastUsedIndex]=value;
            return;
        }
        System.out.println("full");
    }

    public void preOrder(int index){
        System.out.print(arr[index]+" ");
        if(index*2<=lastUsedIndex) preOrder(index*2);
        if((index*2)+1<=lastUsedIndex) preOrder((index*2)+1);
    }

    public void inOrder(int index){
        if(index*2<=lastUsedIndex) inOrder(index*2);
        System.out.print(arr[index]+" ");
        if((index*2)+1<=lastUsedIndex) inOrder((index*2)+1);
    }

    public void postOrder(int index){
        if(index*2<=lastUsedIndex) postOrder(index*2);
        if((index*2)+1<=lastUsedIndex) postOrder((index*2)+1);
        System.out.print(arr[index]+" ");
    }

    public void levelOrder(){
        for (int i=startIndex;i<=lastUsedIndex;i++){
            System.out.print(this.arr[i]+" ");
        }
        System.out.println();
    }

    public int search(int key){
        for(int i=startIndex;i<=lastUsedIndex;i++){
            if(this.arr[i]==key)
                return i;
        }
        return -1;
    }

    public void delete(int value){
        int loc = search(value);
        if(loc!=-1){
            this.arr[loc]=this.arr[lastUsedIndex];
            this.arr[lastUsedIndex--]=Integer.MIN_VALUE;
        }else
            System.out.println("node doesn't exist");
    }

    public void deleteTree(){
        this.arr=null;
        System.out.println("tree deleted");
    }

    public static void main(String[] args) {
        BinaryTree t = new BinaryTree(9);
        t.insert(1);
        t.insert(2);
        t.insert(3);
        t.insert(4);
        t.insert(5);
        t.insert(6);
        t.insert(7);
        t.insert(8);
        t.insert(9);
        t.preOrder(startIndex);
        System.out.println();
        t.inOrder(startIndex);
        System.out.println();
        t.postOrder(startIndex);
        System.out.println();
        t.levelOrder();
        System.out.println(t.search(5));
        t.delete(3);
        t.preOrder(startIndex);
    }

}