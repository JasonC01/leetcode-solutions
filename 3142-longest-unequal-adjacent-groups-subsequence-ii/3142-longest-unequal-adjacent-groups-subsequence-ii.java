class Solution {
    public List<String> getWordsInLongestSubsequence(String[] words, int[] groups) {
        List<List<Integer>> arr = new ArrayList<>();
        for (int i = 0; i < words.length; i++) {
            arr.add(new ArrayList<>());
        }
        arr.get(arr.size() - 1).add(words.length - 1);
        for (int i = words.length - 2; i >= 0; i--) {
            List<Integer> res = new ArrayList<>();
            res.add(i);
            for (int j = i + 1; j < words.length; j++) {
                List<Integer> tempArr = new ArrayList<>(arr.get(j));
                if (!tempArr.isEmpty() && isCompatible(words[tempArr.get(0)], words[i]) && groups[tempArr.get(0)] != groups[i]) {
                    tempArr.add(0, i);
                    if (res.size() < tempArr.size()) res = tempArr;
                }
            }
            arr.set(i, res);
        }
        System.out.println(arr);
        List<Integer> longest = new ArrayList<>();
        for (List<Integer> s : arr) {
            if (s.size() > longest.size()) longest = s;
        }
        List<String> ans = new ArrayList<>();
        for (int i : longest) {
            ans.add(words[i]);
        }
        return ans;
    }



    public boolean isCompatible(String s, String t) {
        if (s.length() != t.length()) return false;
        boolean isDiff = false;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) != t.charAt(i)) {
                if (!isDiff) isDiff = true;
                else return false;
            }
        }
        return true;
    }
}