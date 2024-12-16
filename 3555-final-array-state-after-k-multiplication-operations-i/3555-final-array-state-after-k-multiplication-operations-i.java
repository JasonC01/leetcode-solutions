class Solution {
    public int[] getFinalState(int[] nums, int k, int multiplier) {
        HashMap<Integer, PriorityQueue<Integer>> map = new HashMap<>();
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int i = 0; i < nums.length; i++) {
            pq.add(nums[i]);
            if (!map.containsKey(nums[i])) {
                map.put(nums[i], new PriorityQueue<>());
            }
            map.get(nums[i]).add(i);
        }
        for (int i = 0; i < k; i++) {
            int curr = pq.poll();
            int polled = map.get(curr).poll();
            if (!map.containsKey(curr * multiplier)) {
                map.put(curr * multiplier, new PriorityQueue<>());
            }
            map.get(curr * multiplier).add(polled);
            pq.add(curr * multiplier);
        }
        int[] ans = new int[nums.length];
        for (int i : map.keySet()) {
            PriorityQueue<Integer> q = map.get(i);
            while (!q.isEmpty()) {
                ans[q.poll()] = i;
            }
        }
        return ans;
    }
}