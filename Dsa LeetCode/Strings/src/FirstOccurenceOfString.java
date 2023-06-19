//problem: https://leetcode.com/problems/find-the-index-of-the-first-occurrence-in-a-string/description/

public class FirstOccurenceOfString {
    public int strStr(String haystack, String needle) {

//        less optimized solution due to many substrings
//         int index=0;
//         while(haystack.length()>=needle.length()){
//             if(haystack.substring(0,needle.length()).equalsIgnoreCase(needle))
//                 return index;
//             index++;
//             haystack=haystack.substring(1,haystack.length());
//         }
//         return -1;

//         optimized solution without substrings
        int index = 0;
        int haystack_len = haystack.length();
        int needle_len = needle.length();
        while (index <= (haystack_len - needle_len)) {
            if (haystack.substring(index, index + needle_len).equalsIgnoreCase(needle))
                return index;
            index++;
        }
        return -1;
    }
}
