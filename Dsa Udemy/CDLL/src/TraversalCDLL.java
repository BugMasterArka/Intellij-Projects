public class TraversalCDLL {
    static DoubleNode head;
    static DoubleNode tail;
    static int size=0;

    static void traverse(){
        if(head==null){
            System.out.println("empty list");
            return;
        }
        DoubleNode c = head;
        do{
            System.out.print(c.value+" -> ");
            c=c.next;
        }while(c!=head);
        System.out.println();
    }
}
