//problem: https://leetcode.com/problems/rotate-list/description/

public class RotateList {
    static Node head;

    public static Node getNthNode(Node head, int k){
        Node new_head = new Node(Integer.MIN_VALUE);
        new_head.next = head;

        Node slow = new_head;
        Node fast = new_head;

        for(int i=1;i<=k+1;i++)
            fast=fast.next;

        // Node toReturn = fast.next;
        // fast.next=null;
        while(fast!=null){
            slow=slow.next;
            fast=fast.next;
        }

        Node toReturn = slow.next;
        slow.next = null;

        return toReturn;
    }

// i=   1  2  3

//     -1->1->2->3->4->5->6   k=2
//                          f
//                  s

    public static Node rotateRight(Node head, int k) {
        if(head==null || head.next==null || k==0)
            return head;
        Node temp = head;
        int len=0;
        while(temp!=null){
            len++;
            temp=temp.next;
        }

        if(k%len==0)
            return head;

        Node toRotate = getNthNode(head,k%len);
        Node newListCur = toRotate;
        while(newListCur.next!=null)
            newListCur = newListCur.next;

        newListCur.next = head;
        head = toRotate;

        return head;
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
//        head.next.next.next.next.next = new Node(6);
        display();
        head = rotateRight(head,2);
        display();
    }
}
