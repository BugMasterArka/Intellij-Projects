//problem: https://leetcode.com/problems/intersection-of-two-linked-lists/description/

public class IntersectionOfTwoLists {
    public Node getKthNode(Node a,int size){
        while(size>0 && a!=null){
            a=a.next;
            size--;
        }
        return a;
    }
    public Node getIntersectionNode(Node headA, Node headB) {
        // int l1=0;
        // int l2=0;
        // Node a = headA;
        // Node b = headB;
        // while(a!=null){
        //     l1++;
        //     a=a.next;
        // } 
        // while(b!=null){
        //     l2++;
        //     b=b.next;
        // }
        // if(l1>l2){
        //     a=headA;
        //     b=headB;
        // }else{
        //     a=headB;
        //     b=headA;
        // }
        // a=getKthNode(a,Math.abs(l1-l2));
        // while(a!=null && b!=null){
        //     if(a==b)
        //     return a;
        // }
        // return null;

        if(headA==null || headB==null) return null;

        Node a = headA;
        Node b = headB;
        while(a!=b){
            if(a==null)
                a=headB;
            else
                a=a.next;
            if(b==null)
                b=headA;
            else
                b=b.next;
        }
        return a;
    }
}
