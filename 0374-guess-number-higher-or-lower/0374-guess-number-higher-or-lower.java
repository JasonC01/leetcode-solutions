/** 
 * Forward declaration of guess API.
 * @param  num   your guess
 * @return 	     -1 if num is higher than the picked number
 *			      1 if num is lower than the picked number
 *               otherwise return 0
 * int guess(int num);
 */

public class Solution extends GuessGame {
    public int guessNumber(int n) {
        long high = n;
        long low = 1;
        while (low < high) {
            int mid = (int) (((low + high)) / 2);
            int guessN = guess(mid);
            if (guessN == 0) {
                return mid;
            } else if (guessN == 1) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return (int) low;
    }
}