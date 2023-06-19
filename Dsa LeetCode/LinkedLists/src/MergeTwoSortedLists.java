//problem: https://leetcode.com/problems/merge-two-sorted-lists/


public class MergeTwoSortedLists {
    public static Node mergeTwoLists(Node list1, Node list2) {

//        checking edge cases
        if(list1==null && list2==null)
            return null;
        if(list1==null)
            return list2;
        if(list2==null)
            return list1;

//        iterating till 2nd list is empty
        while(list2!=null){
            Node head = list1;
            Node prev=null;

//            checking where in 1st list we should put first node of 2nd list
            while(head!=null){
                if(head.val>list2.val)
                    break;
                prev=head;
                head=head.next;
            }

//            extracting first node of 2nd list
            Node extract = list2;
            list2=list2.next;

//            putting connections
            extract.next=head;
            if(prev!=null)
                prev.next=extract;
            else
                list1=extract;
        }
        return list1;
    }

//    public static Node merge(Node list1, Node list2){
//        Node a = list1;
//        Node b = list2;
//        Node
//    }

    public static void main(String[] args) {
        Node head1 = new Node(1);
        head1.next = new Node(2);
        head1.next.next = new Node(4);

        Node head2 = new Node(1);
        head2.next = new Node(3);
        head2.next.next = new Node(4);

        Node out = mergeTwoLists(head1,head2);

    }
}

//    Node c1 = list1;
//    Node c2 = list2;
//    Node c = null;
//        while(c1!=null || c2!=null){
//                Node temp = null;
//                if(c1.val<c2.val){
//        temp=c1;
//        c1=c1.next;
//        }else{
//        temp=c2;
//        c2=c2.next;
//        }
//        if(c==null)
//        c=temp;
//        else{
//        Node d = c;
//        while(d.next!=null)
//        d=d.next;
//        d.next=temp;
//        }
//        }
//        if(c1!=null){
//        while (c1!=null){
//        Node temp = c1;
//        Node d = c;
//        while(d.next!=null)
//        d=d.next;
//        d.next=temp;
//        c1=c1.next;
//        }
//        }else if(c2!=null)
