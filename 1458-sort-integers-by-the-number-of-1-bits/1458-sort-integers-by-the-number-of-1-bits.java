class Solution {
    public int[] sortByBits(int[] arr) {
        List<Integer> arrList = new ArrayList<>();
        for (int i : arr) {
            arrList.add(i);
        }
        arrList.sort(Comparator.comparing(x -> x));
        arrList.sort(Comparator.comparing(this::getOnes));
        for (int i = 0; i < arrList.size(); i++) {
            arr[i] = arrList.get(i);
        }
        return arr;
    }

    public int getOnes(int n) {
        int ans = 0;
        while (n > 0) {
            ans += n % 2;
            n = n >> 1;
        }
        return ans;
    }
}