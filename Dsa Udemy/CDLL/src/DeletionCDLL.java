public class DeletionCDLL {
    static DoubleNode head;
    static DoubleNode tail;
    static int size=0;

    static void delete(int location){
        if(head==null){
            System.out.println("empty list");
            return;
        }
        else if(head==tail){
            head.prev=null;
            head.next=null;
            head=null;
            tail=null;
        }
        else if(location==0){
            head=head.next;
            head.prev=tail;
            tail.next=head;
        }
        else if(location>=size){
            tail=tail.prev;
            tail.next=head;
            head.prev=tail;
        }
        else{
            DoubleNode c = head;
            int index=0;
            while(index!=location-1){
                c=c.next;
                index++;
            }
            c.next=c.next.next;
            c.next.prev=c;
        }
        size--;
    }
}
