class Solution {
    int mod = (int) (1e9 + 7);
    public int countHomogenous(String s) {
        List<Long> arr = new ArrayList<>();
        long count = 0;
        int prev = s.charAt(0);
        for (char c : s.toCharArray()) {
            if (c == prev) {
                count++;
            } else {
                arr.add(count);
                prev = c;
                count = 1;
            }
        }
        arr.add(count);
        long ans = 0;
        for (long i : arr) {
            ans = (ans + ((i* (i + 1)) / 2) % mod) % mod;
        }
        return (int) ans;
    }
}