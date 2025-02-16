class Solution {
    public int[] constructDistancedSequence(int n) {
        List<Integer> numbers = new ArrayList<>();
        for (int i = n; i >= 1; i--) {
            numbers.add(i);
        }
        int[] arr = new int[(n - 1) * 2 + 1];
        Arrays.fill(arr, -1);
        return helper(arr, 0, numbers);
    }

    public int[] helper(int[] arr, int index, List<Integer> remaining) {
        if (index > arr.length - 1) {
            for (int i : arr) {
                if (i == -1) {
                    return new int[arr.length];
                }
            }
            return Arrays.copyOf(arr, arr.length);
        }
        if (arr[index] != -1) {
            return helper(arr, index + 1, remaining);
        }
        for (int i : remaining) {
            int nextIndex = index + i;
            if (i == 1 || (nextIndex < arr.length && arr[nextIndex] == -1)) {
                int[] newArr = Arrays.copyOf(arr, arr.length);
                newArr[index] = i;
                if (i != 1) {
                    newArr[nextIndex] = i;
                }
                List<Integer> newRemaining = new ArrayList<>(remaining);
                newRemaining.remove((Integer) i);
                int[] res = helper(newArr, index + 1, newRemaining);
                if (isValid(res)) return res;
            }
        }
        return arr;
    }
    
    public boolean isValid(int[] arr) {
        for (int i : arr) {
            if (i == -1) {
                return false;
            }
        }
        return true;
    }
}