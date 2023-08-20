class Solution {
    public int[] sortItems(int n, int m, int[] group, List<List<Integer>> beforeItems) {
        List<List<Integer>> adjList = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adjList.add(new ArrayList<>());
        }
        int[] degree = new int[n];
        for (int i = 0; i < beforeItems.size(); i++) {
            List<Integer> curr = beforeItems.get(i);
            for (int j : curr) {
                adjList.get(j).add(i);
            }
            degree[i] = beforeItems.get(i).size();
        }
        List<List<Integer>> groups = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            groups.add(new ArrayList<>());
        }
        List<Integer> sorted = topologicalSort(degree, adjList);
        List<Integer> noGroup = new ArrayList<>();
        for (int i : sorted) {
            if (group[i] != -1) {
                groups.get(group[i]).add(i);
            } else {
                noGroup.add(i);
            }

        }
        int index = 0;
        for (List<Integer> g : groups) {
            if (g.size() == 0 && index < noGroup.size()) {
                g.add(noGroup.get(index++));
            }
        }
        System.out.println(sorted);
        System.out.println(groups);

        List<List<Integer>> groupDependency = new ArrayList<>();
        for (int i = 0; i < groups.size(); i++) {
            groupDependency.add(new ArrayList<>());
        }
        Map<Integer, Integer> actualGroups = new HashMap<>();
        for (int i = 0; i < groups.size(); i++) {
            List<Integer> curr = groups.get(i);
            for (int j : curr) {
                actualGroups.put(j, i);
            }
        }
        int[] groupDegree = new int[actualGroups.keySet().size()];
        for (int k = 0; k < groups.size(); k++) {
            List<Integer> g = groups.get(k);
            for (int i : g) {
                if (beforeItems.get(i).size() > 0) {
                    for (int j : beforeItems.get(i)) {
                        if (actualGroups.get(j) != k) {
                            groupDependency.get(actualGroups.get(j)).add(k);
                            groupDegree[k]++;
                        }
                    }
                }
            }
        }
        
        // for (int i = 0; i < actualGroups.size(); i++) {
        //     groupDegree[i] = groupDependency.get(i).size();
        // }
        System.out.println(Arrays.toString(groupDegree));
        List<Integer> ans = topologicalSort(groupDegree, groupDependency);
        List<Integer> realAns = new ArrayList<>();
        System.out.println(ans);
        for (int i : ans) {
            realAns.addAll(groups.get(i));
        }
        int[] realrealans = new int[realAns.size()];
        for (int i = 0; i < realAns.size(); i++) {
            realrealans[i] = realAns.get(i);
        }
        System.out.println(groupDependency);
        return realrealans;
    }

    public List<Integer> topologicalSort(int[] degree, List<List<Integer>> adjList) {
        List<Integer> added = new ArrayList<>();
        Queue<Integer> q = new ArrayDeque<>();
        for (int i = 0; i < degree.length; i++) {
            if (degree[i] == 0) {
                q.add(i);
            }
        }
        while (!q.isEmpty()) {
            int curr = q.poll();
            added.add(curr);
            for (int adj : adjList.get(curr)) {
                degree[adj]--;
                if (degree[adj] == 0) {
                    q.add(adj);
                }
            }
        }
        return added.size() == degree.length ? added : new ArrayList<>();
    }

}