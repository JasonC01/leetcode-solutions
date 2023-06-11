class SnapshotArray {
        List<List<int[]>> arr = new ArrayList<>();
        int snap = 0;
        int length;

        public int binarySearch(List<int[]> a, int snapId) {
            int high = a.size() - 1;
            int low = 0;
            while (low < high) {
                int mid = (int) Math.ceil((double) (low + high) / 2);
                if (a.get(mid)[1] > snapId) {
                    high = mid - 1;
                } else {
                    low = mid;
                }
            }
            return a.get(low)[0];
        }
        public SnapshotArray(int length) {
            this.length = length;
            for (int i = 0; i < length; i++) {
                List<int[]> a = new ArrayList<>();
                a.add(new int[]{0, 0});
                arr.add(a);
            }
        }

        public void set(int index, int val) {
            arr.get(index).add(new int[]{val, snap});
        }

        public int snap() {
            return snap++;
        }

        public int get(int index, int snap_id) {
            List<int[]> curr = arr.get(index);
            return binarySearch(curr, snap_id);
        }
    }