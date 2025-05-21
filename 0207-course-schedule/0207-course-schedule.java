class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        HashMap<Integer, List<Integer>> adjList = new HashMap<>();
        HashMap<Integer, Integer> inDegree = new HashMap<>();
        for (int[] prereq : prerequisites) {
            int from = prereq[1];
            int to = prereq[0];
            adjList.computeIfAbsent(from, x -> new ArrayList<>());
            adjList.get(from).add(to);
            inDegree.merge(to, 1, (a, b) -> a + 1);
        }
        Queue<Integer> q = new ArrayDeque<>();
        int courseCount = 0;
        for (int i = 0; i < numCourses; i++) {
            if (!inDegree.containsKey(i)) q.add(i);
        }
        while (!q.isEmpty()) {
            int currCourse = q.poll();
            courseCount++;
            for (int adj : adjList.getOrDefault(currCourse, new ArrayList<>())) {
                inDegree.merge(adj, 0, (a, b) -> a - 1);
                if (inDegree.get(adj) == 0) q.add(adj);
            }
        }
        return courseCount == numCourses;
    }

}