//problem: https://leetcode.com/problems/delete-node-in-a-linked-list/description/

public class DeleteANodeInList {
    public void deleteNode(Node node) {
        Node cur = node;
        Node prev = null;
        while(cur.next!=null){
            cur.val = cur.next.val;
            prev = cur;
            cur=cur.next;
        }
        prev.next=null;
    }
}
