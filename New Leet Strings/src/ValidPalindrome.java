//problem: https://leetcode.com/problems/valid-palindrome/description/

public class ValidPalindrome {
    public static boolean isPalindrome(String s) {
        int i=0;
        boolean validity=true;
        s=s.toLowerCase();
//        while(i<s.length()){
//            if(!Character.isLetterOrDigit(s.charAt(i)))
//                s=s.substring(0,i).concat(s.substring(i+1,s.length()));
//            else
//                i++;
//        }
//        i=0;
        int j=s.length()-1;
//        while(i<j){
//            if(!Character.isLetterOrDigit(s.charAt(i))){
//                i++;
//                continue;
//            }
//            if(!Character.isLetterOrDigit(s.charAt(j))){
//                j--;
//                continue;
//            }
//            if(Character.isLetterOrDigit(s.charAt(i)) && Character.isLetterOrDigit(s.charAt(j))){
//                if(s.charAt(i)!=s.charAt(j))
//                    validity=false;
//            }
//            i++;
//            j--;
//        }
//        return validity;
        while(i<j){
            if(!Character.isLetterOrDigit(s.charAt(i))){
                i++;
            }
            if(!Character.isLetterOrDigit(s.charAt(j))){
                j--;
            }
            if(Character.isLetterOrDigit(s.charAt(i)) && Character.isLetterOrDigit(s.charAt(j))){
                if(s.charAt(i)!=s.charAt(j))
                    validity=false;
                i++;
                j--;
            }
        }
        return validity;
    }

    public static void main(String[] args) {
        String s = "man, a plan, a canal: Panama";
        System.out.println(isPalindrome(s));
    }
}
