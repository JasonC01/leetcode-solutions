class Solution {
    HashMap<String, List<String>> map;
    public List<String> findItinerary(List<List<String>> tickets) {
        map = new HashMap<>();
        for (List<String> ticket : tickets) {
            String from = ticket.get(0);
            String to = ticket.get(1);
            if (!map.containsKey(from)) {
                map.put(from, new ArrayList<>());
            }
            map.get(from).add(to);
        }
        for (List<String> value : map.values()) {
            value.sort(Comparator.comparing(x -> x));
        }
        List<String> res = new ArrayList<>();
        return dfs("JFK", res, tickets.size() + 1);
    }

     public List<String> dfs(String currentAirport, List<String> res, int resSize) {
        res.add(currentAirport);
        if (res.size() == resSize) {
            return new ArrayList<>(res);
        }
        if (!map.containsKey(currentAirport)) {
            return new ArrayList<>();
        }
        for (int i = 0; i < map.get(currentAirport).size(); i++) {
            String adj = map.get(currentAirport).get(i);
            if (adj.equals("")) {
                continue;
            }
            map.get(currentAirport).set(i, "");
            List<String> ans = dfs(adj, new ArrayList<>(res), resSize);
            map.get(currentAirport).set(i, adj);
            if (ans.size() == resSize) {
                return ans;
            }
        }
        return new ArrayList<>();
    }
}