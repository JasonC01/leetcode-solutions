class Solution {
    public String kthDistinct(String[] arr, int k) {
        HashMap<String, Integer> map = new HashMap<>();
        for (String s : arr) {
            map.merge(s, 1, (a, b) -> a + 1);
        }
        for (String key : arr) {
            if (map.get(key) == 1) {
                if (k == 1) {
                    return key;
                }
                k--;
            }
        }
        return "";
    }
}