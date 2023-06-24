class Solution {
   public int tallestBillboard(int[] rods) {
        HashMap<Integer, Integer> memo = new HashMap<>();
        memo.put(0, 0);
        for (int r : rods) {
            Set<Integer> keyset = new HashSet<>(memo.keySet());
            HashMap<Integer, Integer> newMemo = new HashMap<>(memo);
            for (int diff : keyset) {
                int taller = memo.get(diff);
                int shorter = taller - diff;
                newMemo.put(diff + r, Math.max(taller + r, newMemo.getOrDefault(diff + r, 0)));

                int newDiff = Math.abs(shorter + r - taller);
                newMemo.put(newDiff, Math.max(Math.max(taller, shorter + r), newMemo.getOrDefault(newDiff, 0)));
            }
            memo = newMemo;
        }
        return memo.get(0);
    }
}