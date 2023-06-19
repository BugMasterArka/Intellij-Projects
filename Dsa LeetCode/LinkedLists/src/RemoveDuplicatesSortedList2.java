// problem: https://leetcode.com/problems/remove-duplicates-from-sorted-list-ii/description/

//solution: https://www.youtube.com/watch?v=9iJ3UsB9vMo

public class RemoveDuplicatesSortedList2 {
    static Node head;
//    doesn't work for all testcases
//    public static Node deleteDuplicates(Node head) {
//        Node c = head;
//        Node prev = null;
//        int cur = Integer.MIN_VALUE;
//        while(c!=null){
//            if(c.val!=cur){
//                if(prev!=null)
//                    prev.next=c;
//                else
//                    head=c;
//                cur=c.val;
//                if(c.next!=null && c.val!=c.next.val)
//                    prev=c;
//                c=c.next;
//            }else{
//                if(prev==null)
//                    head=c.next;
//                c=c.next;
//            }
//
//        }
//        return head;
//    }

    public static Node deleteDuplicates2(Node head){
        Node dummy = new Node(-1);
        dummy.next = head;
        Node prev = dummy;

        while(head!=null){
            if(head.next!=null && head.val==head.next.val){
                while(head.val==head.next.val)
                    head=head.next;
                prev.next=head.next;
            }
            else{
                prev=prev.next;
            }
            head=head.next;
        }
        return dummy.next;
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
        head.next = new Node(1);
//        head.next.next = new Node(2);
//        head.next.next.next = new Node(3);
//        head.next.next.next.next = new Node(3);
//        head.next.next.next.next.next = new Node(4);
//        head.next.next.next.next.next.next = new Node(4);
//        head.next.next.next.next.next.next.next = new Node(5);

        head=deleteDuplicates2(head);

        display();

    }

}
