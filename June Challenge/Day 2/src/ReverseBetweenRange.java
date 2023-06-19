public class ReverseBetweenRange {
    static Node head;
    static Node tail;

    static void insert(int value){
        Node newNode = new Node(value);
        if(head==null)
            head=tail=newNode;
        else{
            tail.next=newNode;
            tail=newNode;
        }
    }

    static void display(){
        if(head==null)
            System.out.println("empty list");
        else{
            Node c = head;
            while(c!=null){
                System.out.print(c.value+" ");
                c=c.next;
            }
            System.out.println();
        }
    }

    static void reversePart(int start, int end, Node head){
        if(head==null || head.next==null || start==end)
            return;
        Node startPrev = null;
        Node startNode = head;
        Node endNode = head;
        int index=1;
        Node c = head;
        while(c!=null){
            if(index+1==start)
                startPrev = c;
            if(index==end)
                endNode = c;
            index++;
            c=c.next;
        }
        if(startPrev!=null)
            startNode=startPrev.next;
        reverse(startPrev,startNode,endNode);
    }

    static void reverse(Node startPrev,Node start, Node end){
//        Node startPrev=null;
//        if(start!=head){
//            startPrev = start;
//            start=start.next;
//        }
        Node endNext = end.next;
        Node temp = start;
        start=start.next;
        temp.next = end.next;
        while(start!=endNext){
            Node nextNode = start.next;
            start.next = temp;
            temp = start;
            start = nextNode;
        }
        if(startPrev!=null)
            startPrev.next=end;
        else
            head=end;
    }

    public static void main(String[] args) {
        insert(1);
        insert(2);
        insert(3);
        insert(4);
//        insert(5);

        display();

        reversePart(1,3,head);

        display();
    }
}
