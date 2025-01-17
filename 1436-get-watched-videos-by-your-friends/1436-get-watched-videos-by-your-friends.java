class Solution {
    public List<String> watchedVideosByFriends(List<List<String>> watchedVideos, int[][] friends, int id, int level) {
        HashMap<String, Integer> counter = new HashMap<>();
        Queue<Integer> q = new ArrayDeque<>();
        q.add(id);
        int currLevel = 0;
        int levelSize = 1;
        HashSet<Integer> visited = new HashSet<>();
        while (!q.isEmpty() && currLevel <= level) {
            int curr = q.poll();
            levelSize--;
            if (!visited.contains(curr)) {
                visited.add(curr);
                for (int i : friends[curr]) {
                    q.add(i);
                }
                if (currLevel == level) {
                    for (String s : watchedVideos.get(curr)) {
                        counter.merge(s, 1, (a, b) -> a + 1);
                    }
                }
            }
            if (levelSize == 0) {
                currLevel++;
                levelSize = q.size();
            }
        }
        List<String> ans = new ArrayList<>(counter.keySet());
        ans.sort(Comparator.comparing(x -> x));
        ans.sort(Comparator.comparing(counter::get));
        return ans;
    }
}