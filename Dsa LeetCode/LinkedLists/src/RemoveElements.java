//problem: https://leetcode.com/problems/remove-linked-list-elements/description/

public class RemoveElements {
    public Node removeElements(Node head, int val) {
        Node c = head;
        Node prev = null;
        while(c!=null){
            if(c.val==val){
                if(prev!=null)
                    prev.next=c.next;
                else
                    head=head.next;
            }
            else{
                prev=c;
            }
            c=c.next;
        }
        return head;
    }
}
