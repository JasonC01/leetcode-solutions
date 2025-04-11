class Solution {
    public int countSymmetricIntegers(int low, int high) {
        int ans = 0;
        for (int i = low; i <= high; i++) {
            if (check(i)) ans++;
        }
        return ans;
    }
    
    public boolean check(int x) {
        String str = String.valueOf(x);
        if (str.length() % 2 == 1) {
            return false;
        }
        int mid = (str.length() / 2) - 1;
        int front = 0;
        int end = 0;
        for (int i = 0; i < str.length(); i++) {
            int val = Integer.parseInt(str.substring(i, i + 1));
            if (i <= mid) front += val;
            else end += val;
        }
        return front == end;
    }
}