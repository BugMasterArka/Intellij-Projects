//problem:https://leetcode.com/problems/remove-nth-node-from-end-of-list/description/


//solution: https://www.youtube.com/watch?v=XtYEEvrhemI

//same logic used but didnt work
public class RemoveNthFromEnd {

    static Node head;
    public static Node remove(Node head, int n) {
//        if(head==null)
//            return null;
//        int index=0;
//        Node c = head;
//        Node d = head;
//        while(index!=n+1){
//            d=d.next;
//            index++;
//        }
//        while(d!=null){
//            c=c.next;
//            d=d.next;
//        }
//        c.next=c.next.next;
//        return head;

//        if(head==null || head.next==null)
//            return null;
//        int index=0;
//        Node c = head;
//        Node d = head;
//        while(index!=n && d!=null){
//            d=d.next;
//            index++;
//        }
//        while(d!=null && d.next!=null){
//            c=c.next;
//            d=d.next;
//        }
//        if(c==head)
//            head=head.next;
//        else
//            c.next=c.next.next;
//        return head;

        Node new_head = new Node(0);
        new_head.next = head;

        Node slow = new_head;
        Node fast = new_head;

        for(int i=1;i<=n+1;i++){
            fast=fast.next;
        }

        while(fast!=null){
            slow=slow.next;
            fast=fast.next;
        }
        slow.next=slow.next.next;

        return new_head.next;
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
//        head.next.next = new Node(3);
//        head.next.next.next = new Node(4);
//        head.next.next.next.next = new Node(5);
        display();
        Node out = remove(head,2);
        display();
    }
}
