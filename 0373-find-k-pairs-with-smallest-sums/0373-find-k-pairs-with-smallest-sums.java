class Solution {
    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        PriorityQueue<List<Integer>> pq = new PriorityQueue<>(Comparator.comparing(x -> nums1[x.get(0)] + nums2[x.get(1)]));
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> arr = new ArrayList<>();
        HashSet<List<Integer>> added = new HashSet<>();
        arr.add(0);
        arr.add(0);
        pq.add(arr);
        while (ans.size() < k && !pq.isEmpty()) {
            List<Integer> curr = pq.poll();
            if (added.contains(curr)) {
                continue;
            }
            int first = curr.get(0);
            int second = curr.get(1);
            List<Integer> partAns = new ArrayList<>();
            partAns.add(nums1[first]);
            partAns.add(nums2[second]);
            ans.add(partAns);
            added.add(curr);
            List<Integer> next1 = new ArrayList<>(curr);
            List<Integer> next2 = new ArrayList<>(curr);
            if (first + 1 < nums1.length) {
                next1.set(0, first + 1);
            }
            if (second + 1 < nums2.length) {
                next2.set(1, second + 1);
            }
            pq.add(next1);
            pq.add(next2);
        }
        return ans;
    }
}