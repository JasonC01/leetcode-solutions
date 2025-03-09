class Solution {
    public int numberOfAlternatingGroups(int[] colors, int k) {
        List<Integer> lengths = new ArrayList<>();
        int prev = colors[0] == 1 ? 0 : 1;
        int length = 0;
        boolean isOff = false;
        for (int i = 0; i < colors.length; i++) {
            int curr = colors[i];
            if (curr != prev) {
                length++;
                prev = curr;
            } else {
                isOff = true;
                lengths.add(length);
                length = 1;
            }
        }
        isOff |= colors[0] == colors[colors.length - 1];
        if (colors[0] == colors[colors.length - 1] || lengths.isEmpty()) {
            lengths.add(length);
        } else {
            lengths.set(0, lengths.get(0) + length);
        }
        System.out.println(lengths);
        if (lengths.size() == 1) {
            return k == colors.length ? (isOff ? 1 : colors.length)
                    : (isOff ? colors.length - k + 1 : colors.length);
        }
        System.out.println(lengths);
        int ans = 0;
        for (int i : lengths) {
            if (i >= k) {
                ans += i - k + 1;
            }
        }
        return ans;
    }
}