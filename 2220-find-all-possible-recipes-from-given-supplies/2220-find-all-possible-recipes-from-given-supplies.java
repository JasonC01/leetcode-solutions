class Solution {
    public List<String> findAllRecipes(String[] recipes, List<List<String>> ingredients, String[] supplies) {
        HashMap<String, List<String>> adjList = new HashMap<>();
        List<String> ans = new ArrayList<>();
        HashSet<String> recSet = new HashSet<>(Arrays.asList(recipes));
        HashMap<String, Integer> inDegree = new HashMap<>();
        for (int i = 0; i < ingredients.size(); i++) {
            String dish = recipes[i];
            List<String> ing = ingredients.get(i);
            for (String s : ing) {
                if (!adjList.containsKey(s)) {
                    adjList.put(s, new ArrayList<>());
                }
                adjList.get(s).add(dish);
                inDegree.merge(dish, 1, (a, b) -> a + 1);
            }
        }
        System.out.println(adjList);
        System.out.println(inDegree);
        Queue<String> q = new ArrayDeque<>(Arrays.asList(supplies));
        while (!q.isEmpty()) {
            String curr = q.poll();
            if (recSet.contains(curr)) {
                ans.add(curr);
            }
            for (String adj : adjList.getOrDefault(curr, new ArrayList<>())) {
                inDegree.merge(adj, 0, (a, b) -> a - 1);
                if (inDegree.get(adj) == 0) {
                    q.add(adj);
                }
            }
        }
        return ans;
    }
}