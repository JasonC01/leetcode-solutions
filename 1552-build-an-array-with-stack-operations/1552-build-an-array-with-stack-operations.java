class Solution {
    public List<String> buildArray(int[] target, int n) {
        List<String> ans = new ArrayList<>();
        int index = 0;
        for (int i = 1; i <= n; i++) {
            if (index > target.length - 1) {
                break;
            }
            ans.add("Push");
            if (target[index] != i) {
                ans.add("Pop");
            } else {
                index++;
            }
        }
        return ans;
    }
}