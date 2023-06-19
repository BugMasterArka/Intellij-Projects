import java.util.Stack;

public class BalanceBrackets {

    static String isBalanced(String s){
        Stack<Character> stack = new Stack<>();
        char[] arr = s.toCharArray();
        for(char sym: arr){
            if(sym=='(' || sym=='{' || sym=='[')
                stack.push(sym);
            else{
                if(stack.isEmpty())
                    return "NO";
                char stackSymbol = stack.peek();
                if((stackSymbol=='[' && sym==']') || (stackSymbol=='{' && sym=='}') || (stackSymbol=='(' && sym==')'))
                    stack.pop();
                else{
                    return "NO";
                }
            }
        }
        if(!stack.isEmpty())
            return "NO";
        else
            return "YES";
    }

    public static void main(String[] args) {
        System.out.println(isBalanced("({})]]"));
    }
}
