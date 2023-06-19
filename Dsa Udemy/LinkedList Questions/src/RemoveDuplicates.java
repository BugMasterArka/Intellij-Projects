import java.util.HashSet;
import java.util.Set;

public class RemoveDuplicates {
    public void deleteDups(LinkedList ll){
        Set<Integer> set = new HashSet<>();
        Node c = ll.head;
        Node prev = null;
        while(c!=null){
            if(!set.add(c.value)){
                prev.next=c.next;
                ll.size--;
            }
            prev = c;
            c=c.next;
        }
    }
}
