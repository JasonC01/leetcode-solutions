class Solution {
    public int[] smallestSufficientTeam(String[] req_skills, List<List<String>> people) {

        HashMap<String, Integer> map = new HashMap<>();
        for (int i = 0; i < req_skills.length; i++) {
            map.put(req_skills[i], i);
        }
        List<Integer> ppl = new ArrayList<>();
        for (List<String> skills : people) {
            int s = 0;
            for (String sk : skills) {
                int mask = 1 << map.get(sk);
                s |= mask;
            }
            ppl.add(s);
        }
        long[] dp = new long[(int) (Math.pow(2, req_skills.length))];
        Arrays.fill(dp, (1 << ppl.size()) - 1);
        dp[0] = 0L;
        for (int i = 1; i < dp.length; i++) {
            for (int j = 0; j < ppl.size(); j++) {
                int contributeMask = i & ~ppl.get(j);
                if (contributeMask != i) {
                    long newMask = dp[contributeMask] | (1L << j);
                    if (Long.bitCount(newMask) < Long.bitCount(dp[i])) {
                        dp[i] = newMask;
                    }
                }
            }
        }
        System.out.println(Arrays.toString(dp));
        int[] ans = new int[Long.bitCount(dp[dp.length - 1])];
        long res = dp[dp.length - 1];
        int index = 0;
        for (int i = 0; i < ppl.size(); i++) {
            if ((res & (1L << i)) != 0) {
                ans[index++] = i;
            }
        }

        return ans;
    }
}