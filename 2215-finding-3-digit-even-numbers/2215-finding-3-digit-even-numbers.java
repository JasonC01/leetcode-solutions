class Solution {
    public int[] findEvenNumbers(int[] digits) {
        HashMap<Integer, Integer> counter = new HashMap<>();
        for (int i : digits) counter.merge(i, 1, (a, b) -> a + 1);
        HashSet<Integer> res = helper(counter, new StringBuilder());
        List<Integer> resArr = new ArrayList<>(res);
        resArr.sort(Comparator.comparing(x -> x));
        int[] ans = new int[resArr.size()];
        for (int i = 0; i < resArr.size(); i++) {
            ans[i] = resArr.get(i);
        }
        return ans;
    }

    public HashSet<Integer> helper(HashMap<Integer, Integer> counter, StringBuilder sb) {
        HashSet<Integer> ans = new HashSet<>();
        if (sb.length() == 3) {
            ans.add(Integer.parseInt(sb.toString()));
            return ans;
        }
        for (int i : counter.keySet()) {
            if (!(sb.isEmpty() && i == 0) && !(sb.length() == 2 && i % 2 == 1) && counter.get(i) > 0) {
                sb.append(i);
                counter.merge(i, 0, (a, b) -> a - 1);
                ans.addAll(helper(counter, sb));
                sb.deleteCharAt(sb.length() - 1);
                counter.merge(i, 1, (a, b) -> a + 1);
            }
        }
        return ans;
    }
}