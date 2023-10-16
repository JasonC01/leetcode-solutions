class Solution {
    public List<Integer> getRow(int rowIndex) {
        List<Integer> prevRow = new ArrayList<>();
        prevRow.add(1);
        for (int i = 0; i < rowIndex; i++) {
            System.out.println(prevRow);
            List<Integer> currRow = new ArrayList<>();
            currRow.add(prevRow.get(0));
            for (int j = 1; j < prevRow.size(); j++) {
                currRow.add(prevRow.get(j - 1) + prevRow.get(j));
            }
            currRow.add(prevRow.get(prevRow.size() - 1));
            prevRow.clear();
            prevRow.addAll(currRow);
        }
        return prevRow;
    }
}