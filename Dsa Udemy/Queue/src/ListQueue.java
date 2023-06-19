public class ListQueue {
    LinkedList list = null;

    public ListQueue(){
        list = new LinkedList();
    }

    public boolean isEmpty(){
        if(list.head==null) return true;
        return false;
    }

    public void enQueue(int val){
        list.insert(val,list.size);
    }

    public int deQueue(){
        if(!isEmpty()){
            int result = list.head.val;
            list.delete(0);
            return result;
        }else{
            System.out.println("empty");
            return -1;
        }
    }

    public int peek(){
        if(isEmpty()){
            System.out.println("empty");
            return -1;
        }
        return list.head.val;
    }

    public void delete(){
        list.head = list.tail = null;
        list = null;
        System.out.println("deleted");
    }

    public static void main(String[] args) {
        ListQueue q = new ListQueue();
        q.enQueue(1);
        q.enQueue(2);
        q.enQueue(3);
        q.enQueue(4);
        System.out.println(q.peek());
        System.out.println(q.deQueue());
        System.out.println(q.peek());
        System.out.println(q.deQueue());
        System.out.println(q.deQueue());
        System.out.println(q.deQueue());
        System.out.println(q.peek());
        System.out.println(q.deQueue());
        System.out.println(q.isEmpty());
    }
}
