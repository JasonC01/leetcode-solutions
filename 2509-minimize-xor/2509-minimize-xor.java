class Solution {
    public int minimizeXor(int num1, int num2) {
        int firstSetBits = getSetBits(num1);
        int secondSetBits = getSetBits(num2);
        // System.out.println(firstSetBits);
        // System.out.println(secondSetBits);
        if (firstSetBits == secondSetBits) {
            return num1;
        } else if (firstSetBits > secondSetBits) {
            int rem = firstSetBits - secondSetBits;
            int multiplier = 1;
            int res = 0;
            int curr = num1;
            while (curr > 0) {
                if (curr % 2 == 1 && rem > 0) {
                    rem--;
                    // res += multiplier;
                } else {
                    res += multiplier * (curr % 2);
                }
                multiplier *= 2;
                curr = curr >> 1;
            }
            return res;
        } else {
            int diff = secondSetBits - firstSetBits;
            int multiplier = 1;
            int res = 0;
            int curr = num1;
            while (curr > 0) {
                if (curr % 2 == 0 && diff > 0) {
                    res += multiplier;
                    diff--;
                } else {
                    res += (curr % 2) * multiplier;
                }
                multiplier *= 2;
                curr = curr >> 1;
            }
            while (diff > 0) {
                res += multiplier;
                multiplier *= 2;
                diff--;
            }
            return res;
        }
    }

    public int getSetBits(int i) {
        int ans = 0;
        while (i > 0) {
            ans += (i % 2);
            i = i >> 1;
        }
        return ans;
    }

}

// 11001
// 1001000