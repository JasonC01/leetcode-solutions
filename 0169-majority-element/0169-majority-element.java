class Solution {
    public int majorityElement(int[] nums) {
        int curr = nums[0];
        int vote = 1;
        for (int i = 1; i < nums.length; i++) {
            int x = nums[i];
            if (vote == 0) {
                curr = x;
                vote = 1;
            } else if (curr == x) {
                vote++;
            } else {
                vote--;
            }
        }
        return curr;
    }
}