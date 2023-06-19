public class SearchingCDLL {
    static DoubleNode head;
    static DoubleNode tail;
    static int size=0;

    static void search(int value){
        if(head==null){
            System.out.println("empty list");
            return;
        }
        DoubleNode c = head;
        do{
            if(c.value==value){
                System.out.println("found");
                return;
            }
            c=c.next;
        }while(c!=head);
        System.out.println("not found");
    }
}
