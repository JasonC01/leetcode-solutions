class Solution {
    public int minCostConnectPoints(int[][] points) {
        HashSet<Integer> visited = new HashSet<>();
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparing(x -> x[2]));
        for (int i = 0; i < points.length; i++) {
            for (int j = i + 1; j < points.length; j++) {
                pq.add(new int[]{i, j, Math.abs(points[i][0] - points[j][0]) + Math.abs(points[i][1] - points[j][1])});
            }
        }
        int ans = 0;
        int count = 0;
        DSU dsu = new DSU(points.length);
        while (!pq.isEmpty() && count < points.length - 1) {
            int[] curr = pq.poll();
            // System.out.println(Arrays.toString(curr));
            // System.out.println(dsu.parentMap);
            if (dsu.join(curr[0], curr[1])) {
                count++;
                // System.out.println("added");
                ans += curr[2];
                visited.add(curr[0]);
                visited.add(curr[1]);
            }
        }
        // System.out.println(count);
        return ans;
    }
    
    public class DSU {
        int n;
        HashMap<Integer, Integer> parentMap = new HashMap<>();
        public DSU(int n) {
            this.n = n;
        }

       public int find(int i) {
            return !parentMap.containsKey(i) ? i : parentMap.get(i).equals(i) ? i : find(parentMap.get(i));
        }

        public boolean join(int x, int y) {
            int parentX = find(x);
            int parentY = find(y);
            if (parentX != parentY) {
                parentMap.put(parentX, parentY);
                return true;
            }
            return false;
        }

    }
}


