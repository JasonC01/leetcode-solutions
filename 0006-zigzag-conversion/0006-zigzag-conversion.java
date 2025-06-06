class Solution {
    public String convert(String s, int numRows) {
        if (numRows == 1) return s;
        List<StringBuilder> arr = new ArrayList<>();
        for (int i = 0; i < numRows; i++) {
            arr.add(new StringBuilder());
        }
        int currRow = 0;
        int adder = -1;
        for (int i = 0; i < s.length(); i++) {
            if (currRow == 0) adder = 1;
            if (currRow == numRows - 1) adder = -1;
            arr.get(currRow).append(s.charAt(i));
            currRow += adder;
        }
        StringBuilder res = new StringBuilder();
        for (StringBuilder sb : arr) res.append(sb.toString());
        return res.toString();
    }
}