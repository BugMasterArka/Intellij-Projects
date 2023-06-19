public class ElementDeletionCSLL {
    static Node head;
    static Node tail;
    static int size=0;

    static void delete(int location){
        if(head==null)
            System.out.println("empty list");
        else if(head==tail){
            head.next=null;
            head=null;
            tail=null;
        }
        else if(location == 0){
            head=head.next;
            tail.next=head;
        }
        else if(location>=size){
            Node c = head;
            while(c.next!=tail)
                c=c.next;
            tail=c;
            tail.next=head;
        }
        else{
            Node c = head;
            int index=0;
            while(index!=location-1){
                c=c.next;
                index++;
            }
            c.next=c.next.next;
        }
        size--;
    }
}
