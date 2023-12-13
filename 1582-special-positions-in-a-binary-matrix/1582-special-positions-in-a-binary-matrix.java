class Solution {
    public int numSpecial(int[][] mat) {
        int[] rows = new int[mat.length];
        int[] cols = new int[mat[0].length];
        for (int i = 0; i < mat.length; i++) {
            int idx = -1;
            for (int j = 0; j < mat[0].length; j++) {
                if (mat[i][j] == 1) {
                    if (idx != -1) {
                        idx = -1;
                        break;
                    } else {
                        idx = j;
                    }
                }
            }
            rows[i] = idx;
        }
        for (int i = 0; i < mat[0].length; i++) {
            int idx = -1;
            for (int j = 0; j < mat.length; j++) {
                if (mat[j][i] == 1) {
                    if (idx != -1) {
                        idx = -1;
                        break;
                    } else {
                        idx = j;
                    }
                }
            }
            cols[i] = idx;
        }
        int ans = 0;
        for (int i = 0; i < rows.length; i++) {
            int idx = rows[i];
            if (idx != -1) {
                if (cols[idx] == i) {
                    ans++;
                }
            }
        }
        return ans;
    }
}