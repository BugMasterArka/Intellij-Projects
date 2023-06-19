//problem: https://leetcode.com/problems/remove-duplicates-from-sorted-list/

public class DeleteDuplicates {
    public static Node deleteDuplicates(Node head) {
//        HashSet<Integer> set = new HashSet<>();
//        Node front = head;
//        Node prev=null;
//        while(front!=null){
//            if(!set.add(front.val)){
//                prev.next=front.next;
//            }else{
//                prev=front;
//            }
//            front=front.next;
//        }
//        return head;
        if(head==null || head.next==null)
            return head;
        Node a = head;
        Node b = head.next;
        while(a!=null){
            if(b!=null){
                if(b.val==a.val){
                    b=b.next;
                    a.next=b;
                }else{
                    a=a.next;
                    b=b.next;
                }
            }else
                break;
        }
        return head;
    }

    public static void main(String[] args) {
        Node head = new Node(1);
        head.next = new Node(1);
        head.next.next = new Node(2);
        head.next.next.next = new Node(3);
        head.next.next.next.next = new Node(3);

        Node out = deleteDuplicates(head);
    }
}
