class Solution {
    public boolean checkIfExist(int[] arr) {
        HashSet<Integer> set = new HashSet<>();
        int zeroCount = 0;
        for (int i : arr) {
            set.add(i);
            if (i == 0) zeroCount++;
        }
        for (int i : arr) {
            if (i == 0 && zeroCount < 2) {
                continue;
            }
            if (set.contains(i * 2)) {
                return true;
            }
        }
        return false;
    }
}