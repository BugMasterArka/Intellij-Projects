public class PartitionOfList {
    static Node head;

    static void display(){
        if(head==null){
            System.out.println("Empty list");
            return;
        }
        Node c =head;
        while(c!=null){
            System.out.print(c.value+" -> ");
            c=c.next;
        }
        System.out.println();
    }

    static void insert(int value){
        Node newNode = new Node(value);
//        newNode.value=value;
        newNode.next=null;
        if(head==null)
            head=newNode;
        else{
            Node c = head;
            while(c.next!=null)
                c=c.next;
            c.next=newNode;
        }
    }

//    static void partition(int value){
//        Node head2 = head.next;
//        Node tail = head;
//        Node c = head2;
//        while(c!=null){
//            if(c.value<value){
//                Node newNode = new Node(c.value);
//                tail.next = newNode;
//                tail = newNode;
//            }
//            c=c.next;
//        }
//
//
//    }

    public static void main(String[] args) {

    }
}
