class Solution {
    List<Integer> prime;
    public boolean primeSubOperation(int[] nums) {
        prime = generatePrime();
        int idx = getIndex(nums[0], 0);
        nums[0] -= idx == -1 ? 0 : prime.get(idx);
        for (int i = 1; i < nums.length; i++) {
            int index = getIndex(nums[i], nums[i - 1]);
            nums[i] -= index == -1 ? 0 : prime.get(index);
            if (nums[i] <= nums[i - 1]) {
                return false;
            }
        }
        return true;
    }

    public int getIndex(int target, int minimum) {
        int low = 0;
        int high = prime.size() - 1;
        while (low < high) {
            int mid = (int) Math.ceil((low + high) / 2.0);
            if (target - prime.get(mid) > minimum) {
                low = mid;
            } else {
                high = mid - 1;
            }
        }
        return target - prime.get(low) > minimum && target > prime.get(low) ? low : -1;
    }


    public List<Integer> generatePrime() {
        boolean[] arr = new boolean[1001];
        int curr = 2;
        while (curr < Math.sqrt(1001)) {
            for (int i = curr * 2; i < arr.length; i += curr) {
                arr[i] = true;
            }
            for (int i = curr + 1; i < arr.length; i++) {
                if (!arr[i]) {
                    curr = i;
                    break;
                }
            }
        }
        List<Integer> prime = new ArrayList<>();
        for (int i = 2; i < arr.length; i++) {
            if (!arr[i]) {
                prime.add(i);
            }
        }
        return prime;
    }
}