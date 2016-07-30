/* The guess API is defined in the parent class GuessGame.
   @param num, your guess
   @return -1 if my number is lower, 1 if my number is higher, otherwise return 0
      int guess(int num); */

public class Solution extends GuessGame {
    public int guessNumber(int n) {
        int lo = 1, hi = n;
        int mid = 0;
        while(true){
            mid = (lo + hi)>>>1;
            int guess = guess(mid);
            if(guess==-1){
                hi = mid - 1;
            }else if(guess == 1){
                lo = mid+1;
            }else break;
        }
        return mid;
    }
}