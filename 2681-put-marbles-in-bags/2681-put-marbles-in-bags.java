class Solution {
    public long putMarbles(int[] weights, int k) {
        List<Integer> arr = new ArrayList<>();
        for (int i = 0; i < weights.length - 1; i++) {
            arr.add(weights[i + 1] + weights[i]);
        }
        arr.sort(Comparator.comparing(x -> x));
        long ans = 0;
        for (int i = 0; i < k - 1; i++) {
            ans += arr.get(arr.size() - 1 - i) - arr.get(i);   
        }
        return ans;
    }
}