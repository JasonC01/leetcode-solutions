class Solution {
    public int[] minimumCost(int n, int[][] edges, int[][] query) {
        DSU dsu = new DSU();
        HashMap<Integer, HashMap<Integer, Integer>> memo = new HashMap<>();
        int[] parents = new int[n];
        for (int[] edge : edges) {
            //     System.out.println(dsu.parentMap);
            // System.out.println(dsu.valueMap);
            dsu.join(edge[0], edge[1], edge[2]);
        }
        // System.out.println(dsu.parentMap);
        // System.out.println(dsu.valueMap);
        int[] ans = new int[query.length];
        for (int i = 0; i < query.length; i++) {
            int[] currQuery = query[i];
            int from = dsu.find(currQuery[0]);
            int to = dsu.find(currQuery[1]);
            if (from == to && from != -1) {
                ans[i] = dsu.valueMap.get(from);
            } else {
                ans[i] = -1;
            }
        }
        return ans;
    }

    public class DSU {
        HashMap<Integer, Integer> parentMap = new HashMap<>();
        HashMap<Integer, Integer> valueMap = new HashMap<>();

        public DSU(){
        }
        public int find(int i) {
            if (!parentMap.containsKey(i)) return -1;
            return parentMap.get(i) == i ? i : find(parentMap.get(i));
        }

        public void join(int x, int y, int value) {
            int parentX = find(x);
            int parentY = find(y);
            if (parentX == -1 && parentY == -1) {
                parentMap.put(y, x);
                parentMap.put(x, x);
                valueMap.put(x, value);
            } else if (parentX == -1) {
                parentMap.put(x, parentY);
                valueMap.merge(parentY, value, (a, b) -> a & b);
            } else if (parentY == -1) {
                parentMap.put(y, parentX);
                valueMap.merge(parentX, value, (a, b) -> a & b);
            } else {
                parentMap.put(parentY, parentX);
                valueMap.merge(parentX, value & valueMap.getOrDefault(parentY, value), (a, b) -> a & b);
            }
        }
    }
}