class Solution {
    public int countPairs(int[] nums, int k) {
        int ans = 0;
        HashMap<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (!map.containsKey(nums[i])) map.put(nums[i], new ArrayList<>());
            map.get(nums[i]).add(i);
        }
        System.out.println(map);
        for (List<Integer> arr : map.values()) {
            for (int i = 0; i < arr.size(); i++) {
                for (int j = i + 1; j < arr.size(); j++) {
                    if ((arr.get(i) * arr.get(j)) % k == 0) ans++;
                }
            }
        }
        return ans;
    }

}