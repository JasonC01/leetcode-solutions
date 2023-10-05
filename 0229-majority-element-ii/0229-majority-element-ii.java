class Solution {
    public List<Integer> majorityElement(int[] nums) {
        Integer candidate1 = null;
        Integer candidate2 = null;
        int vote1 = 0;
        int vote2 = 0;
        for (int i : nums) {
            if (candidate1 != null && i == candidate1) {
                vote1++;
            } else if (candidate2 != null && i == candidate2) {
                vote2++;
            } else if (vote1 == 0) {
                candidate1 = i;
                vote1++;
            } else if (vote2 == 0) {
                candidate2 = i;
                vote2++;
            } else {
                vote1--;
                vote2--;
            }
        }
        int count1 = 0;
        int count2 = 0;
        for (int i : nums) {
            if (i == candidate1) {
                count1++;
            } else if (candidate2 != null && i == candidate2) {
                count2++;
            }
        }
        List<Integer> result = new ArrayList<>();
        if (count1 > nums.length / 3) result.add(candidate1);
        if (count2 > nums.length / 3) result.add(candidate2);
        return result;
    }
}