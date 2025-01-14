class Solution {
    public String minWindow(String s, String t) {
        HashMap<Character, Integer> counter = new HashMap<>();
        for (char c : t.toCharArray()) {
            counter.merge(c, 1, (a, b) -> a + 1);
        }
        int low = -1;
        int high = 0;
        int ansLow = -1;
        int ansHigh = -1;
        HashMap<Character, Integer> curr = new HashMap<>();
        while (high <= s.length()) {
            // System.out.println(low);
            // System.out.println(high);
            if (isSatisfied(curr, counter)) {
                // System.out.println(s.substring(low + 1, high));
                while (low < high - 1 && isSatisfied(curr, counter)) {
                    if (high - low < ansHigh - ansLow || ansHigh == -1) {
                        ansHigh = high;
                        ansLow = low;
                    }
                    curr.merge(s.charAt(++low), 0, (a, b) -> a - 1);
                }
                // curr.merge(s.charAt(++low), 0, (a, b) -> a - 1);
            }
            if (high < s.length()) {
                curr.merge(s.charAt(high),1, (a, b) -> a + 1);
            }
            high++;
        }
        return ansHigh != -1 ? s.substring(ansLow + 1, ansHigh) : "";
    }

    public boolean isSatisfied(HashMap<Character, Integer> m1, HashMap<Character, Integer> m2) {
        for (char c : m2.keySet()) {
            if (!m1.containsKey(c) || m1.get(c) < m2.get(c)) {
                return false;
            }
        }
        return true;
    }

}