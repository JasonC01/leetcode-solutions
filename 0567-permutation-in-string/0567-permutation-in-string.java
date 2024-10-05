class Solution {
     public boolean checkInclusion(String s1, String s2) {
        if (s2.length() < s1.length()) {
            return false;
        }
        HashMap<Character, Integer> counter = new HashMap<>();
        for (char c : s1.toCharArray()) {
            counter.merge(c, 1, (a, b) -> a + 1);
        }
        int low = -1;
        int high = 0;
        while (low < high && high < s2.length()) {
            // System.out.println(high);
            // System.out.println(low);
            // System.out.println("//");
            char curr = s2.charAt(high);
            if (high - low - 1 == s1.length()) {
                return true;
            }
            if (!counter.containsKey(curr)) {
                for (++low; low < high; low++) {
                    counter.merge(s2.charAt(low), 1, (a, b) -> a + 1);
                }
                high++;
            } else {
                if (counter.get(curr) > 0) {
                    counter.merge(curr, 0, (a, b) -> a - 1);
                    
                } else {
                    while (++low < high && s2.charAt(low) != curr) {
                        low++;
                    }
                }
                high++;
            }
        }
        return high - low - 1 == s1.length();
    }
}