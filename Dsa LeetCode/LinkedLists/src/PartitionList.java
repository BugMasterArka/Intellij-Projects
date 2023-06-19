//problem: https://leetcode.com/problems/partition-list/

import java.util.ArrayList;

public class PartitionList {
    static Node head;

//    wrong solution

//    public static Node partition(Node head, int x) {
//        Node c = head;
//        ArrayList<Node> nodes = new ArrayList<>();
//        Node dummy = new Node(Integer.MIN_VALUE,head);
//        Node prev = dummy;
//        while(c!=null){
//            if(c.val<x){
//                prev.next=c.next;
//                if(prev.val==Integer.MIN_VALUE)
//                    head=head.next;
//                nodes.add(c);
//            }
//            else
//                prev=prev.next;
//            c=c.next;
//        }
//        prev = dummy;
//        c = head;
//        while(c!=null && !nodes.isEmpty()){
//            Node cur = nodes.remove(0);
//            if(cur.val<c.val){
//                cur.next=prev.next;
//                prev.next=cur;
//                prev=prev.next;
//            }else{
//                c=c.next;
//            }
//        }
//        return dummy.next;
//    }


//    solution: https://www.youtube.com/watch?v=K5AVJVjdmL0
    static Node partition(Node head, int x){
        Node before_head = new Node(Integer.MIN_VALUE);
        Node before = before_head;
        Node after_head = new Node(Integer.MIN_VALUE);
        Node after = after_head;

        while(head!=null){
            if(head.val<x){
                before.next=head;
                before=before.next;
            }else{
                after.next=head;
                after=after.next;
            }
            head=head.next;
        }

        after.next=null;
        before.next=after_head.next;

        return before_head.next;
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
        head.next = new Node(4);
        head.next.next = new Node(3);
        head.next.next.next = new Node(2);
        head.next.next.next.next = new Node(5);
        head.next.next.next.next.next = new Node(2);

        head = partition(head,3);

        display();
    }
}
