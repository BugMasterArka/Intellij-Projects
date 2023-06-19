public class ReverseDLL {
    static DoubleNode head;
    static DoubleNode tail;
    static int size=0;

    static void insert(int value, int location){
        DoubleNode node = new DoubleNode(value);
        if(head==null){
            head=tail=node;
        }
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
    static void display(){
        if(head==null){
            System.out.println("empty list");
            return;
        }
        DoubleNode c = head;
        while(c!=null){
            System.out.print(c.value+" -> ");
            c=c.next;
        }
        System.out.println();
    }

    static void reverse(){
        DoubleNode temp=null;
        DoubleNode c = head;
        while(c!=null){
            temp=c.next;
            c.next=c.prev;
            c.prev=temp;
            c=c.prev;
        }
        temp=head;
        head=tail;
        tail=temp;
    }

    public static void main(String[] args) {
        insert(1,0);
        display();
        insert(2,1);
        display();
        insert(3,0);
        display();
        insert(4,2);
        display();
        insert(5,8);
        display();
        reverse();
        display();
    }
}
