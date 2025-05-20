class Trie {
    char EOS = '#';
    class TrieNode {
        char currChar;
        HashMap<Character, TrieNode> neighbours = new HashMap<>();
        public TrieNode(char c) {
            this.currChar = c;
        }
    }
    TrieNode root = new TrieNode('.');
    public Trie() {
        
    }
    public void insert(String word) {
        TrieNode curr = root;
        int index = 0;
        while (index < word.length() && curr.neighbours.containsKey(word.charAt(index))) {
            curr = curr.neighbours.get(word.charAt(index));
            index++;
        }
        while (index < word.length()) {
            curr.neighbours.put(word.charAt(index), new TrieNode(word.charAt(index)));
            curr = curr.neighbours.get(word.charAt(index));
            index++;
        }
        curr.neighbours.put(EOS, new TrieNode(EOS));
    }

    public boolean search(String word) {
        // System.out.println(root.neighbours);
        TrieNode curr = root;
        int index = 0;
        while (index < word.length() && curr.neighbours.containsKey(word.charAt(index))) {
            curr = curr.neighbours.get(word.charAt(index));
            index++;
        }
        return index == word.length() && curr.neighbours.containsKey(EOS);
    }

    public boolean startsWith(String prefix) {
        TrieNode curr = root;
        int index = 0;
        while (index < prefix.length() && curr.neighbours.containsKey(prefix.charAt(index))) {
            curr = curr.neighbours.get(prefix.charAt(index));
            index++;
        }
        return index == prefix.length();
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */