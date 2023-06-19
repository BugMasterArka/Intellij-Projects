public class InsertionSinglyLinkedList {
    static Node head = null;
    static Node tail = null;
    static int size=0;

    static void insert(int value,int location){
        Node node = new Node();
        node.value = value;
        if(head==null)
            head=tail=node;
        else{
            if(location==0){
                node.next=head;
                head=node;
            }else if(location>=size){
                tail.next=node;
                tail=node;
            }else{
                Node c = head;
                int index=0;
                while(index!=location-1){
                    c=c.next;
                    index++;
                }
                node.next=c.next;
                c.next=node;
            }
        }
        size++;
    }

    static void display(){
        Node c = head;
        while(c!=null){
            System.out.print(c.value+" -> ");
            c=c.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        insert(1,0);
        display();
        insert(2,3);
        display();
        insert(3,0);
        display();
        insert(4,2);
        display();
        insert(5,7);
        display();
    }
}
