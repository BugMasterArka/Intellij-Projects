public class SinglyLinkedList {
    static Node head;
    static int size;
    static void insert(int value, int location){
        Node newNode = new Node(value);
        if(head==null)
            head=newNode;
        else{
            if(location==0){
                newNode.next=head;
                head=newNode;
            }else if(location>=size) {
                Node c = head;
                while (c.next != null)
                    c = c.next;
                c.next = newNode;
            }else{
                Node c = head;
                int index=0;
                while(index!=location-1){
                    c=c.next;
                    index++;
                }
                newNode.next=c.next;
                c.next=newNode;
            }
        }
        size++;
    }

    static void display(){
        if (head==null)
            System.out.println("Empty list");
        Node c = head;
        while(c!=null){
            System.out.print(c.value+" -> ");
            c=c.next;
        }
        System.out.println();
    }

    static void delete(int location){
        if(head==null)
            System.out.println("Empty list");
        else{
            if(location==0){
                Node temp=head;
                head=head.next;
                temp.next=null;
            }
            else if(location>=size){
                Node c = head;
                while(c.next.next!=null)
                    c=c.next;
                c.next=null;
            }else{
                Node c = head;
                int index=0;
                while(index!=location-1){
                    c=c.next;
                    index++;
                }
                c.next=c.next.next;
            }
        }
        size--;
    }

    public static void main(String[] args) {
        insert(5,0);
        display();
        insert(4,0);
        display();
        insert(6,9);
        display();
        insert(1,2);
        display();
        insert(2,4);
        display();
        delete(0);
        display();
        delete(9);
        display();
        delete(2);
        display();
    }
}
