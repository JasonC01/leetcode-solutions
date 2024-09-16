class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        HashMap<Integer, List<Integer>> map = new HashMap<>();
        int[] inCount = new int[numCourses];
        boolean[] visited = new boolean[numCourses];
        for (int[] prereq : prerequisites) {
            int course = prereq[0];
            int req = prereq[1];
            if (!map.containsKey(req)) {
                map.put(req, new ArrayList<>());
            }
            map.get(req).add(course);
            inCount[course]++;
        }
        Queue<Integer> q = new ArrayDeque<>();
        for (int i = 0; i < inCount.length; i++) {
            if (inCount[i] == 0) {
                q.add(i);
            }
        }
        int ans = 0;
        while (!q.isEmpty()) {
            int course = q.poll();
            if (inCount[course] != 0 || visited[course]) {
                continue;
            }
            visited[course] = true;
            ans++;
            for (int i : map.getOrDefault(course, new ArrayList<>())) {
                inCount[i]--;
                q.add(i);
            }
        }
        return ans == numCourses;
    }
}