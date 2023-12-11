class Solution {
    public int findSpecialInteger(int[] arr) {
        int threshold = arr.length / 4;
        int curr = -1;
        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == curr) {
                count++;
            } else {
                if (count > threshold) {
                    return curr;
                } else {
                    curr = arr[i];
                    count = 1;
                }
            }
        }
        return count > threshold ? curr : -1;
    }
}