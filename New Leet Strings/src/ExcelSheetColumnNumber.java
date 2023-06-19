//problem: https://leetcode.com/problems/excel-sheet-column-number/
//solution: https://www.youtube.com/watch?v=UcTKk2y_3s4

public class ExcelSheetColumnNumber {
    public int titleToNumber(String columnTitle) {
        int num=0;
        int j=0;
        for(int i=columnTitle.length()-1;i>=0;i--){
            num+=Math.pow(26,j)*(columnTitle.charAt(i)-64);
            j++;
        }
        return num;
    }
}
