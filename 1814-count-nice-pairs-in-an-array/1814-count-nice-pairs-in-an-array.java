class Solution {
    int mod = (int) (1e9 + 7);
    public int countNicePairs(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int ans = 0;
        for (int i = nums.length - 1; i >= 0; i--) {
            int diff = diff(nums[i]);
            ans = (ans + map.getOrDefault(diff, 0)) % mod;
            map.merge(diff, 1, (a, b) -> a + 1);
        }
        System.out.println(map);
        return ans;
    }
    
    public int diff(int x) {
        int reversed = 0;
        int curr = x;
        while (curr > 0) {
            reversed *= 10;
            reversed += curr % 10;
            curr /= 10;
        }
        return x - reversed;
    }
}