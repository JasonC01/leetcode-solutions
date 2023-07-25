class Solution {
    HashMap<String, HashMap<String, Double>> adjList = new HashMap<>();
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {

        for (int i = 0; i < equations.size(); i++) {
            List<String> currEq = equations.get(i);
            double currval = values[i];
            adjList.merge(currEq.get(0), new HashMap<>(), (a, b) -> a);
            adjList.get(currEq.get(0)).put(currEq.get(1), currval);
            adjList.merge(currEq.get(1), new HashMap<>(), (a, b) -> a);
            adjList.get(currEq.get(1)).put(currEq.get(0), 1 / currval);
        }
        double[] ans = new double[queries.size()];
        for (int i = 0; i < queries.size(); i++) {
            String start = queries.get(i).get(0);
            String target = queries.get(i).get(1);
            if (!adjList.containsKey(start) || !adjList.containsKey(target)) {
                ans[i] = -1;
            } else {
                ans[i] = dfs(start, target, new HashSet<>(), 1);
            }
        }
        return ans;
    }
    public double dfs(String curr, String target, HashSet<String> visited, double res) {
        if (curr.equals(target)) {
            return res;
        }
        visited.add(curr);
        double ans = -1;
        for (String adj : adjList.get(curr).keySet()) {
            if (!visited.contains(adj)) {
                double result = dfs(adj, target, visited, res * adjList.get(curr).get(adj));
                if (result != -1) {
                    ans = result;
                    break;
                }
            }
        }
        return ans;
    }
}