class Solution {
    public String findDifferentBinaryString(String[] nums) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < nums[0].length(); i++) {
            if (i <= nums.length - 1) {
                sb.append(nums[i].charAt(i) == '1' ? '0' : '1');
            } else {
                sb.append('0');
            }
        }
        return sb.toString();
    }
}