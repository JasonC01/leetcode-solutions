class Solution {
    public int[] closestPrimes(int left, int right) {
        int[] arr = new int[right + 1];
        boolean[] isPrime = new boolean[right + 1];
        Arrays.fill(isPrime, true);
        for (int i = 2; i <= Math.sqrt(right); i++) {
            if (isPrime[i]) {
                for (int j = 2 * i; j <= right; j += i) {
                    isPrime[j] = false;
                }
            }
        }
        List<Integer> primes = new ArrayList<>();
        for (int i = 2; i < arr.length; i++) {
            if (isPrime[i] && i >= left) {
                primes.add(i);
            }
        }
        int minIndex = -1;
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < primes.size() - 1; i++) {
            int diff = primes.get(i + 1) - primes.get(i);
            if (diff < min) {
                minIndex = i;
                min = diff;
            }
        }
        return min == Integer.MAX_VALUE ? new int[]{-1, -1} : new int[]{primes.get(minIndex), primes.get(minIndex + 1)};
    }
}