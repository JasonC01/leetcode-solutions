class Solution {
    List<List<Integer>> adjList;
    public int maximalNetworkRank(int n, int[][] roads) {
        adjList = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adjList.add(new ArrayList<>());
        }
        for (int[] road : roads) {
            int from = road[0];
            int to = road[1];
            adjList.get(from).add(to);
            adjList.get(to).add(from);
        }
        int ans = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i != j) {
                    ans = Math.max(ans, getLinks(i, j));
                }
            }
        }
        return ans;
    }

    public int getLinks(int x, int y) {
        
        return adjList.get(x).contains(y) ? adjList.get(x).size() + adjList.get(y).size() - 1 : adjList.get(x).size() + adjList.get(y).size();
    }
}