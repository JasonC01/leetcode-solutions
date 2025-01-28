class NumArray {

        int[] tree;
        int[] arr;

        public NumArray(int[] nums) {
            tree = new int[4 * nums.length];
            arr = Arrays.copyOf(nums, nums.length);
            generateTree(1, 0, arr.length - 1);
        }

        public void generateTree(int treeIndex, int left, int right) {
            if (left == right) {
                tree[treeIndex] = arr[left];
            } else {
                int mid = Math.floorDiv(left + right, 2);
                generateTree(treeIndex * 2, left, mid);
                generateTree(treeIndex * 2 + 1, mid + 1, right);
                tree[treeIndex] = tree[treeIndex * 2] + tree[treeIndex * 2 + 1];
            }
        }

        public void update(int index, int val) {
            updateRange(index, val, 1, 0, arr.length - 1);
        }

        public void updateRange(int index, int val, int treeIndex, int left, int right) {
            if (left == right) {
                tree[treeIndex] = val;
            } else {
                int mid = Math.floorDiv(left + right, 2);
                if (index >= left && index <= mid) {
                    updateRange(index, val, treeIndex * 2, left, mid);
                }
                if (index >= mid + 1 && index <= right) {
                    updateRange(index, val, treeIndex * 2 + 1, mid + 1, right);
                }
                tree[treeIndex] = tree[treeIndex * 2] + tree[treeIndex * 2 + 1];
            }
        }

        public int sumRange(int left, int right) {
            return queryRange(left, right, 1, 0, arr.length - 1);
        }
        
        public int queryRange(int queryLeft, int queryRight, int treeIndex, int left, int right) {
            if (queryLeft > right || queryRight < left) {
                return 0;
            }
            if (left >= queryLeft && right <= queryRight) {
                return tree[treeIndex];
            }
            int mid = Math.floorDiv(left + right, 2);
            return queryRange(queryLeft, queryRight, treeIndex * 2, left, mid) + queryRange(queryLeft, queryRight, treeIndex * 2 + 1, mid + 1, right);
        }
    }

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * obj.update(index,val);
 * int param_2 = obj.sumRange(left,right);
 */