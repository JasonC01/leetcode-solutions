class Solution {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        int ans = n;
        for (int i = 0; i < flowerbed.length; i++) {
            if (flowerbed[i] != 1 && flowerbed[Math.max(0, i - 1)] == 0 && flowerbed[Math.min(flowerbed.length - 1, i + 1)] == 0) {
                flowerbed[i] = 1;
                ans--;
            }
        }
        return ans <= 0;
    }
}