class Solution {
    public long countGoodIntegers(int n, int k) {
        int limit = (int) Math.ceil(n / 2.0);
        HashSet<String> visited = new HashSet<>();
        long res = helper(new StringBuilder(), visited, limit, k, n);
        return res;
    }

    public long helper(StringBuilder sb, HashSet<String> visited, int limit, int k, int n) {
        if (sb.length() == limit) {
            
            if (checkCondition(sb, k, n)) {
                String hashed = hash(sb, n);
                if (visited.contains(hashed)) {
                    return 0;
                }
                visited.add(hashed);
                return getCount(hashed, n);
            }
            return 0;
        }
        long res = 0;
        for (int i = 0; i < 10; i++) {
            sb.append(i);
            res += helper(sb, visited, limit, k, n);
            sb.deleteCharAt(sb.length() - 1);
        }
        return res;
    }

    public boolean checkCondition(StringBuilder sb, int x, int n) {
        if (sb.charAt(0) == '0'){
            return false;
        }
        String reversed = new StringBuilder(sb).reverse().toString();
        String res = sb + (n % 2 == 1 ? reversed.substring(1) : reversed);
        return Long.parseLong(res) % x == 0;
    }

    public String hash(StringBuilder sb, int n) {
        int[] counter = new int[10];
        for (int i = 0; i < sb.length(); i++) {
            if (n % 2 == 1 && i == sb.length() - 1) counter[Integer.parseInt(sb.substring(i, i + 1))]++;
            else counter[Integer.parseInt(sb.substring(i, i + 1))] += 2;
        }
        StringBuilder res = new StringBuilder();
        for (int i : counter) {
            res.append(i);
            res.append(',');
        }
        res.deleteCharAt(res.length() - 1);
        return res.toString();
    }

    public long getCount(String counter, int n) {
        String[] c = counter.split(",");
        long res = factorial(n);
        for (String s : c) {
            res /= factorial(Integer.parseInt(s));
        }
        int zeroCount = Integer.parseInt(c[0]);
        if (zeroCount >= 1) {
            long toBeDeducted = factorial(n - 1);
            for (int i = 0; i < c.length; i++) {
                int count = Integer.parseInt(c[i]);
                if (i == 0) {
                    toBeDeducted /= factorial(count - 1);
                } else {
                    toBeDeducted /= factorial(count);
                }
            }
            res -= toBeDeducted;
        }
        return res;
    }

    public int factorial(int x) {
        int perm = 1;
        for (int i = 1; i <= x; i++) {
            perm *= i;
        }
        return perm;
    }
}
