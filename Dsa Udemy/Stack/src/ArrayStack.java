public class ArrayStack {
    static int[] stack;
    static int top;

    public static void createStack(int size){
        stack = new int[size];
        top = -1;
    }

    public static boolean isEmpty(){
        if(top==-1)
            return true;
        return false;
    }

    public static boolean isFull(){
        if(top==stack.length-1)
            return true;
        return false;
    }

    public static void push(int value){
        if(isFull()){
            System.out.println("Stack full");
            return;
        }
        stack[++top]=value;
    }

    public static int pop(){
        if(isEmpty()){
            System.out.println("Stack empty");
            return -1;
        }
        return stack[top--];
    }

    public static int peek(){
        if(isEmpty()){
            System.out.println("Stack empty");
            return -1;
        }
        return stack[top];
    }

    public static void delete(){
        stack = null;
        top = -1;
        System.out.println("Deleted");
    }
}
