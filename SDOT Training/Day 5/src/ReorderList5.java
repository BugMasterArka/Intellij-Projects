

public class ReorderList5 {
    static Node head;
    static void reorder(){
        Node slow = head;
        Node fast = head.next;
        while(fast!=null && fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;
        }
        Node head2 = slow.next;
        slow.next=null;

        Node temp = head;
        while(temp.next!=null)
            temp=temp.next;
        Node lastUsed=temp;
        while(lastUsed!=head){
            Node c = head;
            while(c.next!=lastUsed){
                c=c.next;
            }
            Node cur = head2;
            head2=head2.next;

            cur.next=c.next;
            c.next=cur;
            lastUsed=c;
        }
    }

    static void insert(int value){
        Node newNode = new Node();
        newNode.value=value;
        newNode.next=null;
        if(head==null)
            head=newNode;
        else{
            Node c = head;
            while(c.next!=null)
                c=c.next;
            c.next=newNode;
        }
    }

    static void display(){
        if(head==null){
            System.out.println("Empty list");
            return;
        }
        Node c =head;
        while(c!=null){
            System.out.print(c.value+" -> ");
            c=c.next;
        }
        System.out.println();
    }
    public static void main(String[] args) {
        insert(1);
        insert(2);
        insert(3);
        insert(4);
//        insert(5);
        display();
        reorder();
        display();
    }
}
