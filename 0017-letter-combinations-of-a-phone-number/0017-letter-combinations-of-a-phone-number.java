class Solution {
    HashMap<Integer, List<Character>> map = new HashMap<>();
    public List<String> letterCombinations(String digits) {
        char curr = 97;
        map.put(1, new ArrayList<>());
        for (int i = 2; i < 10; i++) {
            List<Character> arr = new ArrayList<>();
            for (int j = 0; j < ((i == 7 || i == 9) ? 4 : 3); j++) {
                arr.add(curr++);
            }
            map.put(i, arr);
        }
        return helper(digits, 0, new StringBuilder());
    }

    public List<String> helper(String s, int index, StringBuilder res) {
        List<String> ans = new ArrayList<>();
        if (index > s.length() - 1) {
            if (!res.isEmpty()) {
                ans.add(res.toString());
            }
            return ans;
        }
        for (Character c : map.get(Character.getNumericValue(s.charAt(index)))) {
            res.append(c);
            ans.addAll(helper(s, index + 1, res));
            res.deleteCharAt(res.length() - 1);
        }
        return ans;
    }
}