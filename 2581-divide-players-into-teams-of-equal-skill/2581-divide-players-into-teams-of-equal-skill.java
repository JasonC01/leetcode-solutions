class Solution {
    public long dividePlayers(int[] skill) {
        long total = 0;
        for (int i : skill) {
            total += i;
        }
        int teams = skill.length / 2;
        if (total % teams != 0) {
            return -1;
        }
        long required = total / teams;

        HashMap<Long, Integer> map = new HashMap<>();
        for (long i : skill) {
            map.merge(i, 1, (a, b) -> a + 1);
        }
        long ans = 0;
        HashSet<Long> used = new HashSet<>();
        for (long i : map.keySet()) {
            if (used.contains(i)) {
                continue;
            }
            long counterpart = required - i;
            used.add(i);
            used.add(counterpart);
            if (counterpart == i) {
                if (map.get(i) % 2 != 0) {
                    return -1;
                }
                ans += (long) (Math.pow(i, 2) * (map.get(i) / 2));
            } else {
                if (!map.containsKey(counterpart) || !map.get(i).equals(map.get(counterpart))) {
                    return -1;
                } else {
                    ans += i * counterpart * map.get(i);
                }
            }
        }
        return ans;
    }
}