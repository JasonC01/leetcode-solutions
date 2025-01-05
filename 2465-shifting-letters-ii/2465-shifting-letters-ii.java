class Solution {
    public String shiftingLetters(String s, int[][] shifts) {
        List<int[]> arr = new ArrayList<>();
        for (int[] shift : shifts) {
            int start = shift[0];
            int end = shift[1];
            int value = shift[2] == 1 ? 1 : -1;
            arr.add(new int[]{start, value});
            arr.add(new int[]{end + 1, -value});
        }
        arr.sort(Comparator.comparing(x -> x[0]));
        int curr = 0;
        int index = 0;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            while (index < arr.size() && arr.get(index)[0] == i) {
                curr += arr.get(index)[1];
                index++;
            }
            // System.out.println(curr);
            sb.append(getNext(c, curr));
        }
        return sb.toString();
    }

    public char getNext(char c, int swap) {
        swap = swap < 0 ? -Math.abs(swap) % 26 : swap % 26;
        if (swap < 0) {
            return (char) (c + swap < 97 ? 123 - (97 - (c + swap)) : c + swap);
        } else {
            return (char) (c + swap > 122 ? 96 + (c + swap - 122) : c + swap);
        }
    }
}