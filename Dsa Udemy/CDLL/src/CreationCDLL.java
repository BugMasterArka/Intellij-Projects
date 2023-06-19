public class CreationCDLL {
    static DoubleNode head;
    static DoubleNode tail;
    static int size=0;

    static void create(int value){
        DoubleNode node = new DoubleNode(value);
        head=node;
        tail=node;
        node.prev=node;
        node.next=node;
    }
}
