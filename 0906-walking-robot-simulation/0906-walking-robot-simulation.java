class Solution {
    public int robotSim(int[] commands, int[][] obstacles) {
        int currY = 0;
        int currX = 0;
        int[][] directions = new int[][]{new int[]{0, 1}, new int[]{1, 0}, new int[]{0, -1}, new int[]{-1, 0}};
        int currDirIndex = 0;
        HashMap<Integer, List<Integer>> obs = new HashMap<>();
        int ans = 0;
        for(int[] o : obstacles) {
            if (!obs.containsKey(o[0])) {
                obs.put(o[0], new ArrayList<>());
            }
            obs.get(o[0]).add(o[1]);
        }
        for (int command : commands) {
            int[] currDir = directions[currDirIndex];
            if (command == -2) {
                currDirIndex = currDirIndex - 1 < 0 ? 3 : currDirIndex - 1;
            } else if (command == -1) {
                currDirIndex = (currDirIndex + 1) % 4;
            } else {
                for (int i = 0; i < command; i++) {
                    int nextY = currY + currDir[1];
                    int nextX = currX + currDir[0];
                    if (obs.containsKey(nextX) && obs.get(nextX).contains(nextY)) {
                        break;
                    } else {
                        currY = nextY;
                        currX = nextX;
                        ans = Math.max(ans, (int) (Math.pow(currY, 2) + Math.pow(currX, 2)));
                    }
                }
            }
        }
        return ans;
    }
}