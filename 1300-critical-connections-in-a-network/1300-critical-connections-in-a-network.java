class Solution {
    public List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) {
        HashMap<Integer, List<Integer>> adjList = new HashMap<>();
        boolean[] visited = new boolean[n];
        int[] lowLinkValues = new int[n];
        for (int i = 0; i < n; i++) {
            adjList.put(i, new ArrayList<>());
            lowLinkValues[i] = i;
        }
        for (List<Integer> edge : connections) {
            int from = edge.get(0);
            int to = edge.get(1);
            adjList.get(from).add(to);
            adjList.get(to).add(from);
        }
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                dfs(i, adjList, new Stack<>(), visited, lowLinkValues, -1);
            }
        }
        List<List<Integer>> ans = new ArrayList<>();
        HashMap<Integer, HashMap<Integer, List<List<Integer>>>> map = new HashMap<>();
        for (List<Integer> edge : connections) {
            int fromLowLink = lowLinkValues[edge.get(0)];
            int toLowLink = lowLinkValues[edge.get(1)];
            if (fromLowLink != toLowLink) {
                if (map.containsKey(fromLowLink) && map.get(fromLowLink).containsKey(toLowLink)) {
                    map.get(fromLowLink).get(toLowLink).add(edge);
                } else if (map.containsKey(toLowLink) && map.get(toLowLink).containsKey(fromLowLink)) {
                    map.get(toLowLink).get(fromLowLink).add(edge);
                } else if (map.containsKey(fromLowLink)) {
                    map.get(fromLowLink).put(toLowLink, new ArrayList<>());
                    map.get(fromLowLink).get(toLowLink).add(edge);
                } else if (map.containsKey(toLowLink)) {
                    map.get(toLowLink).put(fromLowLink, new ArrayList<>());
                    map.get(toLowLink).get(fromLowLink).add(edge);
                } else {
                    map.put(fromLowLink, new HashMap<>());
                    map.get(fromLowLink).put(toLowLink, new ArrayList<>());
                    map.get(fromLowLink).get(toLowLink).add(edge);
                }
            }
        }
        for (int from : map.keySet()) {
            for (int to : map.get(from).keySet()) {
                if (map.get(from).get(to).size() == 1) {
                    ans.addAll(map.get(from).get(to));
                }
            }
        }
        return ans;
    }


    public int dfs(int currNode, HashMap<Integer, List<Integer>> adjList, Stack<Integer> stack, boolean[] visited, int[] lowLinkValues, int prev) {
        if (visited[currNode]) {
            return stack.contains(currNode) ? lowLinkValues[currNode] : Integer.MAX_VALUE;
        }
        visited[currNode] = true;
        stack.push(currNode);
        int currLowLinkVal = currNode;
        for (int adj : adjList.get(currNode)) {
            if (adj == prev) {
                continue;
            }
            currLowLinkVal = Math.min(currLowLinkVal, dfs(adj, adjList, stack, visited, lowLinkValues, currNode));
        }
        if (currNode == currLowLinkVal) {
            while (stack.peek() != currNode) {
                lowLinkValues[stack.pop()] = currNode;
            }
            stack.pop();
        }
        return currLowLinkVal;
    }
}