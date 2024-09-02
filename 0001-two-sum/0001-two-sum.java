class Solution {
    public int[] twoSum(int[] nums, int target) {
        List<int[]> arr = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            arr.add(new int[]{nums[i], i});
        }
        arr.sort(Comparator.comparing(x -> x[0]));
        int low = 0;
        int high = nums.length - 1;
        while (low < high) {
            int l = arr.get(low)[0];
            int h = arr.get(high)[0];
            if (l + h == target) {
                return new int[]{arr.get(low)[1], arr.get(high)[1]};
            } else if (l + h < target) {
                low++;
            } else {
                high--;
            }
        }
        return new int[]{};
    }
}