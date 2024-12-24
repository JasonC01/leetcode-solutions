class Solution {
    HashMap<Integer, List<Integer>> first = new HashMap<>();
    HashMap<Integer, List<Integer>> second = new HashMap<>();
    public int minimumDiameterAfterMerge(int[][] edges1, int[][] edges2) {
        generateTree(edges1, first);
        generateTree(edges2, second);
        int firstDiam = getDiameter(first);
        int secondDiam = getDiameter(second);
        return Math.max((int) Math.ceil(firstDiam / 2.0) + (int) Math.ceil(secondDiam / 2.0) + 1, Math.max(firstDiam, secondDiam));
        
    }


    public int getDiameter(HashMap<Integer, List<Integer>> adjList) {
        if (adjList.isEmpty()) {
            return 0;
        }
        int start = 0;
        Queue<Integer> q = new ArrayDeque<>();
        HashSet<Integer> visited = new HashSet<>();
        q.add(start);
        int next = 0;
        while (!q.isEmpty()) {
            
            int curr = q.poll();
            if (!visited.contains(curr)) {
                visited.add(curr);
                next = curr;
                q.addAll(adjList.get(curr));
            }
        }
        q = new ArrayDeque<>();
        visited = new HashSet<>();
        q.add(next);
        int levelSize = 1;
        int level = 0;
        while (!q.isEmpty()) {
            int curr = q.poll();
            levelSize--;
            if (!visited.contains(curr)) {
                visited.add(curr);
                for (int i : adjList.get(curr)) {
                    if (!visited.contains(i)) {
                        q.add(i);
                    }
                }
                // q.addAll(adjList.get(curr));
            }
            if (levelSize == 0) {
                levelSize = q.size();
                level++;
            }
        }
        return level - 1;
    }
    


    private void generateTree(int[][] edges, HashMap<Integer, List<Integer>> map) {
        for (int[] edge : edges) {
            int from = edge[0];
            int to = edge[1];
            if (!map.containsKey(from)) {
                map.put(from, new ArrayList<>());
            }
            if (!map.containsKey(to)) {
                map.put(to, new ArrayList<>());
            }
            map.get(from).add(to);
            map.get(to).add(from);
        }
    }
}