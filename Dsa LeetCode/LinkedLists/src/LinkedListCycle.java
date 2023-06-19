//problem: https://leetcode.com/problems/linked-list-cycle/

public class LinkedListCycle {
    public boolean hasCycle(Node head) {
        Node walker=head;
        Node runner=head;
        while(runner!=null && runner.next!=null){
            if(runner==walker)
                return true;
            runner=runner.next.next;
            walker=walker.next;
        }
        return false;
    }
}
