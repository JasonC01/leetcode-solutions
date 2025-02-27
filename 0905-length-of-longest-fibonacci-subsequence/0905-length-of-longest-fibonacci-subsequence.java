class Solution {
    public int lenLongestFibSubseq(int[] arr) {
        HashMap<String, Integer> map = new HashMap<>();
        HashSet<Integer> set = new HashSet<>();
        for (int i : arr) {
            set.add(i);
        }
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                int sum = arr[i] + arr[j];
                if (set.contains(sum)) {
                    String key = arr[i] + "|" + arr[j];
                    String newKey = arr[j] + "|" + sum;
                    if (map.containsKey(key)) {
                        map.put(newKey, map.get(key) + 1);
                    } else {
                        map.put(newKey, 3);
                    }
                }
            }
        }
        int ans = 0;
        for (int i : map.values()) {
            ans = Math.max(ans, i);
        }
        return ans;
    }
}