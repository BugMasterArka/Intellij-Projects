
// a hashset takes only unique values. Therefore, if the value is already present it will return false;

public class ReturnNthToLast {
    public Node nthToLast(LinkedList ll,int key){
        int location = ll.size - key;
        int index=0;
        Node c = ll.head;
        while(index!=location){
            c=c.next;
            index++;
        }
        return c;
    }
}

//using 2 pointers
//we first distance the 2 pointers by the amount of distance provided in the key
//then we move them together
//when moving together, when the 2nd pointer reaches end the 1st pointer will be at the nth element from last

// Node p1 = ll.head;
//         Node p2 = ll.head;
//         for(int i=0;i<key;i++){
//             if(p2==null)
//                 return null;
//             p2 = p2.next;
//         }
//         while(p2!=null){
//             p1=p1.next;
//             p2=p2.next;
//         }
//         return p1;
