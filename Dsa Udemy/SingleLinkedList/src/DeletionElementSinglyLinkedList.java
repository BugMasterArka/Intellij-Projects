public class DeletionElementSinglyLinkedList {
    static Node head;
    static Node tail;
    static int size;

    static void delete(int location){
        if(head==null){
            System.out.println("Empty List");
            return;
        }
        else if(head==tail){
            head=tail=null;
            return;
        }
        else if(location==0){
            head=head.next;
        }else if(location>=size){
            Node c = head;
            while(c.next!=tail){
                c=c.next;
            }
            tail=c;
            tail.next=null;
        }else{
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
