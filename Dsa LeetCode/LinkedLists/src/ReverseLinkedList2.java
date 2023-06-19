//problem: https://leetcode.com/problems/reverse-linked-list-ii/description/

public class ReverseLinkedList2 {

    public static Node reverseBetween(Node head, int left, int right){
        if(head==null || head.next==null)
            return head;
        Node startPrev = null;
        Node start = null;
        Node end = null;
        int index=1;
        Node cur=head;
        while(cur!=null){
            if(index+1==left)
                startPrev=cur;
            if(index==left)
                start=cur;
            if(index==right)
                end = cur;
            cur=cur.next;
            index++;
        }
        if(startPrev!=null)
            startPrev.next=null;
        Node outHead = reverse(start,end);
        if(startPrev!=null)
            startPrev.next=outHead;
        else
            head=outHead;
        return head;
    }


    public static Node reverse(Node start,Node end){
        Node prev=null;
        Node cur=start;
        Node next=null;
        Node nextToEnd = end.next;
        while(cur!=nextToEnd){
            next=cur.next;
            cur.next=prev;
            prev=cur;
            cur=next;
        }
        start.next=cur;
        return end;
    }

    public static void display(Node head){
        if(head==null)
            System.out.println("empty list");
        else{
            Node c = head;
            while(c!=null){
                System.out.print(c.val+" ");
                c=c.next;
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(4);
        head.next.next.next.next = new Node(5);


        head = reverseBetween(head,2,5);
        display(head);
    }
}
