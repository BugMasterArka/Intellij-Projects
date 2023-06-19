public class SearchingSinglyLinkedList {
    static Node head;
    static Node tail;
    static void search(int value){
        if(head==null){
            System.out.println("Empty list");
            return;
        }
        Node c = head;
        while (c!=null){
            if(c.value==value){
                System.out.println("found");
                return;
            }
            c=c.next;;
        }
        System.out.println("not found");
    }
}
