class Solution {
    long ans = 0;
    public long countPalindromePaths(List<Integer> parent, String s) {
        HashMap<Integer, Integer> maskMap = new HashMap<>();
        HashMap<Integer, List<Integer>> adjList = new HashMap<>();
        int currentMask = 0;
        maskMap.put(0, 0);
        adjList.put(0, new ArrayList<>());
        for (int i = 1; i < parent.size(); i++) {
            if (!adjList.containsKey(parent.get(i))) adjList.put(parent.get(i), new ArrayList<>());
            adjList.get(parent.get(i)).add(i);
        }
        traverse(adjList, 0, currentMask, maskMap, s);
        return ans;
    }

    public void traverse(HashMap<Integer, List<Integer>> adjList, int curr, int currMask, HashMap<Integer, Integer> maskMap, String s) {
        currMask ^= (1 << (s.charAt(curr) - 'a'));
        if (maskMap.containsKey(currMask)) ans += maskMap.get(currMask);
        maskMap.merge(currMask, 1, (a, b) -> a + 1);
        for (int i = 0; i < 26; i++) {
            int mask = currMask ^ (1 << i);
            if (maskMap.containsKey(mask)) ans += maskMap.get(mask);
        }
        for (int adj : adjList.getOrDefault(curr, new ArrayList<>())) {
            traverse(adjList, adj, currMask, maskMap, s);
        }
    }
}