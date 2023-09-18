class Solution {
    public int[] kWeakestRows(int[][] mat, int k) {
        List<Integer> arr = new ArrayList<>();
        int[] ans = new int[k];
        for (int i = 0; i < mat.length; i++) {
            arr.add(i);
        }
        arr.sort(Comparator.comparing(x -> binarySearch(mat[x])));
        for (int i = 0; i < k; i++) {
            ans[i] = arr.get(i);
        }
        return ans;
    }
    
    public int binarySearch(int[] row) {
        int high = row.length - 1;
        int low = 0;
        while (low < high) {
            int mid = (int) Math.ceil((double) (low + high) / 2);
            if (row[mid] == 1) {
                low = mid;
            } else {
                high = mid - 1;
            }
        }
        return row[low] == 1 ? low : -1;
    }
}