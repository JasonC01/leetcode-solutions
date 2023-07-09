class Solution {
    public List<List<Integer>> findDifference(int[] nums1, int[] nums2) {
        List<List<Integer>> ans = new ArrayList<>();
        HashSet<Integer> first = new HashSet<>();
        HashSet<Integer> second = new HashSet<>();
        List<Integer> arr1 = new ArrayList<>();
        List<Integer> arr2 = new ArrayList<>();
        for (int i : nums1) {
            first.add(i);
        }
        for (int i : nums2) {
            second.add(i);
        }
        for (int i : first) {
            if (!second.contains(i)) {
                arr1.add(i);
            }
        }
        for (int i : second) {
            if (!first.contains(i)) {
                arr2.add(i);
            }
        }
        ans.add(arr1);
        ans.add(arr2);
        return ans;
    }
}