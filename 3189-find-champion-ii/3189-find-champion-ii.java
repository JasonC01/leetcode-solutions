class Solution {
    public int findChampion(int n, int[][] edges) {
        int[] inCount = new int[n];
        for (int[] edge : edges) {
            inCount[edge[1]]++;
        }
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (inCount[i] == 0) res.add(i);
        }
        return res.size() > 1 ? -1 : res.get(0);
    }
}