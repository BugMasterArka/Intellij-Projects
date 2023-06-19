public class StringReverse {
    public String reverse(String str)
    {
        if(str.length()==1)
            return str;
        return str.substring(str.length()-1,str.length())+reverse(str.substring(0,str.length()-1));
    }
}