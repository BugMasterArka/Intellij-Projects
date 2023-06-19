public class ACircularQueue {
    int[] q = null;
    int top;
    int begin;

    public ACircularQueue(int size){
        q = new int[size];
        top=-1;
        begin=-1;
    }

    public boolean isEmpty(){
        if(begin==-1 && top==-1) return true;
        return false;
    }

    public boolean isFull(){
        if((top+1)%q.length==begin) return true;
        return false;
    }

    public void enQueue(int val){
        if(isFull())
            System.out.println("full");
        else if(isEmpty()){
            begin=0;
            q[++top]=val;
        }else{
            top=(top+1)%q.length;
            q[top]=val;
        }
    }

    public int deQueue(){
        if(isEmpty()){
            System.out.println("empty");
            return -1;
        }
        else{
            int result = q[begin];
            if(begin==top)
                begin=top=-1;
            else
                begin = (begin+1)%q.length;
            return result;
        }
    }

    public int peek(){
        if(isEmpty()){
            System.out.println("empty");
            return -1;
        }
        return q[begin];
    }

    public void delete(){
        q = null;
        System.out.println("deleted");
    }

    public static void main(String[] args) {
        ACircularQueue q = new ACircularQueue(4);
        System.out.println(q.isEmpty());
        System.out.println(q.isFull());
        q.enQueue(1);
        q.enQueue(2);
        q.enQueue(3);
        q.enQueue(4);
        q.enQueue(5);
        System.out.println(q.peek());
        System.out.println(q.deQueue());
        System.out.println(q.deQueue());
        q.enQueue(5);
        q.enQueue(6);
        System.out.println(q.deQueue());
        System.out.println(q.deQueue());
        System.out.println(q.deQueue());
        System.out.println(q.deQueue());
        System.out.println(q.deQueue());
    }
}

