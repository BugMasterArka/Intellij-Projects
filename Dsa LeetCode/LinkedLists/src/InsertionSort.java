//problem: https://leetcode.com/problems/insertion-sort-list/description/

public class InsertionSort {

    static Node head;

//    wrong solution

//    public static Node insertionSortList(Node head) {
//        Node dummy = new Node(Integer.MIN_VALUE,head);
//        Node prev_d = head;
//        Node d = head.next;
//        boolean swapped;
//        while(d!=null){
//            Node prev = dummy;
//            Node c = dummy.next;
//            swapped = false;
//            while(c!=null){
//                if(d.val<c.val){
//                    Node cur = d;
//                    d=d.next;
//                    prev_d.next=cur.next;
//                    cur.next=c;
//                    prev.next=cur;
//                    swapped=true;
//                    break;
//                }
//                prev=c;
//                c=c.next;
//            }
//            if(!swapped){
//                prev_d = d;
//                d=d.next;
//            }
//
//        }
//        return dummy.next;
//    }


//    right solution but slow
//    can be improved
    public static Node insertionSort(Node head){
        Node dummy = new Node(Integer.MAX_VALUE);

        while(head!=null){
            Node cur = head;
            head=head.next;
            cur.next=null;
            Node temp = dummy;
            while(temp!=null){
                if(dummy.next==null){
                    dummy.next=cur;
                    break;
                }
                else if(temp.next!=null){
                    if(temp.next.val>cur.val){
                        cur.next=temp.next;
                        temp.next=cur;
                        break;
                    }else{
                        temp=temp.next;
                    }
                }else{
                    temp.next=cur;
                    break;
                }
            }
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
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(4);
//        head.next.next.next.next = new Node(0);

        display();

        head = insertionSort(head);

        display();
    }
}
