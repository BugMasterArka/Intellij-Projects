//TODO: code not running properly
//TODO: error when given already sorted input

public class SelectionSortLL {

    public static Node sort(Node head, int size){
        Node toBeSwapped = head;
        Node beforeSwapper = null;
        for(int i=1;i<size;i++){
            Node beforeMin = toBeSwapped.next.next!=null?getBeforeMinimum(toBeSwapped.next):toBeSwapped;
            Node swapper = toBeSwapped;
            toBeSwapped=toBeSwapped.next;
            if(beforeMin.next.val<swapper.val){
                if(beforeSwapper!=null){
                    beforeSwapper.next=beforeMin.next;
                }
                if(beforeSwapper==null)
                    head = beforeMin.next;
                swapper.next=beforeMin.next.next;
                if(toBeSwapped.next!=null)
                    beforeMin.next.next=toBeSwapped;
                else
                    beforeSwapper.next.next=beforeMin;
                if(beforeMin.next!=null)
                    beforeMin.next=swapper;

            }
            if(beforeSwapper!=null)
                beforeSwapper=beforeSwapper.next;
            else
                beforeSwapper=head;
        }
        return head;
    }

    public static Node getBeforeMinimum(Node cur){
        Node prev = null;
        Node prevMin = null;
        Node min = cur;
        while(cur!=null){
            if(cur.val<min.val){
                min=cur;
                prevMin = prev;
            }
            prev = cur;
            cur=cur.next;
        }

        return prevMin;
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
