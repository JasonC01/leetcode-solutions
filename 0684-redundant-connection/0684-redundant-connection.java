class Solution {
    public int[] findRedundantConnection(int[][] edges) {
        DSU dsu = new DSU(edges.length);
        for (int i = 0; i < edges.length; i++) {
            if (!dsu.join(edges[i][0], edges[i][1])) {
                return edges[i];
            }
        }
        return new int[]{};
    }

    public class DSU {

        HashMap<Integer, Integer> parentMap = new HashMap<>();
        public DSU(int n) {
            for (int i = 0; i < n + 1; i++) {
                parentMap.put(i, i);
            }
        }

        public int find(int x) {
            while (!(parentMap.get(x) == x)) {
                x = parentMap.get(x);
            }
            return x;
        }
        public boolean join(int first, int second) {
            int firstParent = find(first);
            int secondParent = find(second);
            if (firstParent == secondParent) {
                return false;
            }
            parentMap.put(firstParent, secondParent);
            return true;
        }

    }
}