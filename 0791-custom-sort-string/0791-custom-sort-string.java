class Solution {
    public String customSortString(String order, String s) {
        List<Character> arr = new ArrayList<>();
        for (char c : s.toCharArray()) {
            arr.add(c);
        }
        arr.sort(Comparator.comparing(order::indexOf));
        StringBuilder sb = new StringBuilder();
        for (Character c : arr) {
            sb.append(c);
        }
        return sb.toString();
    }
}