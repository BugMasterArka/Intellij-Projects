public class InsertionCSLL {
    static Node head;
    static Node tail;
    static int size=0;

    static void insert(int value,int location){
        Node newNode = new Node();
        newNode.value=value;
        if(head==null){
            head=tail=newNode;
            newNode.next=newNode;
        }
        else if(location==0){
            newNode.next=head;
            head=newNode;
            tail.next=head;
        }
        else if(location>=size){
            newNode.next=head;
            tail.next=newNode;
            tail=newNode;
        }else{
            Node c = head;
            int index=0;
            while(index!=location-1){
                c=c.next;
                index++;
            }
            newNode.next=c.next;
            c.next=newNode;
        }
        size++;
    }
}
