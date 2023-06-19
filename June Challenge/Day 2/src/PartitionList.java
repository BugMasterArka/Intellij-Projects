public class PartitionList {
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

    static void partition(int x){
        Node beforeHead = new Node(Integer.MIN_VALUE);
        Node before = beforeHead;
        Node afterHead = new Node(Integer.MIN_VALUE);
        Node after = afterHead;
        Node c = head;
        while(c!=null){
            if(c.value < x){
                before.next = c;
                before = c;
            }else{
                after.next = c;
                after = c;
            }
            c=c.next;
        }
        after.next = null;
        before.next = afterHead.next;
        head = beforeHead.next;
    }

    public static void main(String[] args) {
        insert(1);
        insert(4);
        insert(3);
        insert(2);
        insert(5);
        insert(2);

        display();

        partition(3);

        display();
    }
}
