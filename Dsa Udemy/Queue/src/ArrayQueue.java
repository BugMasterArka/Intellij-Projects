public class ArrayQueue {
    int[] q = null;
    int top;
    int begin;

    public ArrayQueue(int size){
        q = new int[size];
        top = -1;
        begin = -1;
    }

    public boolean isFull(){
        if(top==q.length-1) return true;
        return false;
    }

    public boolean isEmpty(){
        if(begin==-1 && top==-1) return true;
        else if(begin==q.length) return true;
        else if(begin>top) return true;
        return false;
    }

    public void enQueue(int val){
        if(isFull()){
            System.out.println("full");
        }
        else if(isEmpty()){
            begin=0;
            q[++top]=val;
        }else
            q[++top]=val;
    }

    public int deQueue(){
        if(isEmpty()) {
            System.out.println("empty");
            return -1;
        }
        else{
            int result = q[begin++];
            if(begin>top)
                begin=top=-1;
            return result;
        }
    }

    public int peek(){
        if(!isEmpty())
            return q[begin];
        System.out.println("empty");
        return -1;
    }

    public void delete(){
        q=null;
        System.out.println("deleted");
    }

    public static void main(String[] args) {
        ArrayQueue q = new ArrayQueue(5);
        System.out.println(q.isEmpty());
        q.enQueue(1);
        q.enQueue(2);
        System.out.println(q.peek());
        q.enQueue(3);
        System.out.println(q.deQueue());
        System.out.println(q.deQueue());
        System.out.println(q.deQueue());
        System.out.println(q.deQueue());
        q.delete();
    }
}
