class Solution {
    public String pushDominoes(String dominoes) {
        int[][] arr = new int[dominoes.length()][2];
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < dominoes.length(); i++) {
            arr[i] = new int[]{dominoes.charAt(i), 0};
        }
        for (int i = 0; i < arr.length - 1; i++) {
            if (arr[i][0] == 'R') {
                if (arr[i + 1][0] == '.') {
                    arr[i + 1] = new int[]{'R', arr[i][1] + 1};
                }
            }
        }
        for (int i = arr.length - 1; i > 0; i--) {
            if (arr[i][0] == 'L') {
                if (arr[i - 1][0] == '.') {
                    arr[i - 1] = new int[]{'L', arr[i][1] + 1};
                } else if (arr[i - 1][0] == 'R'){
                    if (arr[i - 1][1] == arr[i][1] + 1) {
                        arr[i - 1] = new int[]{'.', 0};
                    } else if (arr[i - 1][1] > arr[i][1] + 1) {
                        arr[i - 1] = new int[]{'L', arr[i][1] + 1};
                    }
                }
            }
        }
        for (int[] i : arr) {
            sb.append((char) i[0]);
        }
        return sb.toString();
    }
}