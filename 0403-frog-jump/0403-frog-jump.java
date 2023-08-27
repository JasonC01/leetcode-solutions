class Solution {
    HashMap<Integer, HashMap<Integer, Integer>> memo = new HashMap<>();

    public boolean canCross(int[] stones) {
        HashSet<Integer> s = new HashSet<>();
        for (int i : stones) {
            s.add(i);
        }
        if (stones[1] - stones[0] > 1) {
            return false;
        }
        return helper(s, stones[1], 1, stones[stones.length - 1]);
    }

    public boolean helper(HashSet<Integer> stones, int currPosition, int jump, int destination) {
        if (currPosition == destination) {
            return true;
        }
        if (currPosition > destination) {
            return false;
        }
        if (!stones.contains(currPosition)) {
            return false;
        }
        if (jump <= 0) {
            return false;
        }
        if (memo.containsKey(currPosition) && memo.get(currPosition).containsKey(jump)) {
            return memo.get(currPosition).get(jump) == 1;
        }
        boolean res = helper(stones, currPosition + jump - 1, jump - 1, destination);
        res |=  helper(stones, currPosition + jump + 1, jump + 1, destination);
        res |= helper(stones, currPosition + jump, jump, destination);
        if (!memo.containsKey(currPosition)) {
            memo.put(currPosition, new HashMap<>());
        }
        memo.get(currPosition).put(jump, res ? 1 : 0);
        return res;
    }
}