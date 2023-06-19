import java.util.Scanner;
import java.util.Stack;

public class SimpleTextEditor {
    static String s = "";
    static Stack<String> beforeString = new Stack<>();

    static void append(String str){
        beforeString.push(s);
        s = s.concat(str);
    }

    static void delete(int k){
        beforeString.push(s);
        s = s.substring(0,s.length()-k);
    }

    static void print(int k){
        System.out.println(s.charAt(k-1));
    }

    static void undo(){
        s = beforeString.pop();
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        for(int i=1;i<=n;i++){
            int operation = sc.nextInt();
            if(operation==1)
                append(sc.nextLine().trim());
            if(operation==2)
                delete(sc.nextInt());
            if(operation==3)
                print(sc.nextInt());
            if (operation==4)
                undo();
//            sc.nextLine();
        }
    }
}


//    String command = sc.nextLine();
//    String[] arr = command.split(" ");
//            if(arr.length==2){
//                    int operation = Integer.parseInt(arr[0]);
//                    if(operation==1){
//                    append(arr[1]);
//                    }else if(operation==2){
//                    delete(Integer.parseInt(arr[1]));
//                    }else if(operation==3){
//                    print(Integer.parseInt(arr[1]));
//                    }
//                    }else{
//                    undo();
//                    }
