public class Stack {
    static Node top;
    static int size;

    static void push(int value){
        Node node = new Node(value);
        if(top==null)
            top=node;
        else{
            node.next=top;
            top=node;
        }
        size++;
    }

    static void pop(){
        if(top==null){
            System.out.println("empty stack");
            return;
        }
        top=top.next;
    }

    static int poll(){
        if(top!=null){
            int popped = top.value;
            top=top.next;
            return popped;
        }
        else{
            System.out.println("empty stack");
            return Integer.MIN_VALUE;

        }

    }

    static void peek(){
        if(top!=null)
            System.out.println(top.value);
        else
            System.out.println("empty stack");
    }

    public static void main(String[] args) {
        push(1);
        push(2);
        push(3);
        push(4);
        push(5);
        peek();
        pop();
        peek();
        System.out.println(poll());
        peek();
        pop();
        pop();
        peek();
        System.out.println(poll());
        peek();
    }
}
