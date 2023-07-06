class Solution {
    public String gcdOfStrings(String str1, String str2) {
        String shorter = str1.length() < str2.length() ? str1 : str2;
        String longer = shorter.equals(str1) ? str2 : str1;
        String ans = "";
        for (int i = 1; i <= shorter.length(); i++) {
            String divisor = shorter.substring(0, i);
            if (isDivisible(longer, divisor) && isDivisible(shorter, divisor)) {
                ans = divisor;
            }
        }
        return ans;
    }
    
    public boolean isDivisible(String s, String divisor) {
        int divisorIndex = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) != divisor.charAt(divisorIndex)) {
                return false;
            }
            divisorIndex++;
            divisorIndex %= divisor.length();
        }
        return divisorIndex == 0;
    }
}