public class Queue {
    static Node front;
    static Node rear;
    static int size=0;

    static void enqueue(int value){
        Node node = new Node(value);
        if(front==null)
            front=rear=node;
        else{
            rear.next=node;
            rear=node;
        }
        size++;
    }

    static int dequeue(){
        if(front==null){
            System.out.println("empty queue");
            return Integer.MIN_VALUE;
        }
        int popped = front.value;
        front=front.next;
        return popped;
    }

    static int peek(){
        return front.value;
    }
    static void display(){
        if(front==null){
            System.out.println("empty queue");
            return;
        }
        Node c = front;
        while(c!=null){
            System.out.print(c.value+" -> ");
            c=c.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        enqueue(1);
        display();
        enqueue(2);
        display();
        enqueue(3);
        display();
        enqueue(4);
        display();
        enqueue(5);
        display();
        System.out.println(peek());
        dequeue();
        System.out.println(peek());
        dequeue();
        System.out.println(peek());
        dequeue();
        display();

    }
}
