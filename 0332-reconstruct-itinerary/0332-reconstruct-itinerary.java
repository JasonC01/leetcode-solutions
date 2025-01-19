class Solution {
    public List<String> findItinerary(List<List<String>> tickets) {
        HashMap<String, List<String>> adjList = new HashMap<>();
        HashMap<String, Integer> inDegree = new HashMap<>();
        HashMap<String, Integer> outDegree = new HashMap<>();
        for (List<String> ticket : tickets) {
            if (!adjList.containsKey(ticket.get(0))) {
                adjList.put(ticket.get(0), new ArrayList<>());
            }
            inDegree.merge(ticket.get(1),1, (a, b) -> a + 1);
            outDegree.merge(ticket.get(0), 1, (a, b) -> a + 1);
            adjList.get(ticket.get(0)).add(ticket.get(1));
        }
        Stack<String> q = new Stack<>();
        q.add("JFK");
        for (List<String> s : adjList.values()) {
            s.sort(Comparator.comparing(x -> x));
        }
        Stack<String> res = new Stack<>();
        
        // System.out.println(adjList);
        while (!q.isEmpty()) {
            // System.out.println(q);
            String curr = q.peek();
            if (adjList.getOrDefault(curr, new ArrayList<>()).isEmpty()) {
                // System.out.println(curr);
                res.add(q.pop());
            } else {
                q.add(adjList.get(curr).remove(0));
            }
        }
        List<String> ans = new ArrayList<>();
        while (!res.isEmpty()) {
            ans.add(res.pop());
        }
        return ans;
    }
}