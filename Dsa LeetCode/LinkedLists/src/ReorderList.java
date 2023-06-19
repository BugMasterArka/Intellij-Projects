//problem: https://leetcode.com/problems/reorder-list/

public class ReorderList {

    static Node head;
    public static Node reverseList(Node head) {
        if(head==null)
            return null;
        Node c = head;
        Node head2 = null;
        Node prev=null;
        Node next=null;
        while(c.next!=null){
            c=c.next;
        }
        head2=c;
        c = head;
        while(c!=null){
            next=c.next;
            c.next=prev;
            prev=c;
            c=next;
        }

        return head2;
    }
    public static void reorderList(Node head) {
        Node slow = head;
        Node fast = head;
        while(fast.next!=null && fast.next.next!=null){
            slow=slow.next;
            fast=fast.next.next;
        }
        Node head2 = slow.next;
        slow.next=null;
        head2 = reverseList(head2);
        Node c = head;
        while(c!=null && head2!=null){
            Node now = head2;
            head2=head2.next;
            now.next = c.next;
            c.next = now;
            c = c.next.next;
        }
    }

    static void display(){
        if(head==null){
            System.out.println("empty list");
            return;
        }
        Node c = head;
        while(c!=null){
            System.out.print(c.val+" -> ");
            c=c.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(4);
//        head.next.next.next.next = new Node(5);

        reorderList(head);

        display();
    }
}
