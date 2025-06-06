class Solution {

        int[] prefSum;
        Random r = new Random();
        public Solution(int[] w) {
            r.setSeed(0);
            prefSum = new int[w.length];
            prefSum[0] = w[0];
            for (int i = 1; i < w.length; i++) {
                prefSum[i] = prefSum[i - 1] + w[i];
            }
        }

        public int pickIndex() {
            int randomIndex = r.nextInt(prefSum[prefSum.length - 1] + 1);
            int low = 0;
            int high = prefSum.length - 1;
            while (low < high) {
                int mid = Math.floorDiv(low + high, 2);
                if (prefSum[mid] <= randomIndex) {
                    low = mid + 1;
                } else {
                    high = mid;
                }
            }
            return low;
        }
    }

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(w);
 * int param_1 = obj.pickIndex();
 */