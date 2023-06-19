public class SortList {

    static boolean isDone = false;
    public static Node extractMinNode(Node head){
        Node dummy = new Node(Integer.MIN_VALUE,head);
        Node prevToMin = dummy;
        Node min = head;
        Node prev = dummy;
        Node cur = dummy.next;
        while(cur!=null){
            if(cur.val<min.val){
                min=cur;
                prevToMin = prev;
            }
            prev = cur;
            cur=cur.next;
        }
        prevToMin.next=min.next;
        if(dummy.next==null)
            isDone=true;
        min.next=null;

        return min;
    }
    public static Node sortList(Node head) {
        Node dummy = new Node(Integer.MAX_VALUE,head);
        Node sorted = dummy;
        Node unsorted = dummy.next;
        while(unsorted!=null){
            Node extracted = extractMinNode(unsorted);
            if(isDone){
                unsorted=null;
            }
            sorted.next=extracted;
            sorted=extracted;
        }
        return dummy.next;
    }

    public static Node sortList2(Node head){
        Node dummy = new Node(Integer.MAX_VALUE,head);
        Node sorted = dummy;
        Node unsorted = dummy.next;
        while(unsorted!=null){
            Node dummy2 = new Node(Integer.MIN_VALUE,unsorted);
            Node prevToMin = dummy2;
            Node min = head;
            Node prev = dummy2;
            Node cur = dummy2.next;
            while(cur!=null){
                if(cur.val<min.val){
                    min=cur;
                    prevToMin = prev;
                }
                prev = cur;
                cur=cur.next;
            }
            prevToMin.next=min.next;
            if(head==min)
                head=head.next;
            if(dummy2.next==null)
                head = unsorted = null;
            min.next=null;
            sorted.next=min;
            sorted=min;
        }
        return dummy.next;
    }

    static void display(Node head){
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

//        Node head = new Node(4);
//        head.next = new Node(2);
//        head.next.next = new Node(1);
//        head.next.next.next = new Node(3);

        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(4);


        display(head);

        head = sortList2(head);

        display(head
        );
    }
}
