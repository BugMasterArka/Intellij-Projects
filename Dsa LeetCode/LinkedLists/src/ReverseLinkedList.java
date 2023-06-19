//problem: https://leetcode.com/problems/reverse-linked-list/

public class ReverseLinkedList {

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

        head = reverseList(head);

        display();
    }
}
