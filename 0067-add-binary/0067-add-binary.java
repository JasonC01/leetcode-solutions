class Solution {
    public String addBinary(String a, String b) {
        if (a.length() < b.length()) {
            StringBuilder sb = new StringBuilder();
            while (sb.length() < b.length() - a.length()) {
                sb.append("0");
            }
            sb.append(a);
            a = sb.toString();
        } else if (a.length() > b.length()) {
            StringBuilder sb = new StringBuilder();
            while (sb.length() < a.length() - b.length()) {
                sb.append("0");
            }
            sb.append(b);
            b = sb.toString();
        }
        int carry = 0;
        StringBuilder sb = new StringBuilder();
        for (int i = a.length() - 1; i >= 0; i--) {
            char c1 = a.charAt(i);
            char c2 = b.charAt(i);
            if (c1 == '1' && c2 == '1') {
                sb.append(carry);
                carry = 1;
            } else if (c1 == '1' || c2 == '1') {
                sb.append(carry == 1 ? 0 : 1);
            } else {
                sb.append(carry);
                carry = 0;
            }
        }
        if (carry == 1) {
            sb.append(carry);
        }
        return sb.reverse().toString();
    }

}