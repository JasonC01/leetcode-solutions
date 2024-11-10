class Solution {
    HashMap<Integer, Integer> counter = new HashMap<>();
    public int minimumSubarrayLength(int[] nums, int k) {
        int low = 0;
        int high = 1;
        int curr = nums[0];
        int ans = Integer.MAX_VALUE;
        pushToCounter(nums[0]);
        while (high <= nums.length && low < high) {
            // System.out.println(curr);
            // System.out.println(counter);
            if (curr >= k) {
                ans = Math.min(ans, high - low);
                int rm = removeFromCounter(nums[low]);
                // System.out.println("removed called with: " + nums[low]);
                // System.out.println("removed: " + rm);
                curr -= rm;
                low++;
            } else {
                if (high < nums.length) {
                    curr = curr + nums[high] - (curr & nums[high]);
                    pushToCounter(nums[high]);
                }
                high++;
            }
        }
        // System.out.println(curr);
        if (curr >= k && high - low > 0) {
            ans = Math.min(ans, high - low);
        }
        return ans == Integer.MAX_VALUE ? -1 : ans;
    }

    public void pushToCounter(int x) {
        int index = 0;
        while (x > 0) {
            int finalX = x;
            counter.merge(index, x % 2, (a, b) -> a + (finalX % 2));
            x /= 2;
            index++;
        }
    }

    public int removeFromCounter(int x) {
        int index = 0;
        int res = 0;
        // System.out.println(counter);
        while (x > 0) {
            int finalX = x;
            counter.merge(index, 0, (a, b) -> a - (finalX % 2));
            if (counter.get(index) == 0 && finalX % 2 == 1) {
                res += (int) Math.pow(2, index);
            }
            x /= 2;
            index++;
        }
        return res;
    }
}