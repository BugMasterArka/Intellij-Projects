public class BubbleSortLL {
    public static Node sort(Node head,int size){
        for(int i=1;i<=size;i++){
            Node d = head;
            Node prev = null;
            while(d.next!=null){
                if(d.val>d.next.val){
                    Node second = d.next;
                    if(prev!=null)
                        prev.next = second;
                    d.next = second.next;
                    second.next = d;
                    d = second;
                    if(prev==null)
                        head = second;
                }
                prev = d;
                d=d.next;
            }
        }
        return head;
    }

    public static int getSize(Node head){
        if(head==null)
            return 0;
        else{
            Node c = head;
            int size=0;
            while(c!=null){
                size++;
                c=c.next;
            }
            return size;
        }
    }

    public static void print(Node head){
        if(head==null){
            System.out.println("empty");
        }else{
            Node c = head;
            while(c!=null){
                System.out.print(c.val+" ");
                c=c.next;
            }
        }
    }

    public static void main(String[] args) {
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(4);
        head.next.next.next.next = new Node(5);

        head=sort(head,getSize(head));

        print(head);
    }
}
