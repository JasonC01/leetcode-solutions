class Solution {
    public int removeStones(int[][] stones) {
        HashMap<Integer, List<int[]>> rowAdj = new HashMap<>();
        HashMap<Integer, List<int[]>> colAdj = new HashMap<>();
        for (int[] stone : stones) {
            int row = stone[0];
            int col = stone[1];
            if (!rowAdj.containsKey(row)) {
                rowAdj.put(row, new ArrayList<>());
            }
            if (!colAdj.containsKey(col)) {
                colAdj.put(col, new ArrayList<>());
            }
            rowAdj.get(row).add(stone);
            colAdj.get(col).add(stone);
        }
        HashSet<Integer> rowVisited = new HashSet<>();
        HashSet<Integer> colVisited = new HashSet<>();
        int numberOfIslands = 0;
        for (int i : rowAdj.keySet()) {
            if (!rowVisited.contains(i)) {
                rowVisited.add(i);
                numberOfIslands++;
                Queue<int[]> q = new ArrayDeque<>(rowAdj.get(i));
                while (!q.isEmpty()) {
                    int[] currStone = q.poll();
                    int row = currStone[0];
                    int col = currStone[1];
                    if (!rowVisited.contains(row)) {
                        rowVisited.add(row);
                        q.addAll(rowAdj.get(row));
                    }
                    if (!colVisited.contains(col)) {
                        colVisited.add(col);
                        q.addAll(colAdj.get(col));
                    }
                }
            }
        }
        return stones.length - numberOfIslands;
    }
}