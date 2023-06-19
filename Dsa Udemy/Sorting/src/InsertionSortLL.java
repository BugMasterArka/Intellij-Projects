public class InsertionSortLL {
    public static Node sort(Node head){
        Node newhead = null;
        while(head!=null){
            Node extracted = head;
            head=head.next;
            extracted.next = null;
            newhead = insert(newhead,extracted);
        }
        return newhead;
    }

    public static Node insert(Node head,Node extracted){
        if(head==null){
            head = extracted;
        }else{
            Node prev = null;
            Node c = head;
            boolean didAssign = false;
            while(c!=null){
                if(c.val>extracted.val){
                    didAssign = true;
                    if(prev!=null){
                        extracted.next = c;
                        prev.next = extracted;
                    }else{
                        extracted.next = c;
                        head = extracted;
                    }

                    break;
                }
                prev = c;
                c=c.next;
            }
            if(!didAssign)
                prev.next = extracted;
        }
        return head;
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
        Node head = new Node(5);
        head.next = new Node(2);
        head.next.next = new Node(1);
        head.next.next.next = new Node(4);
        head.next.next.next.next = new Node(3);

        head = sort(head);

        print(head);
    }
}
