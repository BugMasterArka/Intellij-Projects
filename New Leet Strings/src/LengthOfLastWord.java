//problem: https://leetcode.com/problems/length-of-last-word/

public class LengthOfLastWord {
    public static int lengthOfLastWord(String s) {
        boolean wordFound=false;
        int count=0;
        for(int i=s.length()-1;i>=0;i--){
            if(s.charAt(i)!=' '){
                wordFound=true;
                count++;
            }else if(s.charAt(i)==' ' && wordFound)
                break;
        }
        return count;
    }

    public static void main(String[] args) {
        String s = "   fly me   to   the mon  ";
        System.out.println(lengthOfLastWord(s));
    }
}
