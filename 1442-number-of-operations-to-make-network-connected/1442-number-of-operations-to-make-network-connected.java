class Solution {
    public int makeConnected(int n, int[][] connections) {
        HashMap<Integer, List<Integer>> adjList = new HashMap<>();
        if (connections.length < n - 1) {
            return -1;
        }
        for (int[] connection : connections) {
            int first = connection[0];
            int second = connection[1];
            if (!adjList.containsKey(first)) {
                adjList.put(first, new ArrayList<>());
            }
            if (!adjList.containsKey(second)) {
                adjList.put(second, new ArrayList<>());
            }
            adjList.get(first).add(second);
            adjList.get(second).add(first);
        }
        HashSet<Integer> visited = new HashSet<>();
        int numberOfComponents = 0;
        for (int i = 0; i < n; i++) {
            if (!visited.contains(i)) {
                numberOfComponents++;
                Queue<Integer> q = new ArrayDeque<>();
                q.add(i);
                while (!q.isEmpty()) {
                    int curr = q.poll();
                    if (!visited.contains(curr)) {
                        visited.add(curr);
                        q.addAll(adjList.getOrDefault(curr, new ArrayList<>()));
                    }
                }
            }
        }
        return numberOfComponents - 1;
    }
}