class Solution {
    public int largestIsland(int[][] grid) {
        int n = grid.length;
        DSU dsu = new DSU(n, grid);
        boolean[][] visited = new boolean[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int currVal = i * n + j;
                if (!visited[i][j] && grid[i][j] == 1) {
                    Queue<int[]> q = new ArrayDeque<>();
                    q.add(new int[]{i, j});
                    while (!q.isEmpty()) {
                        int[] curr = q.poll();
                        int x = curr[1];
                        int y = curr[0];
                        if (x < 0 || y < 0 || x > n - 1 || y > n - 1 || visited[y][x] || grid[y][x] == 0) {
                            continue;
                        }
                        visited[y][x] = true;
                        int val = y * n + x;
                        dsu.join(currVal, val);
                        q.add(new int[]{y + 1, x});
                        q.add(new int[]{y - 1, x});
                        q.add(new int[]{y, x + 1});
                        q.add(new int[]{y, x - 1});
                    }
                }
            }
        }
        // System.out.println(dsu.valMap);
        // System.out.println(dsu.parentMap);
        int ans = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 0) {
                    int[] left = new int[]{i, j - 1};
                    int[] right = new int[]{i, j + 1};
                    int[] top = new int[]{i - 1, j};
                    int[] bottom = new int[]{i + 1, j};
                    int res = dsu.getVal(new int[][]{left, right, top, bottom});
                    ans = Math.max(ans, res + 1);
                }
            }
        }
        return ans == 0 ? n * n : ans;
    }


    public class DSU {
        int n;
        HashMap<Integer, Integer> parentMap = new HashMap<>();
        HashMap<Integer, Integer> valMap = new HashMap<>();

        public DSU(int n, int[][] grid) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    parentMap.put(i * n + j, i * n + j);
                    valMap.put(i * n + j, grid[i][j]);
                }
            }
            this.n = n;
        }

        public int find(int a) {
            while (parentMap.get(a) != a) {
                a = parentMap.get(a);
            }
            return a;
        }

        public void join(int x, int y) {
            int parentX = find(x);
            int parentY = find(y);
            if (parentX == parentY) {
                return;
            }
            parentMap.put(parentY, parentX);
            valMap.merge(parentX, 1, (a, b) -> a + valMap.get(parentY));
//            return true;
        }

        public int getVal(int[][] values) {
            HashSet<Integer> parents = new HashSet<>();
            for (int[] i : values) {
                int y = i[0];
                int x = i[1];
                if (y < 0 || x < 0 || y > n - 1 || x > n - 1) {
                    continue;
                }
                parents.add(find(y * n + x));
            }
            int ans = 0;
            for (int i : parents) {
                ans += valMap.getOrDefault(i, 0);
            }
            return ans;
        }
    }
}