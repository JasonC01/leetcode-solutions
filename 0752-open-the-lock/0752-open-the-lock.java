class Solution {
    public int openLock(String[] deadends, String target) {
        Queue<List<Integer>> q = new ArrayDeque<>();
        HashSet<String> visited = new HashSet<>();
        List<String> ends = List.of(deadends);
        q.add(List.of(0, 0, 0, 0));
        int level = 0;
        int levelSize = q.size();
        while (!q.isEmpty()) {
            List<Integer> current = q.poll();
            levelSize--;
            String conv = convertListToString(current);
            if (target.equals(conv)) {
                return level;
            }
            if (!ends.contains(conv) && !visited.contains(conv)) {
                visited.add(conv);
                for (int i = 0; i < current.size(); i++) {
                    List<Integer> prev = new ArrayList<>(current);
                    List<Integer> next = new ArrayList<>(current);
                    next.set(i, (current.get(i) + 1) % 10);
                    prev.set(i, (10 + current.get(i) - 1) % 10);
                    if (!visited.contains(convertListToString(prev))) {
                        q.add(prev);
                    }
                    if (!visited.contains(convertListToString(next))) {
                        q.add(next);
                    }
                }
            }
            if (levelSize == 0) {
                level++;
                levelSize = q.size();
            }
        }
        return -1;
    }


    public String convertListToString(List<Integer> current) {
        StringBuilder sb = new StringBuilder();
        for (int i : current) {
            sb.append(i);
        }
        return sb.toString();
    }
}