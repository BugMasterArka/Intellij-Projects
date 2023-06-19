//problem: https://leetcode.com/problems/swap-nodes-in-pairs/description/

public class SwapNodesInPairs {
    public Node swapPairs(Node head) {
        if(head==null || head.next==null)
            return head;
        int index=1;
        Node cur=head;
        Node prevToPair=null;
        Node prevToCur=null;
        while(cur!=null){
            if(index%2==0){
                prevToCur.next=cur.next;
                cur.next=prevToCur;
                if(prevToPair!=null){
                    prevToPair.next=cur;
                }
                prevToCur=cur;
                if(prevToPair==null){
                    head=cur;
                }
                cur=cur.next;
                prevToPair=cur;
                index++;
            }else{
                prevToCur=cur;
                index++;
            }
            cur=cur.next;
        }
        return head;
    }
}
