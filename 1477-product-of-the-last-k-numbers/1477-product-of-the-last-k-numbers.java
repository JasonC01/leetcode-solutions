class ProductOfNumbers {

        int closestZero = -1;
        List<Integer> arr = new ArrayList<>();
        List<Integer> prefArr = new ArrayList<>();

        public ProductOfNumbers() {

        }

        public void add(int num) {
            if (num == 0) {
                arr.add(num);
                prefArr.add(1);
                closestZero = arr.size() - 1;
                return;
            }
            if (arr.isEmpty()) {
                arr.add(num);
                prefArr.add(num);
            } else {
                arr.add(num);
                prefArr.add(prefArr.get(prefArr.size() - 1) * num);
            }
        }

        public int getProduct(int k) {
            int startIndex = arr.size() - 1 - k;
            if (closestZero > startIndex) {
                return 0;
            } else {
                if (startIndex < 0) {
                    return prefArr.get(prefArr.size() - 1);
                }
                if (prefArr.get(startIndex) == 0) {
                    System.out.println(prefArr);
                }
                return prefArr.get(prefArr.size() - 1) / prefArr.get(startIndex);
            }
        }
    }

/**
 * Your ProductOfNumbers object will be instantiated and called as such:
 * ProductOfNumbers obj = new ProductOfNumbers();
 * obj.add(num);
 * int param_2 = obj.getProduct(k);
 */