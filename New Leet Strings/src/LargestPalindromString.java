//problem: https://leetcode.com/problems/longest-palindromic-substring/description/
//solution: https://leetcode.com/problems/longest-palindromic-substring/solutions/127837/longest-palindromic-substring/

public class LargestPalindromString {
    public static String longestPalindrome(String s) {
        if (s == null || s.length() < 1) return "";
        int start = 0, end = 0;
        for (int i = 0; i < s.length(); i++) {
            System.out.println(i);
            int len1 = expandAroundCenter(s, i, i);
            int len2 = expandAroundCenter(s, i, i + 1);
            System.out.println(len1+" "+len2);
            int len = Math.max(len1, len2);
            if (len > end - start) {
                start = i - (len - 1) / 2;
                end = i + len / 2;
            }
        }
        return s.substring(start, end + 1);
    }

    private static int expandAroundCenter(String s, int left, int right) {
        int L = left, R = right;
        while (L >= 0 && R < s.length() && s.charAt(L) == s.charAt(R)) {
            L--;
            R++;
        }
        return R - L - 1;
    }

    public static void main(String[] args) {
        String s = "babad";
        System.out.println(longestPalindrome(s));
    }
}


//        int maxLength=0;
//        ArrayList<Integer> indexes = new ArrayList<>();
//        for(int i=0;i<s.length()-1;i++){
//            if(s.charAt(i)==s.charAt(i+1)){
//                if(maxLength<=2){
//                    maxLength=2;
//                    indexes.clear();
//                    indexes.add(i);
//                    indexes.add(i+1);
//                }
//                int pre = i-1;
//                int post = i+2;
//                while((pre>=0 && post<s.length()) && (s.charAt(pre)==s.charAt(post))){
//                    --pre;
//                    ++post;
//                }
//                if((post-1)-Math.max(pre+1,0)>maxLength && pre>=0){
//                    maxLength=(post-1)-Math.max(pre+1,0);
//                    indexes.clear();
//                    indexes.add(Math.max(pre+1, 0));
//                    indexes.add(post-1);
//                }
//            }else{
//                if(maxLength<=1){
//                    maxLength=1;
//                    indexes.clear();
//                    indexes.add(i);
//                    indexes.add(i);
//                }
//                int pre = i-1;
//                int post = i+1;
//                while((pre>=0 && post<s.length()) && (s.charAt(pre)==s.charAt(post))){
//                    --pre;
//                    ++post;
//                }
//                if((post-1)-Math.max(pre+1,0)>maxLength && pre>=0){
//                    maxLength=(post-1)-Math.max(pre+1,0);
//                    indexes.clear();
//                    indexes.add(Math.max(pre+1, 0));
//                    indexes.add(post-1);
//                }
//            }
//        }
//        return s.substring(indexes.get(0),indexes.get(1)+1);