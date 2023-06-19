public class SearchingCSLL {
    static Node head;
    static Node tail;
    static int size=0;

    static void search(int value){
        if(head==null){
            System.out.println("Empty list");
            return;
        }
        Node c = head;
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
