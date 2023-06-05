class Solution {
    public double gradient(int x1, int y1, int x2, int y2) {
        return (double) (y2 - y1) / (x2 - x1);
    }
    public boolean checkStraightLine(int[][] coordinates) {
        int sameX = coordinates[0][0];
        int sameY = coordinates[0][1];
        boolean ansX = true;
        boolean ansY = true;
        boolean upward = true;
        for (int[] coord : coordinates) {
            if (coord[0] != sameX) {
                ansX = false;
            }
            if (coord[1] != sameY) {
                ansY = false;
            }
        }
        if (ansX || ansY) {
            return true;
        }
        Arrays.sort(coordinates, Comparator.comparingInt(a -> a[0]));
        int prevX = coordinates[1][0];
        int prevY = coordinates[1][1];
        double gradient = (double) (prevY - coordinates[0][1]) / (prevX - coordinates[0][0]);
        for (int i = 2; i < coordinates.length; i++) {
            int x = coordinates[i][0];
            int y = coordinates[i][1];
            if (gradient(prevX, prevY, x, y) != gradient) {
                return false;
            }
            prevX = x;
            prevY = y;
        }
        return true;
    }
    
}