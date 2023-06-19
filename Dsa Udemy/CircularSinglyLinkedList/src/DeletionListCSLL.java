public class DeletionListCSLL {
    static Node head;
    static Node tail;
    static int size=0;

    static void deleteList(){
        tail.next=null;
        head=null;
        tail=null;
        System.out.println("list deleted");
    }
}
