class Solution {
    public int[] maximumBeauty(int[][] items, int[] queries) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int[] item : items) {
            int price = item[0];
            int beauty = item[1];
            map.merge(price, beauty, (a, b) -> Math.max(a, beauty));
        }
        List<Integer> keys = new ArrayList<>(map.keySet());
        keys.sort(Comparator.comparing(x -> x));
        for (int i = 1; i < keys.size(); i++) {
            map.put(keys.get(i), Math.max(map.get(keys.get(i)), map.get(keys.get(i - 1))));
        }
        int[] ans = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            int index = bSearch(keys, queries[i]);
            ans[i] = index == -1 ? 0 : map.get(keys.get(index));
        }
        return ans;
    }
    
    public int bSearch(List<Integer> keys, int target) {
        int low = 0;
        int high = keys.size() - 1;
        while (low < high) {
            int mid = (int) Math.ceil((low + high) / 2.0);
            if (keys.get(mid) > target) {
                high = mid - 1;
            } else {
                low = mid;
            }
        }
        return keys.get(low) <= target ? low : -1;
    }

}