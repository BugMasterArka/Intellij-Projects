//problem: https://leetcode.com/problems/isomorphic-strings/description/

import java.util.HashMap;

public class IsomorphicString {
    public static boolean isIsomorphic(String s, String t) {
        if(s.length()!=t.length())
            return false;
        HashMap<Character,Character> map1 = new HashMap<>();
        HashMap<Character,Character> map2 = new HashMap<>();
        int i=0;
        while(i<s.length()){
            if(map1.containsKey(s.charAt(i))){
                if(map1.get(s.charAt(i))!=t.charAt(i))
                    return false;
            }else if(map2.containsKey(t.charAt(i))){
                if(map2.get(t.charAt(i))!=s.charAt(i))
                    return false;
            }else{
                map1.put(s.charAt(i),t.charAt(i));
                map2.put(t.charAt(i),s.charAt(i));
            }
            i++;
        }
        return true;
    }

    public static void main(String[] args) {
        String s = "title";
        String t = "paper";
        System.out.println(isIsomorphic(s,t));
    }
}
