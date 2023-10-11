class Solution {
    public int[] fullBloomFlowers(int[][] flowers, int[] people) {
        int[][] blooming = flowers.clone();
        int[][] dead = flowers.clone();
        Arrays.sort(blooming, Comparator.comparing(x -> x[0]));
        Arrays.sort(dead, Comparator.comparing(x -> x[1]));
        System.out.println(Arrays.deepToString(blooming));
        System.out.println(Arrays.deepToString(dead));
        int[] ans = new int[people.length];
        for (int i = 0; i < people.length; i++) {
            System.out.println(binarySearch(blooming, people[i], true));
            System.out.println(binarySearch(dead, people[i], false));
            ans[i] = binarySearch(blooming, people[i], true) - binarySearch(dead, people[i], false);
        }
        return ans;
    }

    public int binarySearch(int[][] flowers, int person, boolean isBlooming) {
        int high = flowers.length - 1;
        int low = 0;
        while (high > low) {
            int mid = (int) Math.ceil((high + low) / 2.0);
            if (isBlooming) {
                if (flowers[mid][0] > person) {
                    high = mid - 1;
                } else {
                    low = mid;
                }
            } else {
                if (flowers[mid][1] >= person) {
                    high = mid - 1;
                } else {
                    low = mid;
                }
            }
            
        }
        if (isBlooming) {
            return flowers[low][0] <= person ? low : -1;
        } else {
            return flowers[low][1] < person ? low : -1;
        }
    }

}