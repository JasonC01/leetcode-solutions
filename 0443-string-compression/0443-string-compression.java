class Solution {
  public int compress(char[] chars) {
        int ans = 1;
        char prev = chars[0];
        int prevCount = 0;
        int index = 1;
        for (char c : chars) {
            if (c != prev) {
                ans += prevCount == 1 ? 1 : 1 + String.valueOf(prevCount).length();
                if (prevCount > 1) {
                    String count = String.valueOf(prevCount);
                    for (int i = 0; i < count.length(); i++) {
                        chars[index++] = count.charAt(i);
                    }
                }
                prev = c;
                chars[index++] = c;
                prevCount = 1;
            } else {
                prevCount++;
            }
        }
        if (prevCount > 1) {
            String count = String.valueOf(prevCount);
            for (int i = 0; i < count.length(); i++) {
                System.out.println(count.charAt(i));
                chars[index++] = count.charAt(i);
            }
        }
        chars = Arrays.copyOf(chars, index);
        System.out.println(Arrays.toString(chars));

        return prevCount > 1 ? ans + String.valueOf(prevCount).length() : ans;
    }
}