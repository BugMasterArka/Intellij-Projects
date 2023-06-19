

import java.util.ArrayList;

public class CopyListWithRandomPointer {
    public static RandomNode getRandomNode(RandomNode head,int val){
        RandomNode c = head;
        while(c!=null){
            if(c.val==val)
                return c;
            c=c.next;
        }
        return null;
    }

    public static RandomNode copyRandomList(RandomNode head) {
        ArrayList<RandomNode> randoms = new ArrayList<>();
        RandomNode before_new_head = new RandomNode(Integer.MIN_VALUE);
        RandomNode last = before_new_head;
        while(head!=null){
            RandomNode node = new RandomNode(head.val);
            last.next = node;
            last = node;
            randoms.add(head.random);
            head=head.next;
        }
        RandomNode c = before_new_head.next;
        while(!randoms.isEmpty()){
            RandomNode random = randoms.remove(0);
            if(random!=null){
                c.random = getRandomNode(before_new_head.next,random.val);
            }else
                c.random=null;
            c=c.next;
        }
        return before_new_head.next;
    }

    static void display(RandomNode head){
        if(head==null){
            System.out.println("empty list");
            return;
        }
        RandomNode c = head;
        while(c!=null){
            System.out.print(c.val+" -> ");
            c=c.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        RandomNode head = null;
        RandomNode head2 = null;
        head = new RandomNode(7);
        head.next = new RandomNode(13);
        head.next.next = new RandomNode(11);
        head.next.next.next = new RandomNode(10);
        head.next.next.next.next = new RandomNode(1);
        head.random = null;
        head.next.random = head;
        head.next.next.random = head.next.next.next.next;
        head.next.next.next.random = head.next.next;
        head.next.next.next.next.random = head;

        display(head);

        head2 = copyRandomList(head);

        display(head2);
    }
}
