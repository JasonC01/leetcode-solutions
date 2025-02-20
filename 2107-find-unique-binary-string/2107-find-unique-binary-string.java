class Solution {
    public String findDifferentBinaryString(String[] nums) {
        HashSet<String> set = new HashSet<>();
        Collections.addAll(set, nums);
        return helper(new StringBuilder(), nums[0].length(), set);
    }
    
    public String helper(StringBuilder sb, int n, HashSet<String> set) {
        if (sb.length() == n) {
            return !set.contains(sb.toString()) ? sb.toString() : "";
        }
        sb.append('0');
        String zeroAdded = helper(sb, n, set);
        sb.deleteCharAt(sb.length() - 1);
        if (!zeroAdded.isEmpty()) {
            return zeroAdded;
        }
        sb.append('1');
        String oneAdded = helper(sb, n, set);
        sb.deleteCharAt(sb.length() - 1);
        return oneAdded;
    }
}