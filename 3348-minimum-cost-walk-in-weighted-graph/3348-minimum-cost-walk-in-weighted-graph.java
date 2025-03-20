class Solution {
    public int[] minimumCost(int n, int[][] edges, int[][] query) {
        DSU dsu = new DSU();
        int[] ans = new int[query.length];
        for (int[] edge : edges) {
            int from = edge[0];
            int to = edge[1];
            int weight = edge[2];
            dsu.join(from, to, weight);
        }
        System.out.println(dsu.parentMap);
        System.out.println(dsu.minWeightMap);
        for (int i = 0; i < query.length; i++) {
            int firstParent = dsu.find(query[i][0]);
            int secondParent = dsu.find(query[i][1]);
            ans[i] = firstParent != -1 && firstParent == secondParent ? dsu.minWeightMap.getOrDefault(firstParent, -1) : -1;
        }
        return ans;
    }

    public class DSU {
        HashMap<Integer, Integer> parentMap = new HashMap<>();
        HashMap<Integer, Integer> minWeightMap = new HashMap<>();

        public DSU() {}

        public void join(int x, int y, int weight) {
            int parentX = find(x);
            int parentY = find(y);
            if (parentY == -1 && parentX == -1) {
                parentMap.put(x, x);
                parentMap.put(y, x);
                minWeightMap.merge(x, weight, (a, b) -> a & weight);
            } else if (parentX == -1) {
                parentMap.put(x, parentY);
                minWeightMap.merge(parentY, weight, (a, b) -> a & weight);
            } else if (parentY == -1) {
                parentMap.put(y, parentX);
                minWeightMap.merge(parentX, weight, (a, b) -> a & weight);
            } else {
                parentMap.put(parentY, parentX);
                minWeightMap.merge(parentX, weight, (a, b) -> a & weight & minWeightMap.get(parentY));
            }
        }

        public int find(int i) {
            if (!parentMap.containsKey(i)) {
                return -1;
            }
            int parent = parentMap.get(i);
            while (parent != parentMap.get(parent)) {
                parent = parentMap.get(parent);
            }
            return parent;
        }
    }
}