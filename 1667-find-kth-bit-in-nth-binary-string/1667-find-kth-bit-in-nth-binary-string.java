class Solution {
    public char findKthBit(int n, int k) {
        StringBuilder curr = new StringBuilder("0");
        for (int i = 1; i < n; i++) {
            StringBuilder next = new StringBuilder(curr.toString());
            String rev = new StringBuilder(curr).reverse().toString();
            next.append("1");
            next.append(invert(rev));
            curr = next;
        }
        return curr.charAt(k - 1);
    }
    
    public String invert(String s) {
        StringBuilder sb = new StringBuilder();
        for (char c : s.toCharArray()) {
            if (c == '0') {
                sb.append('1');
            } else {
                sb.append('0');
            }
        }
        return sb.toString();
    }
}