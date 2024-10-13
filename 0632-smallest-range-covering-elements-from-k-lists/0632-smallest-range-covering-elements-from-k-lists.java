class Solution {
     public int[] smallestRange(List<List<Integer>> nums) {
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparing(x -> x[0]));
        for (int i = 0; i < nums.size(); i++) {
            for (int j : nums.get(i)) {
                pq.add(new int[]{j, i});
            }
        }
        HashMap<Integer, int[]> map = new HashMap<>();
        PriorityQueue<int[]> largest = new PriorityQueue<>((a, b) -> Integer.compare(b[0], a[0]));
        PriorityQueue<int[]> smallest = new PriorityQueue<>(Comparator.comparing(x -> x[0]));
        int[] ans = new int[2];
        int size = Integer.MAX_VALUE;
        while (!pq.isEmpty()) {
            int[] curr = pq.poll();
            if (map.containsKey(curr[1])) {
                largest.remove(map.get(curr[1]));
                smallest.remove(map.get(curr[1]));
            }
            map.put(curr[1], curr);
            largest.add(curr);
            smallest.add(curr);
            if (map.keySet().size() == nums.size()) {
                if (largest.peek()[0] - smallest.peek()[0] + 1 < size) {
                    ans[0] = smallest.peek()[0];
                    ans[1] = largest.peek()[0];
                    size = ans[1] - ans[0] + 1;
                }
            }
        }
        return ans;
    }
}