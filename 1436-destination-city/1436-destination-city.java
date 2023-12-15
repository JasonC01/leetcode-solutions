class Solution {
    public String destCity(List<List<String>> paths) {
        HashMap<String, Integer> map = new HashMap<>();
        for (List<String> path : paths) {
            String from = path.get(0);
            String to = path.get(1);
            map.merge(from, 1, (a, b) -> a + 1);
            map.merge(to, 0, (a, b) -> a + 1);
        }
        for (String s : map.keySet()) {
            if (map.get(s) == 0) {
                return s;
            }
        }
        return "";
    }
}