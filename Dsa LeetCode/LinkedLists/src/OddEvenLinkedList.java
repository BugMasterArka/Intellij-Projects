//problem: https://leetcode.com/problems/odd-even-linked-list/description/

public class OddEvenLinkedList {
    public Node oddEvenList(Node head) {
        Node oddHead = new Node(Integer.MIN_VALUE);
        Node odd = oddHead;
        Node evenHead = new Node(Integer.MAX_VALUE);
        Node even = evenHead;
        int index=1;
        while(head!=null){
            Node extracted = head;
            head = head.next;
            extracted.next=null;
            if(index%2==0){
                even.next = extracted;
                even = extracted;
            }else{
                odd.next = extracted;
                odd = extracted;
            }
            index++;
        }
        odd.next = evenHead.next;
        return oddHead.next;
    }
}
