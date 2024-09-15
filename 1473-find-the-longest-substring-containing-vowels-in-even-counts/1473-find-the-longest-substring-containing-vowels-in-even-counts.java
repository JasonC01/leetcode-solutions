class Solution {
    public int findTheLongestSubstring(String s) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int currentMask = 0;
        int currentIndex = 0;
        int ans = 0;
        map.put(0, -1);
        for (char c : s.toCharArray()) {
            if (isVowel(c)) {
                int mask = currentMask ^ getMask(c);
                if (map.containsKey(mask)) {
                    ans = Math.max(ans, currentIndex - map.get(mask));
                } else {
                    map.put(mask, currentIndex);
                }
                currentMask = mask;
            } else {
                if (map.containsKey(currentMask)) {
                    ans = Math.max(ans, currentIndex - map.get(currentMask));
                } 
            }
            currentIndex++;
        }
        return ans;
    }

    public boolean isVowel(char c) {
        return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u';
    }

    public int getMask(char c) {
        return c == 'a' ? 16 : c == 'e' ? 8 : c == 'i' ? 4 : c == 'o' ? 2 : 1;
    }
}