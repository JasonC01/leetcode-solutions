class Solution {
    public boolean canChange(String start, String target) {
        List<int[]> startList = new ArrayList<>();
        List<int[]> targetList = new ArrayList<>();
        for (int i = 0; i < start.length(); i++) {
            if (start.charAt(i) == 'R' || start.charAt(i) == 'L') {
                startList.add(new int[]{start.charAt(i), i});
            }
        }
        for (int i = 0; i < target.length(); i++) {
            if (target.charAt(i) == 'R' || target.charAt(i) == 'L') {
                targetList.add(new int[]{target.charAt(i), i});
            }
        }
        if (startList.size() != targetList.size()) {
            return false;
        }
        int i1 = 0;
        int i2 = 0;
        while (i1 < startList.size() && i2 < targetList.size()) {
            int[] first = startList.get(i1);
            int[] second = targetList.get(i2);
            if (first[0] != second[0]) {
                return false;
            }
            if (first[0] == 'R' && first[1] > second[1]) {
                return false;
            }
            if (first[0] == 'L' && first[1] < second[1]) {
                return false;
            }
            i1++;
            i2++;
        }
        return true;
    }
}