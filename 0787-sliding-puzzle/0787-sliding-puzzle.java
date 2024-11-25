class Solution {
    public int slidingPuzzle(int[][] board) {
        HashSet<String> visited = new HashSet<>();
        String target = "123450";
        Queue<String> q = new ArrayDeque<>();
        q.add(convertToString(board));
        int level = 0;
        int levelSize = 1;
        while (!q.isEmpty()) {
            String curr = q.poll();
            levelSize--;
            if (curr.equals(target)) {
                return level;
            }
            if (visited.contains(curr)) {
                if (levelSize == 0) {
                    level++;
                    levelSize = q.size();
                }
                continue;
            }
            visited.add(curr);
            int currIndex = curr.indexOf('0');
            int row = Math.floorDiv(currIndex, 3);
            int col = currIndex % 3;
            int[][] nextMoves = new int[][]{new int[]{row + 1, col}, new int[]{row - 1, col}, new int[]{row, col + 1}, new int[]{row, col - 1}};
            for (int[] move : nextMoves) {
                if (move[0] < 0 || move[1] < 0 || move[0] > 1 || move[1] > 2) {
                    continue;
                }
                int swapIndex = move[0] * 3 + move[1];
                StringBuilder sb = new StringBuilder(curr);
                sb.setCharAt(currIndex, curr.charAt(swapIndex));
                sb.setCharAt(swapIndex, '0');
                q.add(sb.toString());
            }
            if (levelSize == 0) {
                level++;
                levelSize = q.size();
            }
        }
        return -1;
    }

    public String convertToString(int[][] board) {
        StringBuilder sb = new StringBuilder();
        for (int[] i : board) {
            for (int j : i) {
                sb.append(j);
            }
        }
        return sb.toString();
    }
}