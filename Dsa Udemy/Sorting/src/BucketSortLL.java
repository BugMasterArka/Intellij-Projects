import java.util.ArrayList;

public class BucketSortLL {

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

    public static int giveMaxValue(Node head){
        if(head==null)
            return 0;
        else{
            Node c = head;
            int maxValue = Integer.MIN_VALUE;
            while(c!=null){
                if(c.val>maxValue)
                    maxValue=c.val;
                c=c.next;
            }
            return maxValue;
        }
    }

    public static Node sort(Node head){
        int size = getSize(head);
        int numberOfBuckets = (int)Math.ceil(Math.sqrt(size));
        int maxValue = giveMaxValue(head);
        Node[] buckets = new Node[numberOfBuckets];

        for(int i=0;i<numberOfBuckets;i++){
            buckets[i]=null;
        }
        while(head!=null){
            Node extracted = head;
            head = head.next;
            extracted.next = null;
            int bucketNumber = (int)Math.ceil(((float)extracted.val*numberOfBuckets)/((float)maxValue));
            if(buckets[bucketNumber-1]==null){
                buckets[bucketNumber-1] =extracted;
            }else{
                Node c = buckets[bucketNumber-1];
                while(c.next!=null)
                    c=c.next;
                c.next = extracted;
            }
        }

        for(int i=0;i<numberOfBuckets;i++){
            buckets[i]=bubbleSort(buckets[i]);
        }
        Node sortedHead = null;
        for(Node bucketHead: buckets){
            if(sortedHead==null)
                sortedHead=bucketHead;
            else{
                Node lastOfPrevBucket = sortedHead;
                while(lastOfPrevBucket.next!=null)
                    lastOfPrevBucket=lastOfPrevBucket.next;
                lastOfPrevBucket.next = bucketHead;
            }
        }

        return sortedHead;
    }

    public static Node bubbleSort(Node head){
        int size = getSize(head);
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
        head.next = new Node(3);
        head.next.next = new Node(4);
        head.next.next.next = new Node(7);
        head.next.next.next.next = new Node(2);
        head.next.next.next.next.next = new Node(8);
        head.next.next.next.next.next.next = new Node(6);
        head.next.next.next.next.next.next.next = new Node(9);
        head.next.next.next.next.next.next.next.next  =new Node(1);

        head=sort(head);

        print(head);
    }
}
