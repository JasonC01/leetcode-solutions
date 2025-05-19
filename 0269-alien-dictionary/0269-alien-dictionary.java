class Solution {
    public String alienOrder(String[] words) {
        List<Character> vocab = new ArrayList<>();
        for (String word : words) {
            for (char c : word.toCharArray()) {
                if (!vocab.contains(c)) vocab.add(c);
            }
        }
        HashMap<Character, Integer> inDegree = new HashMap<>();
        HashMap<Character, List<Character>> adjList = new HashMap<>();
        for (int currentPrefixLength = 0; currentPrefixLength <= 100; currentPrefixLength++) {
            String prefix = words[0].length() >= currentPrefixLength ? words[0].substring(0, currentPrefixLength) : "";
            for (int i = 1; i < words.length; i++) {
                String currentPrefix = words[i].length() >= currentPrefixLength ? words[i].substring(0, currentPrefixLength) : "";
                if (currentPrefix.equals(prefix)) {
                    Character prevChar = words[i - 1].length() > currentPrefixLength ? words[i - 1].charAt(currentPrefixLength) : '.';
                    Character currChar = words[i].length() > currentPrefixLength ? words[i].charAt(currentPrefixLength) : '.';
                    if (prevChar != '.' && currChar == '.') return "";
                    if (prevChar != currChar && prevChar != '.' && currChar != '.') {
                        System.out.println(prevChar);
                        System.out.println(currChar);
                        if (!adjList.containsKey(prevChar)) adjList.put(prevChar, new ArrayList<>());
                        if (!adjList.get(prevChar).contains(currChar)) {
                            adjList.get(prevChar).add(currChar);
                            inDegree.merge(currChar, 1, (a, b) -> a + 1);
                        }
                    }
                } else {
                    prefix = currentPrefix;
                }
            }
        }
        Queue<Character> q = new ArrayDeque<>();
        StringBuilder sb = new StringBuilder();
        HashSet<Character> added = new HashSet<>();
        System.out.println(adjList);
        for (char c : vocab) {
            if (inDegree.getOrDefault(c, 0) == 0) q.add(c);
        }
        while (!q.isEmpty()) {
            Character curr = q.poll();
            if (!added.contains(curr) && vocab.contains(curr)) {
                added.add(curr);
                sb.append(curr);
                for (char adj : adjList.getOrDefault(curr, new ArrayList<>())) {
                    inDegree.merge(adj, 0, (a, b) -> a - 1);
                    if (inDegree.get(adj) == 0) {
                        q.add(adj);
                    }
                }
            }
        }
        System.out.println(sb);
        return sb.length() == vocab.size() ? sb.toString() : "";
    }
}