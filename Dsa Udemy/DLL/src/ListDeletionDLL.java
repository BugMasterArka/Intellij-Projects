public class ListDeletionDLL {
    static DoubleNode head;
    static DoubleNode tail;
    static int size=0;

    static void deleteList(){
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
