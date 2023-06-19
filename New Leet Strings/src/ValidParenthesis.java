//problem: https://leetcode.com/problems/valid-parentheses/

import java.util.Stack;

public class ValidParenthesis {
    public static boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='(' || s.charAt(i)=='{' || s.charAt(i)=='[')
                stack.push(s.charAt(i));
            else{
                switch(stack.pop()){
                    case '(':if(s.charAt(i)!=')') return false;break;
                    case '{':if(s.charAt(i)!='}') return false;break;
                    case ']':if(s.charAt(i)!=']') return false;break;
                }
            }
        }
        if(!stack.isEmpty())
            return false;
        return true;
    }

    public static void main(String[] args) {
        String s = "(]{}[]";
        System.out.println(isValid(s));
    }
}
