class Solution {
     public boolean canArrange(int[] arr, int k) {
        HashMap<Integer, HashMap<Integer, Integer>> map = new HashMap<>();
        List<int[]> val = new ArrayList<>();
        for (int i : arr) {
            int low = i < 0 ? -(k + i % k) : -(i % k);
            int high = i < 0 ? -(i % k) : k + low;
            if (!map.containsKey(low)) {
                map.put(low, new HashMap<>());
            }
            map.get(low).merge(high, 1, (a, b) -> a + 1);
            val.add(new int[]{low, high});
        }
        for (int i : map.keySet()) {
            if (i == 0) {
                if (map.get(i).get(k) % 2 != 0) {
                    for (int j : map.get(i).keySet()) {
                        if (!map.containsKey(-j) || !map.get(-j).containsKey(-i) || ((map.get(-j).get(-i) + map.get(i).get(j)) % 2) != 0) {
                            return false;
                        }
                    }
                }
            } else {
                for (int j : map.get(i).keySet()) {
                    if (j == 0) {
                        continue;
                    }
                    if (!map.containsKey(-j) || !map.get(-j).containsKey(-i) || !map.get(-j).get(-i).equals(map.get(i).get(j))) {
                        return false;
                    }
                }
            }
        }
        return true;
    }
}