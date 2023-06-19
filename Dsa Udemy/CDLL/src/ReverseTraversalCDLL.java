public class ReverseTraversalCDLL {
    static DoubleNode head;
    static DoubleNode tail;
    static int size=0;

    static void reverseTraverse(){
        if(head==null){
            System.out.println("empty list");
            return;
        }
        DoubleNode c = tail;
        do{
            System.out.print(c.value+" <- ");
            c=c.prev;
        }while(c!=tail);
        System.out.println();
    }
}
