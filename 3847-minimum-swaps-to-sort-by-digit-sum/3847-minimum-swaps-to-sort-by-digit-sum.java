class Solution {
    public int minSwaps(int[] nums) {
        List<int[]> arr = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            arr.add(new int[]{getDigitSum(nums[i]), i});
        }
        arr.sort(Comparator.comparing(x -> nums[x[1]]));
        arr.sort(Comparator.comparing(x -> x[0]));
        int ans = 0;
        boolean[] resolved = new boolean[nums.length];
        for (int i = 0; i < nums.length; i++) {
            if (resolved[i]) continue;
            int[] curr = arr.get(i);
            if (curr[1] != i) {
                while (!resolved[curr[1]]) {
                    resolved[curr[1]] = true;
                    curr = arr.get(curr[1]);
                    ans++;
                }
                ans--;
            }
        }
        return ans;
    }
    
    public int getDigitSum(int x) {
        
        int res = 0;
        while (x > 0) {
            res += x % 10;
            x /= 10;
        }
        System.out.println(res);
        return res;
    }

}