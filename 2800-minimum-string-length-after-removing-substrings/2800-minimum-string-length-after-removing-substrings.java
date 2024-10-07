class Solution {
    public int minLength(String s) {
        while (s.contains("AB") || s.contains("CD")) {
            String[] arr = s.split("AB");
            StringBuilder sb = new StringBuilder();
            for (String string : arr) {
                sb.append(string);
            }
            s = sb.toString();
            arr = s.split("CD");
            sb = new StringBuilder();
            for (String string : arr) {
                sb.append(string);
            }
            s = sb.toString();
        }
        return s.length();
    }
}