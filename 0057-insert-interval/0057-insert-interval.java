class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        Stack<int[]> stack = new Stack<>();
        List<int[]> ints = new ArrayList<>(Arrays.asList(intervals));
        ints.add(newInterval);
        ints.sort(Comparator.comparing(x -> x[0]));
        for (int[] i : ints) {
            if (stack.isEmpty()) {
                stack.push(i);
                continue;
            }
            int[] peeked = stack.peek();
            if (peeked[1] >= i[0]) {
                peeked[1] = Math.max(peeked[1], i[1]);
            } else {
                stack.push(i);
            }
        }
        int[][] ans = new int[stack.size()][2];
        for (int i = stack.size() - 1; i >= 0; i--) {
            ans[i] = stack.pop();
        }
        return ans;
    }

}