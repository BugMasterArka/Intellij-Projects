public class TraversalDLL {
    static DoubleNode head;
    static DoubleNode tail;
    static int size=0;

    static void traverse(){
        if(head==null){
            System.out.println("empty list");
            return;
        }
        DoubleNode c = head;
        while(c!=null){
            System.out.println(c.value+" -> ");
            c=c.next;
        }
        System.out.println();
    }

    static void reverseTraverse(){
        if(head==null){
            System.out.println("empty list");
            return;
        }
        DoubleNode c = tail;
        while(c!=null){
            System.out.println(c.value+" <- ");
            c=c.prev;
        }
        System.out.println();
    }
}
