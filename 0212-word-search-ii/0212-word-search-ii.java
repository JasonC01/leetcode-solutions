class Solution {
    public class Trie {
        char EOS = '#';
        public class TrieNode {
            char currChar;
            Optional<String> word = Optional.empty();
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
            TrieNode eos = new TrieNode(EOS);
            eos.word = Optional.of(word);
            curr.neighbours.put(EOS, eos);
        }

        public boolean search(String word) {
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

    public List<String> findWords(char[][] board, String[] words) {
        Trie trie = new Trie();
        for (String word : words) {
            trie.insert(word);
        }
        HashSet<String> res = new HashSet<>();
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (trie.root.neighbours.containsKey(board[i][j])) {
                    dfs(board, trie.root.neighbours.get(board[i][j]), i, j, new boolean[board.length][board[0].length], res);
                }
            }
        }
        return new ArrayList<>(res);
    }
    
    public void dfs(char[][] board, Trie.TrieNode curr, int y, int x, boolean[][] visited, HashSet<String> res) {
        if (y < 0 || x < 0 || y > board.length - 1 || x > board[0].length - 1 || visited[y][x] || curr.currChar != board[y][x]) return;
        visited[y][x] = true;
        for (Trie.TrieNode adj : curr.neighbours.values()) {
            adj.word.ifPresent(res::add);
            dfs(board, adj, y + 1, x, visited, res);
            dfs(board, adj, y - 1, x, visited, res);
            dfs(board, adj, y, x + 1, visited, res);
            dfs(board, adj, y, x - 1, visited, res);
        }
        visited[y][x] = false;
    }
}