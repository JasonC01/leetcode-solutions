class Solution {
    int mod = (int) (1e9 + 7);
    public int maximumScore(List<Integer> nums, int k) {
        long ans = 1;
         int maxElement = Collections.max(nums);
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> Integer.compare(nums.get(b), nums.get(a)));
        for (int i = 0; i < nums.size(); i++) {
            pq.add(i);
        }
        int[] left = new int[nums.size()];
        int[] right = new int[nums.size()];
    
        int[] scores = new int[nums.size()];
        List<Integer> primes = getPrimes(maxElement);

        // Calculate the prime score for each number in nums
        for (int index = 0; index < nums.size(); index++) {
            int num = nums.get(index);

            // Iterate over the generated primes to count unique prime factors
            for (int prime : primes) {
                if (prime * prime > num) break; // Stop early if prime^2 exceeds num
                if (num % prime != 0) continue; // Skip if the prime is not a factor

                scores[index]++; // Increment prime score for the factor
                while (num % prime == 0) num /= prime; // Remove all occurrences of this factor
            }

            // If num is still greater than 1, it is a prime number itself
            if (num > 1) scores[index]++;
        }
        Stack<int[]> stack = new Stack<>();
        for (int i = nums.size() - 1; i >= 0; i--) {
            while (!stack.isEmpty() && stack.peek()[1] <= scores[i]) {
                int[] curr = stack.pop();
                left[curr[0]] = i;
            }
            stack.push(new int[]{i, scores[i]});
        }
        while (!stack.isEmpty()) {
            left[stack.pop()[0]] = -1;
        }
        for (int i = 0; i < nums.size(); i++) {
            while (!stack.isEmpty() && stack.peek()[1] < scores[i]) {
                int[] curr = stack.pop();
                right[curr[0]] = i;
            }
            stack.push(new int[]{i, scores[i]});
        }
        while (!stack.isEmpty()) {
            right[stack.pop()[0]] = nums.size();
        }
        while (!pq.isEmpty() && k > 0) {
            System.out.println(ans);
            int curr = pq.poll();
            long l = (long) left[curr] ;
            long r =(long) right[curr]  ;
            long total = (curr - l) * (r - curr);
            ans = ((ans * exponentiation(nums.get(curr), Math.min(total, k))) % mod);
            k = (int) Math.max(0, k - total);
        }
        return (int) ans;
    }

    public long exponentiation(long base, long exp)
    {
        if (exp == 0)
            return 1;

        if (exp == 1)
            return base % mod;

        long t = exponentiation(base, exp / 2);
        t = (t * t) % mod;

        // if exponent is even value
        if (exp % 2 == 0)
            return t;

            // if exponent is odd value
        else
            return ((base % mod) * t) % mod;
    }

    private List<Integer> getPrimes(int limit) {
        boolean[] isPrime = new boolean[limit + 1];
        Arrays.fill(isPrime, true);
        List<Integer> primes = new ArrayList<>();

        for (int number = 2; number <= limit; number++) {
            if (!isPrime[number]) continue;

            primes.add(number);

            for (
                long multiple = (long) number * number;
                multiple <= limit;
                multiple += number
            ) {
                isPrime[(int) multiple] = false;
            }
        }

        return primes;
    }
}