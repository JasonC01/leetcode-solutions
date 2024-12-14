class Solution {
    public long continuousSubarrays(int[] nums) {
        long ans = 0;
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a, b) -> Integer.compare(b, a));
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        int low = -1;
        int high = 0;
        while (high < nums.length) {
            maxHeap.add(nums[high]);
            minHeap.add(nums[high]);
            int min = minHeap.peek();
            int max = maxHeap.peek();
            if (max - min > 2) {
                while (max - min > 2) {
                    maxHeap.remove(nums[low + 1]);
                    minHeap.remove(nums[++low]);
                    min = minHeap.peek();
                    max = maxHeap.peek();
                }
            }
            ans += high - low;
            high++;
        }
        return ans;
    }
}