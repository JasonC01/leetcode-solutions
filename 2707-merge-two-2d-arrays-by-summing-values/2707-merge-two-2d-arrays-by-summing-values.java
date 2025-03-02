class Solution {
    public int[][] mergeArrays(int[][] nums1, int[][] nums2) {
        HashMap<Integer, Integer> map = new HashMap<>();
        List<int[]> arr = new ArrayList<>();
        Integer index = 0;
        int first = 0;
        int second = 0;
        while (first < nums1.length && second < nums2.length) {
            int[] firstArr = nums1[first];
            int[] secondArr = nums2[second];
            int firstKey = firstArr[0];
            int firstValue = firstArr[1];
            int secondKey = secondArr[0];
            int secondValue = secondArr[1];
            if (firstKey < secondKey) {
                index = addKey(map, arr, firstKey, firstValue, index);
                first++;
            } else {
                index = addKey(map, arr, secondKey, secondValue, index);
                second++;
            }
        }
        while (first < nums1.length) {
            int[] firstArr = nums1[first];
            int firstKey = firstArr[0];
            int firstValue = firstArr[1];
            addKey(map, arr, firstKey, firstValue, index);
            first++;
        }
        while (second < nums2.length) {
            int[] secondArr = nums2[second];
            int secondKey = secondArr[0];
            int secondValue = secondArr[1];
            addKey(map, arr, secondKey, secondValue, index);
            second++;
        }
        int[][] ans = new int[arr.size()][2];
        for (int i = 0; i < arr.size(); i++) {
            ans[i] = arr.get(i);
        }
        return ans;
    }

    public int addKey(HashMap<Integer, Integer> map, List<int[]> arr, int key, int value, Integer index) {
        if (!map.containsKey(key)) {
            map.put(key, index);
            arr.add(new int[]{key, value});
            return index + 1;
        } else {
            arr.get(map.get(key))[1] += value;
            return index;
        }
    }
}