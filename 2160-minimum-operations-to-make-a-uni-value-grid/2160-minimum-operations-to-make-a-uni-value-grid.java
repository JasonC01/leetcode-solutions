class Solution {
    public int minOperations(int[][] grid, int x) {
        int[] arr = new int[grid[0].length * grid.length];
        int index = 0;
        for (int[] row : grid) {
            for (int i : row) {
                arr[index++] = i;
            }
        }
        Arrays.sort(arr);
        for (int i = 1; i < arr.length; i++) {
            if ((arr[i] - arr[0]) % x != 0) {
                return -1;
            }
        }
        List<Integer> candidates = new ArrayList<>();
        if (arr.length % 2 == 0) {
            candidates.add(arr[arr.length / 2]);
            candidates.add(arr[(arr.length / 2) - 1]);
        } else {
            candidates.add(arr[Math.floorDiv(arr.length, 2)]);
        }
        int min = Integer.MAX_VALUE;
        for (int i : candidates) {
            System.out.println(i);
            int res = 0;
            for (int j : arr) {
                res += (Math.abs(j - i) / x);
            }
            min = Math.min(min, res);
        }
        return min;
    }
}