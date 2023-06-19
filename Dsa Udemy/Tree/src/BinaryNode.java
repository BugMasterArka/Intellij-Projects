public class BinaryNode {
    int value;
    BinaryNode left;
    BinaryNode right;

    public BinaryNode(int value){
        this.value = value;
    }

    public void connect(BinaryNode left, BinaryNode right){
        this.left=left;
        this.right=right;
    }
}
