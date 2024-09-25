class Solution {
    class Trie {
        public char c;

        public int count;
        public HashMap<Character, Trie> children;

        public Trie(char c) {
            this.c = c;
            children = new HashMap<>();
            count = 0;
        }

    }

    public int[] sumPrefixScores(String[] words) {
        HashMap<Character, Trie> map = new HashMap<>();
        int[] ans = new int[words.length];
        for (String s : words) {
            if (!map.containsKey(s.charAt(0))) {
                map.put(s.charAt(0), new Trie(s.charAt(0)));
            }
            Trie curr = map.get(s.charAt(0));
            curr.count++;
            for (int y = 1; y < s.length(); y++) {
                Trie next = new Trie(s.charAt(y));
                if (curr.children.containsKey(s.charAt(y))) {
                    next = curr.children.get(s.charAt(y));
                } else {
                    curr.children.put(s.charAt(y), next);
                }
                next.count++;
                curr = next;
            }
        }
        for (int i = 0; i < words.length; i++) {
            String s = words[i];
            Trie curr = map.get(s.charAt(0));
            ans[i] += curr.count;
            for (int j = 1; j < s.length(); j++) {
                curr = curr.children.get(s.charAt(j));
                ans[i] += curr.count;
            }
        }
        return ans;
    }
}