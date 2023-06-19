public class ReorderList {
    static Node head;
    static Node tail;

    static void insert(int value){
        Node newNode = new Node(value);
        if(head==null)
            head=tail=newNode;
        else{
            tail.next=newNode;
            tail=newNode;
        }
    }

    static void display(){
        if(head==null)
            System.out.println("empty list");
        else{
            Node c = head;
            while(c!=null){
                System.out.print(c.value+" ");
                c=c.next;
            }
            System.out.println();
        }
    }

    static Node reverse(Node start){
        if(start==null)
            return null;
        Node temp = null;
        Node cur = start;
        while(cur!=null){
            Node nextNode = cur.next;
            cur.next = temp;
            temp = cur;
            if(nextNode!=null)
                cur = nextNode;
            else{
                return cur;
            }
        }
        return null;
    }

    static Node findMiddle(Node head){
        if(head==null)
            return null;
        Node slow = head;
        Node fast = head;
        while(fast!=null && fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;
        }
        Node temp = slow.next;
        slow.next=null;
        return temp;
    }

    static void reorder(){
        Node newHead = findMiddle(head);
        newHead = reverse(newHead);
        Node c = head;
        while(newHead!=null){
            Node extracted = newHead;
            newHead = newHead.next;

            extracted.next = c.next;
            c.next = extracted;

            c=c.next.next;
        }
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
