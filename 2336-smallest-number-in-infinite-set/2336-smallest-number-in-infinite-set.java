class SmallestInfiniteSet {

   int min = 1;
        HashSet<Integer> removed = new HashSet<>();
        public SmallestInfiniteSet() {
            
        }

        public int popSmallest() {
            int ans = min;
            removed.add(ans);
            while (removed.contains(min)) {
                min++;
            }
            return ans;
        }

        public void addBack(int num) {
            removed.remove(num);
            min = Math.min(min, num);
        }
}

/**
 * Your SmallestInfiniteSet object will be instantiated and called as such:
 * SmallestInfiniteSet obj = new SmallestInfiniteSet();
 * int param_1 = obj.popSmallest();
 * obj.addBack(num);
 */