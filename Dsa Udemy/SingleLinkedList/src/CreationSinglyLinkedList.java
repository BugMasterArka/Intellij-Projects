public class CreationSinglyLinkedList {
    static Node head=null;
    static Node tail=null;
    static int size=0;

    static void createSLL(int value){
        Node newNode = new Node();
        newNode.value=value;
        newNode.next=null;
        head=newNode;
        tail=newNode;
        size++;
    }

    public static void main(String[] args) {
        createSLL(5);
        System.out.println(head.value);
    }
}
