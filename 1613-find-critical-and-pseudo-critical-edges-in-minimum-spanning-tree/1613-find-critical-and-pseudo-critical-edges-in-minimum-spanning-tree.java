class Solution {
    PriorityQueue<Integer> pq;
    boolean[] used;
    int nn;
    int min;
    DSU dsu;
    public List<List<Integer>> findCriticalAndPseudoCriticalEdges(int n, int[][] edges) {
        nn = n;
        pq = new PriorityQueue<>(Comparator.comparing(x -> edges[x][2]));
        dsu = new DSU(n);
        used = new boolean[edges.length];
        List<Integer> e = new ArrayList<>();
        for (int i = 0; i < edges.length; i++) {
            e.add(i);
        }
        pq.addAll(e);
        min = kruskal(pq, edges);
        List<Integer> critical = new ArrayList<>();
        List<Integer> pseudoCritical = new ArrayList<>();
        for (int i = 0; i < edges.length; i++) {
            pq.addAll(e);
            pq.remove(i);
            dsu = new DSU(n);
            int res = kruskal(pq, edges);
            if (res > min) {
                critical.add(i);
            } else {
                pseudoCritical.add(i);
            }
        }
        for (int i = 0; i < edges.length; i++) {
            pq.addAll(e);
            pq.remove(i);
            dsu = new DSU(n);
            dsu.union(edges[i][0], edges[i][1]);
            int res = kruskalWithInitial(pq, edges, i);
            if (res == min) {
                used[i] = true;
            }
        }
        for (int i = 0; i < used.length; i++) {
            if (!used[i]) {
                pseudoCritical.remove((Integer) i);
            }
        }

        List<List<Integer>> ans = new ArrayList<>();
        ans.add(critical);
        ans.add(pseudoCritical);
        System.out.println(min);
        return ans;
    }

    public int kruskal(PriorityQueue<Integer> pq, int[][] edges) {
        int ans = 0;
        List<Integer> usedEdges = new ArrayList<>();
        while (!pq.isEmpty()) {
            int curr = pq.poll();
            int first = edges[curr][0];
            int second = edges[curr][1];
            int weight = edges[curr][2];
            if (dsu.find(first) != dsu.find(second)) {
                usedEdges.add(curr);
                ans += weight;
                dsu.union(first, second);
            }
        }
        int parent = dsu.find(0);
        for (int i = 1; i < nn; i++) {
            if (dsu.find(i) != parent) {
                return Integer.MAX_VALUE;
            }
        }
        if (ans == min) {
            for (int i : usedEdges) {
                used[i] = true;
            }
        }
        return ans;
    }

    public int kruskalWithInitial(PriorityQueue<Integer> pq, int[][] edges, int usedEdge) {
        int ans = edges[usedEdge][2];
        List<Integer> usedEdges = new ArrayList<>();
        usedEdges.add(usedEdge);
        while (!pq.isEmpty()) {
            int curr = pq.poll();
            int first = edges[curr][0];
            int second = edges[curr][1];
            int weight = edges[curr][2];
            if (dsu.find(first) != dsu.find(second)) {
                usedEdges.add(curr);
                ans += weight;
                dsu.union(first, second);
            }
        }
        int parent = dsu.find(0);
        for (int i = 1; i < nn; i++) {
            if (dsu.find(i) != parent) {
                return Integer.MAX_VALUE;
            }
        }
        if (ans == min) {
            for (int i : usedEdges) {
                used[i] = true;
            }
        }
        return ans;
    }

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

}