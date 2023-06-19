public class CreationCSLL {
    static Node head;
    static Node tail;
    static int size=0;
    static void create(int value){
        Node newNode = new Node();
        newNode.value=value;
        newNode.next=newNode;
        head=newNode;
        tail=newNode;
        size++;
    }
}
