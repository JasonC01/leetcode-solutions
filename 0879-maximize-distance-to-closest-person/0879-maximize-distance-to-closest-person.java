class Solution {
    public int maxDistToClosest(int[] seats) {
        List<Integer> arr = new ArrayList<>();
        for (int i = 0; i < seats.length; i++) {
            if (seats[i] == 1) {
                arr.add(i);
            }
        }
        int ans = Integer.MIN_VALUE;
        for (int i = 0; i < seats.length; i++) {
            if (seats[i] == 0) {
                int first = binarySearch(arr, i);
                int second = binarySearch2(arr, i);
                if (first == -1) {
                    ans = Math.max(ans, second - i);
                } else if (second == -1) {
                    ans = Math.max(ans, i - first);
                } else {
                    ans = Math.max(ans, Math.min(i - binarySearch(arr, i), binarySearch2(arr, i) - i));
                }

            }
        }
        return ans;
    }

    public int binarySearch(List<Integer> seats, int currIndex) {
        int low = 0;
        int high = seats.size() - 1;

        while (low < high) {
            int mid = (int) Math.ceil((double) (low + high) / 2);
            if (seats.get(mid) > currIndex) {
                high = mid - 1;
            } else {
                low = mid;
            }
        }
        return seats.get(low) >= currIndex ? -1 : seats.get(low);
    }

    public int binarySearch2(List<Integer> seats, int currIndex) {
        int low = 0;
        int high = seats.size() - 1;
        while (low < high) {
            int mid = (int) Math.floor((double) (low + high) / 2);
            if (seats.get(mid) > currIndex) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }
        return seats.get(low) <= currIndex ? -1 : seats.get(low);
    }
}