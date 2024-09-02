/* The isBadVersion API is defined in the parent class VersionControl.
      boolean isBadVersion(int version); */

public class Solution extends VersionControl {
    public int firstBadVersion(int n) {
        long low = 0;
        long high = n;
        while (low < high) {
            long mid = Math.floorDiv(low + high, 2);
            System.out.println(mid);
            if (isBadVersion((int) mid)) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }
        return (int) low;
    }
}