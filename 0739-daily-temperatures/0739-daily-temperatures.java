class Solution {
     public int[] dailyTemperatures(int[] temperatures) {
        Stack<int[]> s = new Stack<>();
        int[] ans = new int[temperatures.length];
        for (int i = 0; i < temperatures.length; i++) {
            int temp = temperatures[i];
            int days = 1;
            while (!s.isEmpty() && s.peek()[0] < temp) {
                int[] curr = s.pop();
                ans[curr[1]] = i - curr[1];
            }
            s.push(new int[]{temp, i});
        }
        while (!s.isEmpty()) {
            int[] curr = s.pop();
            ans[curr[1]] = 0;
        }
        return ans;
    }
}