class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if (!wordList.contains(endWord)) {
            return 0;
        }
        HashMap<String, List<String>> adjList = new HashMap<>();
        adjList.put(beginWord, new ArrayList<>());
        for (String s : wordList) {
            if (checkAdj(beginWord, s)) {
                adjList.get(beginWord).add(s);
            }
        }
        for (int i = 0; i < wordList.size(); i++) {
            String curr = wordList.get(i);
            adjList.put(curr, new ArrayList<>());
            for (String s : wordList) {
                if (checkAdj(curr, s)) {
                    adjList.get(curr).add(s);
                }
            }
        }
        Queue<String> q = new ArrayDeque<>();
        q.add(beginWord);
        HashSet<String> visited = new HashSet<>();
        int level = 0;
        int levelSize = q.size();
        System.out.println(adjList);
        while (!q.isEmpty()) {
            String curr = q.poll();
            levelSize--;
            if (curr.equals(endWord)) {
                return level + 1;
            }
            if (!visited.contains(curr)) {
                visited.add(curr);
                q.addAll(adjList.get(curr));
            }
            if (levelSize == 0) {
                level++;
                levelSize = q.size();
            }
        }
        
        return 0;
    }


    public boolean checkAdj(String s1, String s2) {
        int diffCount = 0;
        for (int i = 0; i < s1.length(); i++) {
            if (s1.charAt(i) != s2.charAt(i)) diffCount++;
        }
        return diffCount == 1;
    }
}