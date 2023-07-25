class Solution {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        Queue<Integer> q = new ArrayDeque<>();
        q.add(0);
        boolean[] visited = new boolean[rooms.size()];
        while (!q.isEmpty()) {
            int currRoom = q.poll();
            visited[currRoom] = true;
            for (int key : rooms.get(currRoom)) {
                if (!visited[key]) {
                    q.add(key);
                }
            }
        }
        boolean ans = true;
        for (boolean b : visited) {
            ans &= b;
        }
        return ans;
    }
}