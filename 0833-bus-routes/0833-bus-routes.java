class Solution {
    public int numBusesToDestination(int[][] routes, int source, int target) {
        HashMap<Integer, HashSet<Integer>> adjList = new HashMap<>(); // station -> [adjacent station, bus number]
        HashSet<Integer> visited = new HashSet<>();
        for (int r = 0; r < routes.length; r++) {
            int[] route = routes[r];
            for (int i = 0; i < route.length; i++) {
                int curr = route[i];
                adjList.computeIfAbsent(curr, x -> new HashSet<>());
                adjList.get(curr).add(r);
            }
        }
        if (source == target) return 0;
        if (!adjList.containsKey(source) || !adjList.containsKey(target)) return -1;
        Queue<Integer> q = new ArrayDeque<>(adjList.get(target));
        int level = 1;
        int qSize = q.size();
        while (!q.isEmpty()) {
            int currentBus = q.poll();
            qSize--;
            if (adjList.get(source).contains(currentBus)) return level;
            if (!visited.contains(currentBus)) {
                visited.add(currentBus);
                for (int station : routes[currentBus]) {
                    for (int adjBus : adjList.getOrDefault(station, new HashSet<>())) {
                        if (adjBus != currentBus && !visited.contains(adjBus)) {
                            q.add(adjBus);
                        }
                    }
                }
            }
            if (qSize == 0) {
                level++;
                qSize = q.size();
            }
        }
        return -1;
    }
}