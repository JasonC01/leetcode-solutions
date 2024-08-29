class Solution {
    public int removeStones(int[][] stones) {
        HashMap<int[], List<int[]>> adj = new HashMap<>();
        for (int[] stone : stones) {
            adj.put(stone, new ArrayList<>());
        }
        for (int[] s1 : stones) {
            for (int[] s2 : stones) {
                if (Arrays.equals(s1, s2)) {
                    continue;
                }
                if (s1[0] == s2[0] || s1[1] == s2[1]) {
                    adj.get(s1).add(s2);
                }
            }
        }
        int res = 0;
        HashSet<int[]> visited = new HashSet<>();
        for (int[] stone : stones) {
            if (!dfs(stone, adj, visited, new ArrayList<>()).isEmpty()) {
                res++;
            }
        }
        return stones.length - res;
    }

    public List<int[]> dfs(int[] stone, HashMap<int[], List<int[]>> adj, HashSet<int[]> visited, List<int[]> actuallyVisited) {
//        System.out.println(actuallyVisited);
        if (adj.get(stone).isEmpty()) {
            List<int[]> res = new ArrayList<>();
            res.add(stone);
            return res;
        }
        if (visited.contains(stone)) {
            return new ArrayList<>();
        }
        List<int[]> res = new ArrayList<>();
        visited.add(stone);
        List<int[]> newActVisited = new ArrayList<>(actuallyVisited);
        newActVisited.add(stone);
        for (int[] neighbour : adj.get(stone)) {
            if (!visited.contains(neighbour)) {
                List<int[]> arr = new ArrayList<>(newActVisited);
                arr.addAll(dfs(neighbour, adj, visited, newActVisited));
                if (arr.size() > res.size()) {
                    res = arr;
                }
            }
        }
        return res;
    }
}