class Solution {
    class Trie {
        public char c;
        public HashMap<Character, Trie> children;

        public Trie(char c) {
            this.c = c;
            children = new HashMap<>();
        }

        @Override
        public String toString() {
            return String.valueOf(c);
        }
    }
    public int longestCommonPrefix(int[] arr1, int[] arr2) {
        HashMap<Character, Trie> map = new HashMap<>();
        int ans = 0;
        for (int i : arr2) {
            String x = String.valueOf(i);
            if (!map.containsKey(x.charAt(0))) {
                map.put(x.charAt(0), new Trie(x.charAt(0)));
            }
            Trie curr = map.get(x.charAt(0));
            for (int y = 1; y < x.length(); y++) {
                Trie next = new Trie(x.charAt(y));
                if (curr.children.containsKey(x.charAt(y))) {
                    next = curr.children.get(x.charAt(y));
                } else {
                    curr.children.put(x.charAt(y), next);
                }
                curr = next;
            }
        }
        for (int i : arr1) {
            String x = String.valueOf(i);
            Trie curr = map.getOrDefault(x.charAt(0), null);
            int index = curr == null ? 0 : 1;
            while (curr != null && index < x.length()) {
                curr = curr.children.getOrDefault(x.charAt(index), null);
                if (curr != null) {
                    index++;
                }
            }
            ans = Math.max(ans, index);
        }
        return ans;
    }

}