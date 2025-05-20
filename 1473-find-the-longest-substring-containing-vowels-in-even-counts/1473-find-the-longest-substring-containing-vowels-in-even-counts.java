class Solution {
    public int findTheLongestSubstring(String s) {
        int currentMask = 0;
        int ans = 0;
        HashMap<Integer, Integer> maskIndexMap = new HashMap<>();
        maskIndexMap.put(0, -1);
        for (int i = 0; i < s.length(); i++) {
            int mask = getMaskIndex(s.charAt(i));
            currentMask ^= mask;
            if (maskIndexMap.containsKey(currentMask)) ans = Math.max(ans, i - maskIndexMap.get(currentMask));
            else maskIndexMap.put(currentMask, i);
        }
        return ans;
    }
    
    public int getMaskIndex(char c) {
        switch (c) {
            case 'a':
                return 1;
            case 'e':
                return 2;
            case 'i':
                return 4;
            case 'o':
                return 8;
            case 'u':
                return 16;
        }
        return 0;
    }
}