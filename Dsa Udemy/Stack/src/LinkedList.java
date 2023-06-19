public class LinkedList {
    Node head=null;
    int size=0;

    void createSLL(int value){
        Node newNode = new Node();
        newNode.val = value;
        newNode.next = null;
        head = newNode;
        size=1;
    }

    void insert(int val,int location){
        Node node = new Node();
        node.val = val;
        if(head==null)
            head=node;
        else{
            if(location==0){
                node.next = head;
                head = node;
            }else if(location>=size){
                Node c = head;
                while(c.next!=null)
                    c=c.next;
                c.next = node;
            }else{
                Node c = head;
                int index=0;
                while(index!=location-1){
                    c=c.next;
                    index++;
                }
                node.next = c.next;
                c.next = node;
            }
        }
        size++;
    }

    void delete(int location){
        if(head==null){
            System.out.println("Empty List");
            return;
        }
        else if(head.next==null){
            head=null;
            return;
        }
        else if(location==0){
            head=head.next;
        }
        else if(location>=size){
            Node c = head;
            while(c.next.next!=null){
                c=c.next;
            }
            c.next=null;
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
}
