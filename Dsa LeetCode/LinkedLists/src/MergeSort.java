public class MergeSort {
    public static Node findMid(Node head){
        Node slow = head;
        Node fast = head;
        while(fast.next!=null && fast.next.next!=null){
            slow=slow.next;
            fast=fast.next.next;
        }
        return slow;
    }

    public static Node mergeSort(Node head){
        if(head==null || head.next==null)
            return head;

        Node mid = findMid(head);

        Node left = head;
        Node right = mid.next;
        mid.next = null;

        left = mergeSort(left);
        right = mergeSort(right);

        return merge(left,right);
    }

    public static Node merge(Node left,Node right){

        if(left==null)
            return right;

        if(right==null)
            return left;

        Node c1 = left;
        Node c2 = right;
        Node dummy = new Node(Integer.MIN_VALUE);
        Node temp = dummy;
        Node cur = null;

        while(c1!=null && c2!=null){
            if(c1.val<c2.val){
                cur=c1;
                c1=c1.next;
            }else{
                cur=c2;
                c2=c2.next;
            }
            temp.next=cur;
            temp=cur;
        }

        while(c1!=null){
            temp.next=c1;
            temp=c1;
            c1=c1.next;
        }

        while(c2!=null){
            temp.next=c2;
            temp=c2;
            c2=c2.next;
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
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(4);

        display(head);

        head = mergeSort(head);

        display(head);
    }
}
