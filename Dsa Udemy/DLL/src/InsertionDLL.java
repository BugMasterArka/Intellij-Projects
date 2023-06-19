public class InsertionDLL {
    static DoubleNode head;
    static DoubleNode tail;
    static int size=0;

    static void insert(int value, int location){
        DoubleNode node =  new DoubleNode(value);
        if(head==null)
            head=tail=node;
        else if(location==0){
            head.prev=node;
            node.next=head;
            head=node;
        }
        else if(location>=size){
            tail.next=node;
            node.prev=tail;
            tail=node;
        }
        else{
            DoubleNode c = head;
            int index=0;
            while(index!=location-1){
                c=c.next;
                index++;
            }
            node.next=c.next;
            node.prev=c;
            c.next.prev=node;
            c.next=node;
        }
        size++;
    }
}
