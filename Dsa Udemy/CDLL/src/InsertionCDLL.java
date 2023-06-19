public class InsertionCDLL {
    static DoubleNode head;
    static DoubleNode tail;
    static int size=0;

    static void insert(int value, int location){
        DoubleNode node = new DoubleNode(value);
        if(head==null){
            head=tail=node;
            node.next=node;
            node.prev=node;
        }
        else if(location==0){
            node.next=head;
            node.prev=tail;
            tail.next=node;
            head.prev=node;
            head=node;
        }
        else if(location>=size){
            node.next=head;
            node.prev=tail;
            tail.next=node;
            head.prev=node;
            tail=node;
        }else{
            DoubleNode c = head;
            int index=0;
            while(index!=location-1){
                c=c.next;
                index++;
            }
            node.prev=c;
            node.next=c.next;
            c.next.prev=node;
            c.next=node;
        }
        size++;
    }
}
