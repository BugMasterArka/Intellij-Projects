public class TraversalSinglyLinkedList {
    static Node head;
    static Node tail;
    static void traverse(){
        if(head==null){
            System.out.println("Empty list");
            return;
        }
        Node c = head;
        while(c!=null){
            System.out.print(c.value+" -> ");
        }
        System.out.println();
    }
}
