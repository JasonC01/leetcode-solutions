class Solution {
    public int maximumSum(int[] nums) {
        HashMap<Integer, List<Integer>> map = new HashMap<>();
        Arrays.sort(nums);
        for (int i : nums) {
            int digitSum = getDigitSum(i);
            if (!map.containsKey(digitSum)) {
                map.put(digitSum, new ArrayList<>());
            }
            map.get(digitSum).add(i);
        }
        int ans = -1;
        for (List<Integer> digitSums : map.values()) {
            if (digitSums.size() >= 2) {
                ans = Math.max(ans, digitSums.get(digitSums.size() - 1) + digitSums.get(digitSums.size() - 2));
            }
        }
        return ans;
    }

    public int getDigitSum(int i) {
        int sum = 0;
        while (i > 0) {
            sum += i % 10;
            i /= 10;
        }
        return sum;
    }
}