class Solution {
    public String largestNumber(int[] nums) {
        List<String> res = new ArrayList<>();
        for (int i : nums) {
            res.add(String.valueOf(i));
        }
        res.sort((a, b) -> b.concat(a).compareTo(a.concat(b)));
        StringBuilder sb = new StringBuilder();
        for (String s : res) {
            if (sb.toString().equals("0")) {
                break;
            }
            sb.append(s);
        }
        return sb.toString();
    }
}