class Solution {
    public int minimumIndex(List<Integer> nums) {
        int dom = -1;
        int count = 0;
        for (int i : nums) {
            if (i == dom) {
                count++;
            } else {
                if (count == 0) {
                    dom = i;
                    count = 1;
                } else {
                    count--;
                }
            }
        }
        count = 0;
        for (int i : nums) {
            if (i == dom) {
                count++;
            }
        }
        int currCount = 0;
        for (int i = 0; i < nums.size(); i++) {
            if (nums.get(i) == dom) {
                currCount++;
            }
            if ((currCount > (i + 1) / 2) && ((count - currCount) > (nums.size() - i - 1) / 2)) {
                return i;
            }
        }
        return -1;
    }
}