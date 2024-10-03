class Solution {
     public int minSubarray(int[] nums, int p) {
        long total = 0;
        for (int i : nums) {
            total += i;
        }
        long rem = total % p;
        if (rem == 0) {
            return 0;
        }
        long pSum = 0;
        int ans = nums.length;
        HashMap<Long, Integer> map = new HashMap<>();
        map.put(0L, -1);
        for (int i = 0; i < nums.length; i++) {
            pSum = (pSum + nums[i]) % p;
            long key = (pSum - rem + p) % p;
            if (map.containsKey(key)) {
                ans = Math.min(ans, i - map.get(key));
                
            } 
            map.put(pSum, i);
        }
        return ans == nums.length ? -1 : ans;
    }
}