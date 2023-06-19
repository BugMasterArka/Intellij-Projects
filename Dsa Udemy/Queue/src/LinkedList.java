public class LinkedList {
    Node head=null;
    Node tail=null;
    int size=0;

    void createLinkedList(int val){
        Node newNode = new Node();
        newNode.val=val;
        newNode.next=null;
        size=1;
        head = tail = newNode;
    }

    void insert(int value, int location){
        Node node = new Node();
        node.val = value;
        if(head==null)
            head = tail = node;
        else{
            if(location==0){
                node.next = head;
                head = node;
            }else if(location>=size){
                tail.next = node;
                tail = node;
            }else{
                int index=0;
                Node c = head;
                while(index!=location-1){
                    c=c.next;
                    index++;
                }
                node.next = c.next;
                c.next=node;
            }
        }
        size++;
    }

    void delete(int location){
        if(head==null){
            System.out.println("empty");
        }else if(head==tail){
            head=tail=null;
        }else{
            if(location==0){
                head = head.next;
            }else if(location>=size){
                Node c = head;
                while(c.next!=tail)
                    c=c.next;
                tail = c;
                tail.next=null;
            }else{
                int index=0;
                Node c = head;
                while(index!=location-1){
                    c=c.next;
                    index++;
                }
                c.next=c.next.next;
            }
        }
        size--;
    }
}
