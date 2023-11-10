class Solution {
    public int[] restoreArray(int[][] adjacentPairs) {
        HashMap<Integer, List<Integer>> adjList = new HashMap<>();
        for (int[] pair : adjacentPairs) {
            int first = pair[0];
            int second = pair[1];
            if (!adjList.containsKey(first)) {
                adjList.put(first, new ArrayList<>());
            }
            if (!adjList.containsKey(second)) {
                adjList.put(second, new ArrayList<>());
            }
            adjList.get(first).add(second);
            adjList.get(second).add(first);
        }
        int[] ans = new int[adjacentPairs.length + 1];
        int index = 0;
        Queue<Integer> q = new ArrayDeque<>();
        for (int i : adjList.keySet()) {
            if (adjList.get(i).size() == 1) {
                q.add(i);
                break;
            }
        }
        HashSet<Integer> added = new HashSet<>();
        while (!q.isEmpty()) {
            int curr = q.poll();
            ans[index++] = curr;
            added.add(curr);
            for (int i : adjList.get(curr)) {
                if (!added.contains(i)) {
                    q.add(i);
                }
            }
        }
        return ans;
    }
}