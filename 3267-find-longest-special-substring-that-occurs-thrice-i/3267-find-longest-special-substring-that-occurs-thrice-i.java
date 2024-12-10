class Solution {
    public int maximumLength(String s) {
        HashMap<Character, Integer> counter = new HashMap<>();
        for (char c : s.toCharArray()) {
            counter.merge(c, 1, (a, b) -> a + 1);
        }
        int ans = 0;
        for (char c : counter.keySet()) {
            if (counter.get(c) >= 3) {
                ans = Math.max(ans, bSearch(String.valueOf(c), s, counter.get(c)));
            }
        }
        return ans == 0 ? -1 : ans;
    }

    public int bSearch(String c, String s, int count) {
        int low = 0;
        int high = count - 2;
        while (low < high) {
            int mid = (int) Math.ceil((low + high) / 2.0);
            if (isPossible(s, c.repeat(mid))) {
                low = mid;
            } else {
                high = mid - 1;
            }
        }
        System.out.println(low);
        return low;
    }

    public boolean isPossible(String s, String target) {
        int count = 0;
        for (int i = 0; i < s.length() - target.length() + 1; i++) {
            if (s.substring(i).startsWith(target)) {
                count++;
            }
        }
        return count >= 3;
    }
}