class Solution {
    public char[][] rotateTheBox(char[][] box) {
        for (char[] row : box) {
            int available = box[0].length;
            for (int i = row.length - 1; i >= 0; i--) {
                System.out.println(available);
                if (row[i] == '*') {
                    available = i - 1;
                } else if (row[i] == '#') {
                    if (available == box[0].length) {
                        available = i - 1;
                    } else {
                        row[available] = '#';
                        if (available != i) row[i] = '.';
                        available--;
                    }
                } else {
                    available = available == box[0].length ? i : Math.max(available, i);
                }
            }
        }
        System.out.println(Arrays.deepToString(box));
        char[][] ans = new char[box[0].length][box.length];
        for (int i = 0; i < box.length; i++) {
            for (int j = 0; j < box[0].length; j++) {
                ans[j][i] = box[box.length - 1 - i][j];
            }
        }
        return ans;
    }
}