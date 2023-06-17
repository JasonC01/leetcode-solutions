class Solution { 
    public int makeArrayIncreasing(int[] arr1, int[] arr2) {
        Arrays.sort(arr2);
        
        int answer = helper(arr1, arr2, -1, 0);
        
        return answer < 2_001 ? answer : -1;
    }
    
    Map<Pair<Integer, Integer>, Integer> memo = new HashMap<>();
    public int helper(int[] arr1, int[] arr2, int prev, int index) {
        Pair<Integer, Integer> pair = new Pair<>(index, prev);
        if (index > arr1.length - 1) {
            return 0;
        }
        if (memo.containsKey(pair)) {
            return memo.get(pair);
        }
        int ans = 2001;
        if (arr1[index] > prev) {
            ans = Math.min(ans, helper(arr1, arr2, arr1[index], index + 1));
        }
        int idx = binarySearch(arr2, prev);
        if (idx != -1) {
            ans = Math.min(ans, 1 + helper(arr1, arr2, arr2[idx], index + 1));
        }
        memo.put(pair, ans);
        return ans;
    }
    
    public int binarySearch(int[] arr, int target) {
        int high = arr.length - 1;
        int low = 0;
        while (low < high) {
            int mid = (int) Math.floor((double) (low + high) / 2);
            if (arr[mid] <= target) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }
        return arr[low] > target ? low : -1;
    }
}