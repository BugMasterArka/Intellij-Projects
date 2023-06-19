public class ListDeletionCDLL {
    static DoubleNode head;
    static DoubleNode tail;
    static int size=0;

    static void deleteList(){
        head.prev=null;
        tail.next=null;
        DoubleNode c = head;
        while(c!=null){
            c.prev=null;
            c=c.next;
        }
        head=null;
        tail=null;
        System.out.println("list deleted");
    }
}
