import java.util.Stack;

public class CandyCrush {

    static boolean hasCharacter(String str, char c){
        for(int i=0;i<str.length();i++)
            if(str.charAt(i)==c)
                return true;
        return false;
    }
    static String reduce(String str){
        Stack<Character> stack = new Stack<>();
        Stack<Integer> occurence = new Stack<>();
        int count = 1;
        for(int i=0;i<str.length();i++){

            char ch = str.charAt(i);
            if(stack.peek()==ch && occurence.peek()<3){
                occurence.pop();
                occurence.push(++count);
            }
            else if(stack.peek()!=ch){
                if(hasCharacter(str.substring(i+1),stack.peek())){
                    if(count+1>=3){
                        stack.pop();
                        occurence.pop();
                    }
                    count=1;
                    stack.push(ch);
                    occurence.push(count);
                }
                else{


                }
            }
        }
    }

}
