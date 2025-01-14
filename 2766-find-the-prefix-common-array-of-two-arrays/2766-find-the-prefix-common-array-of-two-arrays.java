class Solution {
    public int[] findThePrefixCommonArray(int[] A, int[] B) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int[] ans = new int[A.length];
        for (int i = 0; i < B.length; i++) {
            map.put(B[i], i);
        }
        for (int i = 0; i < A.length; i++) {
            ans[Math.max(i, map.get(A[i]))]++;
        }
        int[] res = new int[A.length];
        res[0] = ans[0];
        for (int i = 1; i < res.length; i++) {
            res[i] = res[i - 1] + ans[i];
        }
        return res;
    }
}