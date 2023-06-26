class Solution {
    public long totalCost(int[] costs, int k, int candidates) {
        int total = costs.length;
        if (total <= 2 * candidates) {
            Arrays.sort(costs);
            int ans = 0;
            for (int i = 0; i < k; i++) {
                ans += costs[i];
            }
            return ans;
        }
        long ans = 0;
        int leftIndex = 0;
        int rightIndex = total - 1;
        PriorityQueue<Integer> left = new PriorityQueue<>();
        PriorityQueue<Integer> right = new PriorityQueue<>();
        for (int i = leftIndex; i < candidates; i++) {
            left.add(costs[i]);
        }
        for (int i = rightIndex; i > Math.max(leftIndex, rightIndex - candidates); i--) {
            right.add(costs[i]);
        }
        leftIndex = candidates - 1;
        rightIndex = Math.max(leftIndex, rightIndex - candidates) + 1;
        for (int i = 0; i < k; i++) {
            if (left.isEmpty()) {
                ans += right.poll();
                rightIndex--;
                if (rightIndex > leftIndex) {
                    right.add(costs[rightIndex]);
                }
            } else if (right.isEmpty()) {
                ans += left.poll();
                leftIndex++;
                if (leftIndex < rightIndex) {
                    left.add(costs[leftIndex]);
                }
            } else {
                if (left.peek() <= right.peek()) {
                    ans += left.poll();
                    leftIndex++;
                    if (leftIndex < rightIndex) {
                        left.add(costs[leftIndex]);
                    }
                } else {
                    ans += right.poll();
                    rightIndex--;
                    if (rightIndex > leftIndex) {
                        right.add(costs[rightIndex]);
                    }
                }
            }
        }
        return ans;
    }
}