package heap;

import java.util.PriorityQueue;

/**
 * Maintain running median of streaming data
 *
 */
public class MedianOfDataStream {
	PriorityQueue<Integer> minHeapOfLarger;
	PriorityQueue<Integer> maxHeapOfSmaller;
    
    public MedianOfDataStream() {
    	minHeapOfLarger = new PriorityQueue<Integer>();
    	maxHeapOfSmaller = new PriorityQueue<Integer>(new MaxComparator());
    }
    
    public void addNum(int num) {
        maxHeapOfSmaller.add(num);
        minHeapOfLarger.add(maxHeapOfSmaller.remove());  //rebalancing step
        
        if (minHeapOfLarger.size() - maxHeapOfSmaller.size() >= 2) {
            maxHeapOfSmaller.add(minHeapOfLarger.remove());
        }  
    }
    
    public double findMedian() {
        if (maxHeapOfSmaller.size() != minHeapOfLarger.size())
            return minHeapOfLarger.peek();
        else
            return ((double)minHeapOfLarger.peek() + maxHeapOfSmaller.peek())/2;
    }
    
	public static void main(String[] args) {
		MedianOfDataStream medianFinder = new MedianOfDataStream();
		medianFinder.addNum(1);
		medianFinder.addNum(2);
		System.out.println(medianFinder.findMedian());
		medianFinder.addNum(3);
		System.out.println(medianFinder.findMedian());
	}

}

