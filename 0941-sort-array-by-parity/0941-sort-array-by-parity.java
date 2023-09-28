class Solution {
    public int[] sortArrayByParity(int[] nums) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.comparing(x -> x % 2 == 0 ? 0 : 1));
        for (int i : nums) {
            pq.add(i);
        }
        int[] ans = new int[nums.length];
        for (int i = 0; i < ans.length; i++) {
            ans[i] = pq.poll();
        }
        return ans;
    }
}