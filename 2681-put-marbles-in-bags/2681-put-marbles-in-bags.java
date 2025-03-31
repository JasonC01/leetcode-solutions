class Solution {
    public long putMarbles(int[] weights, int k) {
        List<Integer> arr = new ArrayList<>();
        for (int i = 0; i < weights.length - 1; i++) {
            arr.add(weights[i] + weights[i + 1]);
        }
        arr.sort(Comparator.comparing(x -> x));
        long max = 0;
        long min = 0;
        for (int i = 0; i < k - 1; i++) {
            max += arr.get(arr.size() - 1 - i);
            min += arr.get(i);
        }
        return max -min;
    }
}