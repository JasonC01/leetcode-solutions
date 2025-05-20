class Solution {
    public int longestAwesome(String s) {
        HashMap<Integer, Integer> indexMap = new HashMap<>();
        indexMap.put(0, -1);
        int currMask = 0;
        int ans = 1;
        for (int i = 0; i < s.length(); i++) {
            currMask ^= (1 << Integer.parseInt(s.substring(i, i + 1)));
            if (indexMap.containsKey(currMask)) ans = Math.max(ans, i - indexMap.get(currMask));
            else indexMap.put(currMask, i);
            for (int j = 0; j < 10; j++) {
                if (indexMap.containsKey(currMask ^ (1 << j))) ans = Math.max(ans, i - indexMap.get(currMask ^ (1 << j)));
            }
            
        }
        return ans;
    }
}