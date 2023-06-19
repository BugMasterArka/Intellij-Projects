public class ReverseLinkedList {
    static DoublyLinkedListNode head;
    static DoublyLinkedListNode tail;

    static void insert(int value){
        DoublyLinkedListNode newNode = new DoublyLinkedListNode(value);
        if(head==null)
            head=tail=newNode;
        else{
            tail.next=newNode;
            newNode.prev=tail;
            tail=newNode;
        }
    }

    static void display(){
        if(head==null)
            System.out.println("empty list");
        else {
            DoublyLinkedListNode c = head;
            while(c!=null){
                System.out.print(c.value+" ");
                c=c.next;
            }
            System.out.println();
        }
    }

    static DoublyLinkedListNode reverse(DoublyLinkedListNode head){
        if(head==null)
            return null;
        DoublyLinkedListNode temp = null, cur = head;
        while(cur!=null){
            temp = cur.next;
            if(cur.prev==null)
                cur.next=null;
            else
                cur.next=cur.prev;
            cur.prev = temp;
            if(temp!=null)
                cur = temp;
            else
                break;
        }
        return cur;
    }

    public static void main(String[] args) {
        insert(1);
        insert(2);
        insert(3);
        insert(4);

        display();
        head=reverse(head);
        display();
    }
}
