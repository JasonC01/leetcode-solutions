class Solution {
    public boolean canMeasureWater(int x, int y, int target) {
        boolean[][] visited = new boolean[x + 1][y + 1];
        return helper(visited, x, y, 0, 0, target);
    }

    public boolean helper(boolean[][] visited, int xLimit, int yLimit, int x, int y, int target) {
        if (x < 0 || y < 0 || x > xLimit || y > yLimit || visited[x][y]) return false;
        if (x + y == target) return true;
        visited[x][y] = true;
        return helper(visited, xLimit, yLimit, xLimit, y, target) ||
                helper(visited, xLimit, yLimit, 0, y, target) ||
                helper(visited, xLimit, yLimit, x, yLimit, target) ||
                helper(visited, xLimit, yLimit, x, 0, target) ||
                helper(visited, xLimit, yLimit, Math.max(0, x - (yLimit - y)), Math.min(yLimit, y + x), target) ||
                helper(visited, xLimit, yLimit, Math.min(xLimit, x + y), Math.max(0, y - (xLimit - x)), target);
    }
}