class Solution {
    public List<String> findItinerary(List<List<String>> tickets) {
        HashMap<String, List<String>> adjList = new HashMap<>();
        for (List<String> ticket : tickets) {
            String from = ticket.get(0);
            String to = ticket.get(1);
            adjList.computeIfAbsent(from, x -> new ArrayList<>());
            adjList.get(from).add(to);
        }
        for (List<String> values : adjList.values()) {
            values.sort(Comparator.comparing(x -> x));
        }
        Stack<String> stack = new Stack<>();
        stack.push("JFK");
        Stack<String> ans = new Stack<>();
        while (!stack.isEmpty()) {
            String curr = stack.peek();
            if (adjList.getOrDefault(curr, new ArrayList<>()).isEmpty()) {
                ans.add(stack.pop());
            } else {
                stack.push(adjList.get(curr).remove(0));
            }
        }
        List<String> realAns = new ArrayList<>();
        while (!ans.isEmpty()) realAns.add(ans.pop());
        return realAns;
    }
}