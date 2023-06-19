public class SearchDLL {
    static DoubleNode head;
    static DoubleNode tail;
    static int size=0;

    static void search(int value){
        if(head==null){
            System.out.println("empty list");
            return;
        }
        DoubleNode c = head;
        while(c!=null){
            if(c.value==value){
                System.out.println("found");
                return;
            }
            c=c.next;
        }
        System.out.println("not found");
    }
}
