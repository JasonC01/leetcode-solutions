class Solution {
    class Trie {
        String val;
        HashMap<String, Trie> neighbours = new HashMap<>();

        public Trie(String val) {
            this.val = val;
        }
    }

    List<String> ans = new ArrayList<>();
    public List<String> removeSubfolders(String[] folder) {
        HashMap<String, Trie> map = new HashMap<>();
        for (String s : folder) {
            String[] arr = s.split("/");
            arr = Arrays.copyOfRange(arr, 1, arr.length);
            // System.out.println(Arrays.toString(arr));
            if (!map.containsKey(arr[0])) {
                map.put(arr[0], new Trie(arr[0]));
            }
            Trie curr = map.get(arr[0]);
            for (int i = 1; i < arr.length; i++) {
                if (!curr.neighbours.containsKey(arr[i])) {
                    curr.neighbours.put(arr[i], new Trie(arr[i]));
                }
                curr = curr.neighbours.get(arr[i]);
            }
            curr.neighbours.put("-", new Trie("-"));
        }
        for (Trie t : map.values()) {
            traverse(t, new StringBuilder());
        }
        return ans;
    }

    public void traverse(Trie t, StringBuilder currentPath) {
        currentPath.append("/");
        currentPath.append(t.val);
        if (t.neighbours.containsKey("-")) {
            ans.add(currentPath.toString());
            return;
        }
        int currentLength = currentPath.length();
        for (Trie next : t.neighbours.values()) {
            traverse(next, currentPath);
            currentPath.delete(currentLength, currentPath.length());
        }
    }

}