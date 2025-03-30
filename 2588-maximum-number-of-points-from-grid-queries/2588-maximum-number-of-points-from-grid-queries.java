class Solution {
    public int[] maxPoints(int[][] grid, int[] queries) {
        int[][] q = new int[queries.length][2];
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        int[] ans = new int[queries.length];
        Arrays.fill(ans, -1);
        for (int i = 0; i < queries.length; i++) {
            q[i] = new int[]{queries[i], i};
        }
        Arrays.sort(q, Comparator.comparing(x -> x[0]));
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparing(x -> grid[x[0]][x[1]]));
        pq.add(new int[]{0, 0});
        int currentQuery = 0;
        int score = 0;
        while (!pq.isEmpty() && currentQuery < q.length) {
            if (grid[pq.peek()[0]][pq.peek()[1]] >= q[currentQuery][0]) {
                ans[q[currentQuery][1]] = score;
                currentQuery++;
            } else {
                int[] curr = pq.poll();
                int y = curr[0];
                int x = curr[1];
                if (!visited[y][x]) {
                    visited[y][x] = true;
                    score++;
                    if (y + 1 < grid.length) {
                        pq.add(new int[]{y + 1, x});
                    }
                    if (y - 1 >= 0) {
                        pq.add(new int[]{y - 1, x});
                    }
                    if (x + 1 < grid[0].length) {
                        pq.add(new int[]{y, x + 1});
                    }if (x - 1 >= 0) {
                        pq.add(new int[]{y, x - 1});
                    }
                }
            }
        }
        for (int i = 0; i < ans.length; i++) {
            if (ans[i] == -1) {
                ans[i] = score;
            }
        }
        return ans;
    }

}