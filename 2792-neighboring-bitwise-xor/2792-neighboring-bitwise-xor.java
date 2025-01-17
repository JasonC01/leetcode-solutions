class Solution {
    public boolean doesValidArrayExist(int[] derived) {
        int[] firstOne = new int[derived.length];
        int[] firstZero = new int[derived.length];
        firstOne[0] = 1;
        return helper(derived, firstOne) || helper(derived, firstZero);
    }
    
    public boolean helper(int[] derived, int[] arr) {
        for (int i = 0; i < derived.length; i++) {
            if (derived[i] == 1) {
                if (i == derived.length - 1) {
                    return arr[i] != arr[0];
                }
                arr[i + 1] = arr[i] == 1 ? 0 : 1;
            } else {
                if (i == derived.length - 1) {
                    return arr[i] == arr[0];
                }
                arr[i + 1] = arr[i];
            }
        }
        return true;
    }
}