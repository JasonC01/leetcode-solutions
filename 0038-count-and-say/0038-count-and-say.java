class Solution {
    public String countAndSay(int n) {
        String curr = "1";
        for (int i = 0; i < n - 1; i++) {
            curr = encode(curr);
        }
        return curr;
    }

    public String encode(String s) {
        StringBuilder sb = new StringBuilder();
        int count = 0;
        char prev = '-';
        for (char c : s.toCharArray()) {
            if (c != prev) {
                if (count > 0) {
                    sb.append(count);
                    sb.append(prev);
                    
                }
                count = 1;
                prev = c;
                
            } else {
                count++;
            }
        }
        sb.append(count);
        sb.append(prev);
        
        return sb.toString();
    }
}