//problem: https://leetcode.com/problems/add-binary/description/
//solution: https://youtu.be/OEW50g03mT0

public class AddBinary {
    public String addBinary(String a, String b) {
        StringBuilder s = new StringBuilder();
        int i = a.length()-1;
        int j = b.length()-1;
        int carry = 0;
        while(i>=0 || j>=0){
            int sum = carry;
            if(i>=0)
                sum += a.charAt(i) - '0';
            if(j>=0)
                sum += b.charAt(j) - '0';
            s.append(sum%2);
            carry = sum/2;

            i--;
            j--;
        }
        if(carry!=0)
            s.append(carry);
        return s.reverse().toString();
    }
}
