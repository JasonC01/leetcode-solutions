class Solution {
    long[][] memo;
    public long minimumTotalDistance(List<Integer> robot, int[][] factory) {
        robot.sort(Comparator.comparing(x -> x));
        Arrays.sort(factory, Comparator.comparing(x -> x[0]));
        List<Integer> facFlattened = new ArrayList<>();
        for (int[] i : factory) {
            for (int j = 0; j < i[1]; j++) {
                facFlattened.add(i[0]);
            }
        }
        memo = new long[robot.size() + 1][facFlattened.size() + 1];
        for (long[] i : memo) {
            Arrays.fill(i, -1);
        }
        return helper(robot, facFlattened, 0, 0, 0);
    }

    public Long helper(List<Integer> robot, List<Integer> factory, int robotIndex, int factoryIndex, long curr) {
        if (robotIndex > robot.size() - 1) {
            return curr;
        }
        if (factoryIndex > factory.size() - 1) {
            return -1L;
        }
        if (memo[robotIndex][factoryIndex] != -1) {
            return memo[robotIndex][factoryIndex] + curr;
        }
        int nextIndex = factoryIndex + 1;
        while (nextIndex < factory.size() && factory.get(nextIndex).equals(factory.get(factoryIndex))) {
            nextIndex++;
        }
        long first = helper(robot, factory, robotIndex + 1, factoryIndex + 1, curr + Math.abs((long) factory.get(factoryIndex) - (long) robot.get(robotIndex)));
        long second = helper(robot, factory, robotIndex, nextIndex, curr);
        long res;
        if (first == -1) {
            res = second;
        } else if (second == -1) {
            res = first;
        } else {
            res = Math.min(first, second);
        }
        memo[robotIndex][factoryIndex] = res == -1 ? -1 : res - curr;
        return res;
    }
}