class Solution {
    HashSet<Integer> visited = new HashSet<>();
    public boolean validateBinaryTreeNodes(int n, int[] leftChild, int[] rightChild) {
        List<Integer> arr = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            arr.add(i);
        }
        for (int i = 0; i < leftChild.length; i++) {
            arr.remove((Integer) leftChild[i]);
            arr.remove((Integer) rightChild[i]);
        }
        if (arr.isEmpty()) {
            return false;
        }
        int root = arr.get(0);
        return helper(leftChild, rightChild, root) && visited.size() == n;
    }

    public boolean helper(int[] leftChild, int[] rightChild, int currentIndex) {
        if (currentIndex == -1) {
            return true;
        }
        if (visited.contains(currentIndex)) {
            return false;
        }
        visited.add(currentIndex);
        return helper(leftChild, rightChild, leftChild[currentIndex]) && helper(leftChild, rightChild, rightChild[currentIndex]);
    }
}
