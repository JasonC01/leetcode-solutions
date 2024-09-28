class Trie {

        HashMap<Character, Trie> map = new HashMap<>();
        public Trie() {
        }

        public void insert(String word) {
            if (!map.containsKey(word.charAt(0))) {
                map.put(word.charAt(0), new Trie());
            }
            Trie curr = map.get(word.charAt(0));
            for (int i = 1; i < word.length(); i++) {
                char c = word.charAt(i);
                if (!curr.map.containsKey(c)) {
                    curr.map.put(c, new Trie());
                }
                curr = curr.map.get(c);
            }
            curr.map.put('0', null);
        }

        public boolean search(String word) {
            Trie curr = this;
            for (char c : word.toCharArray()) {
                if (!curr.map.containsKey(c)) {
                    return false;
                }
                curr = curr.map.get(c);
            }
            return curr.map.containsKey('0');
        }

        public boolean startsWith(String prefix) {
            Trie curr = this;
            for (char c : prefix.toCharArray()) {
                if (!curr.map.containsKey(c)) {
                    return false;
                }
                curr = curr.map.get(c);
            }
            return true;
        }
    }

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */