public class ListStack {
    static int top = Integer.MIN_VALUE;
    static LinkedList list=null;

    static void push(int value){
        if(list==null){
            list = new LinkedList();
            list.insert(value,0);
            top = value;
        }else{
            list.insert(value,0);
            top=value;
        }
    }

    static boolean isEmpty(){
        if(list.head==null) return true;
        return false;
    }

    static int pop(){
        if(!isEmpty()){
            int result = list.head.val;
            list.delete(0);
            top = list.head.val;
            return result;
        }
        return -1;
    }

    static int peek(){
        return top;
    }

    static void delete(){
        list = null;
        top=Integer.MIN_VALUE;
        System.out.println("Stack deleted");
    }

    public static void main(String[] args) {
        push(1);
        System.out.println(peek());
        push(2);
        System.out.println(peek());
        push(3);
        System.out.println(pop());
        System.out.println(peek());
        pop();
        System.out.println(peek());


    }
}
