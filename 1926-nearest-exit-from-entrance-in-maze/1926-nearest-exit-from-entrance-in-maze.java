class Solution {
    public int nearestExit(char[][] maze, int[] entrance) {
        boolean[][] visited = new boolean[maze.length][maze[0].length];
        Queue<int[]> q = new ArrayDeque<>();
        q.add(entrance);
        int step = 0;
        int levelSize = 1;
        while (!q.isEmpty()) {
            int[] currPos = q.poll();
            
            levelSize--;
            int x = currPos[1];
            int y = currPos[0];
            if (y > maze.length - 1 || y < 0 || x > maze[0].length - 1 || x < 0 || maze[y][x] == '+' || visited[y][x]) {
            } else {                
                if ((y == maze.length - 1 || y == 0 || x == maze[0].length - 1 || x == 0) && (x != entrance[1] || y != entrance[0])) {
                    return step;
                } 
                visited[y][x] = true;
                q.add(new int[]{y, x + 1});
                q.add(new int[]{y, x - 1});
                q.add(new int[]{y + 1, x});
                q.add(new int[]{y - 1, x});
                
            }
            if (levelSize == 0) {
                levelSize = q.size();
                step++;
            }
        }
        return -1;
    }
}