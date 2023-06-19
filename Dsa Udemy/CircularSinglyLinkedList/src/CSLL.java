public class CSLL {
    static Node head;
    static Node tail;
    static int size=0;

    static void create(int value){
        Node newNode = new Node();
        newNode.value=value;
        newNode.next=newNode;
        head=newNode;
        tail=newNode;
        size++;
    }

    static void insert(int value,int location){
        Node newNode = new Node();
        newNode.value=value;
        if(head==null){
            head=tail=newNode;
            newNode.next=newNode;
        }
        else if(location==0){
            newNode.next=head;
            head=newNode;
            tail.next=head;
        }
        else if(location>=size){
            newNode.next=head;
            tail.next=newNode;
            tail=newNode;
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
        size++;
    }

    static void traverse(){
        if(head==null){
            System.out.println("empty list");
            return;
        }
        Node c = head;
        do{
            System.out.print(c.value+" -> ");
            c=c.next;
        }while(c!=head);
        System.out.println();
    }

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

    static void delete(int location){
        if(head==null)
            System.out.println("empty list");
        else if(head==tail){
            head.next=null;
            head=null;
            tail=null;
        }
        else if(location == 0){
            head=head.next;
            tail.next=head;
        }
        else if(location>=size){
            Node c = head;
            while(c.next!=tail)
                c=c.next;
            tail=c;
            tail.next=head;
        }
        else{
            Node c = head;
            int index=0;
            while(index!=location-1){
                c=c.next;
                index++;
            }
            c.next=c.next.next;
        }
        size--;
    }

    static void deleteList(){
        tail.next=null;
        head=null;
        tail=null;
        System.out.println("list deleted");
    }

    public static void main(String[] args) {
        insert(1,0);
        traverse();
        insert(2,4);
        traverse();
        insert(3,0);
        traverse();
        insert(4,2);
        traverse();
        insert(5,12);
        traverse();
        search(4);
        delete(0);
        traverse();
        delete(2);
        traverse();
        delete(8);
        traverse();
        delete(0);
        traverse();
        delete(1);
        traverse();
    }
}
