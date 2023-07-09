class Solution {
    public int largestVariance(String s) {
        int ans = 0;
        for (int i = 0; i < 26; i++) {
            for (int j = 0; j < 26; j++) {
                int[] arr = new int[s.length()];
                for (int x = 0; x < s.length(); x++) {
                    if (s.charAt(x) - 97 == i) {
                        arr[x] = 1;
                    } else if (s.charAt(x) - 97 == j) {
                        arr[x] = -1;
                    }
                }
                boolean contains = false;
                for (int x : arr) {
                    if (x == -1) {
                        contains = true;
                        break;
                    }
                }
                if (!contains) {
                    continue;
                }
                int sum = arr[0];
                int max = 0;
                boolean added = false;
                for (int k = 1; k < arr.length; k++) {
                    if (arr[k] == -1) {
                        sum -= 1;
                        added = true;
                    } else {
                        if (arr[k] > sum + arr[k]) {
                            added = false;
                            sum = arr[k];
                        } else {
                            sum += arr[k];
                        }
                    }
                    if (added) {
                        max = Math.max(max, sum);
                    }
                }
                max = Math.max(max, sum - 1);
                ans = Math.max(ans, max);
            }
        }
        return ans;
    }
}