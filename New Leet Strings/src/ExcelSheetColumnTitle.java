//problem: https://leetcode.com/problems/excel-sheet-column-title/description/
//solution: https://youtu.be/UcTKk2y_3s4

public class ExcelSheetColumnTitle {
    public static String convertToTitle(int columnNumber) {
        StringBuilder s = new StringBuilder();
        while(columnNumber>0){
            s.append(Character.toString((char)(((columnNumber-1)%26)+65)).toString());
            columnNumber=(columnNumber-1)/26;
        }
        return s.reverse().toString();
    }

    public static void main(String[] args) {
        System.out.println(convertToTitle(701));
    }
}
