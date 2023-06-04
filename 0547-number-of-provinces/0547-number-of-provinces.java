class Solution {
    public class DSU {
        List<Integer> parent = new ArrayList<>();
        List<Integer> rank = new ArrayList<>();
        public DSU(int n) {
            for (int i = 0; i < n; i++) {
                parent.add(i);
                rank.add(1);
            }
        }

        public int find(int a) {
            return parent.get(a) == a ? a : find(parent.get(a));
        }

        public boolean union(int x, int y) {
            int xset = find(x);
            int yset = find(y);
            if (xset != yset) {
                if (rank.get(xset) < rank.get(yset)) {
                    parent.set(xset, yset);
                } else {
                    parent.set(yset, xset);
                }
                rank.set(xset, rank.get(xset) + rank.get(yset));
                return true;
            }
            return false;
        }
    }


    public int findCircleNum(int[][] isConnected) {
        DSU dsu = new DSU(isConnected.length);
        for (int i = 0; i < isConnected.length; i++) {
            for (int j = 0; j < isConnected[0].length; j++) {
                if (isConnected[i][j] == 1) {
                    dsu.union(i, j);
                }
            }
        }
        HashSet<Integer> parents = new HashSet<>();
        for (int i = 0; i < isConnected.length; i++) {
            parents.add(dsu.find(i));
        }
        return parents.size();
    }
}