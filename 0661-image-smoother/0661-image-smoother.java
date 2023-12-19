class Solution {
    public int[][] imageSmoother(int[][] img) {
        int[][] ans = new int[img.length][img[0].length];
        int[][] count = new int[img.length][img[0].length];
        for (int i = 0; i < img.length; i++) {
            for (int j = 0; j < img[0].length; j++) {
                for (int xDiff = -1; xDiff <= 1; xDiff++) {
                    for (int yDiff = -1; yDiff <= 1; yDiff++) {
                        if (!isOutOfBounds(img[0].length, img.length, j - xDiff, i - yDiff)) {
                            ans[i - yDiff][j - xDiff] += img[i][j];
                            count[i - yDiff][j - xDiff]++;
                        }
                    }
                }
            }
        }
        for (int i = 0; i < img.length; i++) {
            for (int j = 0; j < img[0].length; j++) {
                ans[i][j] = Math.floorDiv(ans[i][j], count[i][j]);
            }
        }
        return ans;
    }

    public boolean isOutOfBounds(int xMax, int yMax, int x, int y) {
        return x < 0 || y < 0 || x >= xMax || y >= yMax;
    }
}