public class IsPalindrome {
    public  boolean isPalindrome(String s)
    {
        if(s.charAt(0)!=s.charAt(s.length()-1))
            return false;
        else if(s.length() == 0 || s.length() == 1)
            return true;
        else
            return isPalindrome(s.substring(1,s.length()-1));
    }
}
