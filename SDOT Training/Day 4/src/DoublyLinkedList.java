public class DoublyLinkedList {
    static DoubleNode head=null;
    static int size=0;

    static void insert(int value, int location){
        DoubleNode newNode = new DoubleNode(value);
        if(head==null)
            head=newNode;
        else{
            if(location==0){
                head.prev=newNode;
                newNode.next=head;
                head=newNode;
            }else if(location>=size){
                DoubleNode c = head;
                while(c.next!=null)
                    c=c.next;
                c.next=newNode;
                newNode.prev=c;
            }else{
                DoubleNode c = head;
                int index=0;
                while(index!=location-1){
                    c=c.next;
                    index++;
                }
                newNode.next=c.next;
                c.next.prev=newNode;
                c.next=newNode;
                newNode.prev=c;
            }
        }
        size++;
    }

    static void display(){
        if (head==null)
            System.out.println("Empty list");
        DoubleNode c = head;
        while(c!=null){
            System.out.print(c.value+" -> ");
            c=c.next;
        }
        System.out.println();
    }

    static void delete(int location){
        if(head==null)
            System.out.println("Empty list");
        else{
            if(location==0){
                DoubleNode temp = head;
                head.next.prev = null;
                head = head.next;
                temp=null;
            }else if(location>=size){
                DoubleNode c = head;
                while(c.next.next!=null)
                    c=c.next;
                c.next.prev=null;
                c.next=null;
            }else{
                DoubleNode c = head;
                int index = 0;
                while(index!=location){
                    c=c.next;
                    index++;
                }
                if(c.next!=null)
                    c.next.prev=c.prev;
                if(c.prev!=null)
                    c.prev.next=c.next;
                c.next=null;
                c.prev=null;
                c=null;
            }
        }
    }

    public static void main(String[] args) {
        insert(1,0);
        display();
        insert(2,1);
        display();
        insert(3,0);
        display();
        insert(4,7);
        display();
        insert(5,2);
        display();
        delete(0);
        display();
        delete(9);
        display();
        delete(2);
        display();
        delete(0);
        display();
        delete(0);
    }
}
