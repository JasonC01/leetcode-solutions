class Solution {
    public class FwTree {
        int[] tree;
        int n;

        public FwTree(int n) {
            tree = new int[n + 1];
            this.n = n;
        }

        public void update(int x, int delta)
        {
            x++;
            for(; x <= n; x += x&-x)
                tree[x] += delta;
        }

        int query(int x)
        {
            x++;
            int sum = 0;
            for(; x > 0; x -= x&-x)
                sum += tree[x];
            return sum;
        }
    }

    public long goodTriplets(int[] nums1, int[] nums2) {
        int n = nums1.length;
        HashMap<Integer, Integer> posMap = new HashMap<>();
        int[] mappedArr = new int[n]; // position of nums1[i] at nums2
        for (int i = 0; i < n; i++) {
            posMap.put(nums2[i], i);
        }
        for (int i = 0; i < n; i++) {
            mappedArr[i] = posMap.get(nums1[i]);
        }
        FwTree tree = new FwTree(n);
        long ans = 0;
        for (int i = 0; i < n; i++) {
            int pos = mappedArr[i];
            int left = tree.query(pos);
            tree.update(pos, 1);
            int right = (n - 1 - pos) - (i - left);
            ans += (long) left * right;
        }
        return ans;
    }
}
