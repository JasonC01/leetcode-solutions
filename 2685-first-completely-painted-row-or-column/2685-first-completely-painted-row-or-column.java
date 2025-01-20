class Solution {
    public int firstCompleteIndex(int[] arr, int[][] mat) {
        HashMap<Integer, int[]> positionMap = new HashMap<>();
        HashMap<Integer, Integer> rowCounter = new HashMap<>();
        HashMap<Integer, Integer> colCounter = new HashMap<>();
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[0].length; j++) {
                positionMap.put(mat[i][j], new int[]{i, j});
            }
        }
        for (int index = 0; index < arr.length; index++) {
            int i = arr[index];
            int[] position = positionMap.get(i);
            int x = position[1];
            int y = position[0];
            rowCounter.merge(y, 1, (a, b) -> a + 1);
            colCounter.merge(x, 1, (a, b) -> a + 1);
            if (rowCounter.get(y) == mat[0].length || colCounter.get(x) == mat.length) {
                return index;
            }
        }
        return 0;
    }
}