//problem: https://leetcode.com/problems/merge-k-sorted-lists/description/

//beats only 11.90%
//can be improved
public class MergeKSortedLists {
    public Node mergeKLists(Node[] lists) {
        if(lists.length==0)
            return null;
        Node main_head=lists[0];
        for(int i=1;i<lists.length;i++){
            Node curListHead = lists[i];
            while(curListHead!=null){
                Node main_temp = main_head;
                Node prev = null;
                while(main_temp!=null){
                    if(main_temp.val>curListHead.val)
                        break;
                    prev=main_temp;
                    main_temp = main_temp.next;
                }

                Node extracted = curListHead;
                curListHead = curListHead.next;

                extracted.next = main_temp;
                if(prev!=null)
                    prev.next=extracted;
                else
                    main_head=extracted;
            }
        }
        return main_head;
    }
}
