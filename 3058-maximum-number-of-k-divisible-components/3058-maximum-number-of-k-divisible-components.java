class Solution {
    public int maxKDivisibleComponents(int n, int[][] edges, int[] values, int k) {
        long[] valuess = new long[values.length];
        if (n == 1) {
            return 1;
        }
        HashMap<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            map.put(i, new ArrayList<>());
        }
        int[] degree = new int[n];
        for (int[] edge : edges) {
            degree[edge[0]]++;
            degree[edge[1]]++;
            map.get(edge[0]).add(edge[1]);
            map.get(edge[1]).add(edge[0]);
        }
        Queue<Integer> q = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            valuess[i] = values[i];
            if (degree[i] == 1) {
                q.add(i);
            }
        }
        int ans = 0;
        HashSet<Integer> visited = new HashSet<>();
        while (!q.isEmpty()) {
            // System.out.println(Arrays.toString(valuess));
            // System.out.println(Arrays.toString(degree));
            int curr = q.poll();
            // System.out.println(curr);
            if (visited.contains(curr)) {
                continue;
            }
            visited.add(curr);
            if (valuess[curr] % k == 0) {
                System.out.println(curr);
                ans++;
                for (int i : map.get(curr)) {
                    map.get(i).remove((Integer)curr);
                    degree[i]--;
                    if (degree[i] <= 1 && !visited.contains(i) && !q.contains(i)) {
                        q.add(i);
                    }

                }
            } else {
                for (int i : map.get(curr)) {
                    valuess[i] += valuess[curr];
                    map.get(i).remove((Integer)curr);
                    degree[i]--;
                    if (degree[i] <= 1 && !visited.contains(i) && !q.contains(i)) {
                        q.add(i);
                    }
                }
            }
        }
        return ans;
    }

}