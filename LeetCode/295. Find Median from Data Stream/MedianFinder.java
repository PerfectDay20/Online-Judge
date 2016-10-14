import java.util.Comparator;
import java.util.PriorityQueue;

public class MedianFinder {
    PriorityQueue<Integer> largePQ = new PriorityQueue<>();
    PriorityQueue<Integer> smallPQ = new PriorityQueue<>(Comparator.reverseOrder());
    // Adds a number into the data structure.
    public void addNum(int num) {
        double mid = findMedian();
        if (num >= mid) {
            largePQ.add(num);
        } else {
            smallPQ.add(num);
        }
        int ls = largePQ.size(), ss = smallPQ.size();
        if (ls < ss) {
            largePQ.add(smallPQ.remove());
        }
        if (ls > ss + 1) {
            smallPQ.add(largePQ.remove());
        }
    }

    // Returns the median of current data stream
    public double findMedian() {
        if (largePQ.size() == 0) {
            return 0;
        }
        if (largePQ.size() == smallPQ.size()) {
            return ((double) largePQ.peek() + smallPQ.peek()) / 2;
        } else {
            return largePQ.peek();
        }
    }
};

// Your MedianFinder object will be instantiated and called as such:
// MedianFinder mf = new MedianFinder();
// mf.addNum(1);
// mf.findMedian();