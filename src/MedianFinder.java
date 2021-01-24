import java.util.Collections;
import java.util.PriorityQueue;

class MedianFinder {
    /*
    *   가장 간단히 할만한 것은 ArrayList sort를 하면되지만 시간초과 가능성이 높음
    *   때문에, 우선순위 큐 두개를 쓰면 중앙값 구하기 가능(최소값, 최대값 우선순위)
    *   전체 입력값이 홀수일 경우에는 maxPq에서 가져오고
    *   짝수일 경우에는 minPq과 maxPq의 값을 나누면 중간값이 된다.
    *   maxPq: 들어있는값들 중 최대값이 peek 여기서는 0~size/2
    *   minPq: 들어있는 값들중 최소값이 peek 여기서는 size/2+1 ~ size
     */
    PriorityQueue<Integer> minPq;
    PriorityQueue<Integer> maxPq;

    /** initialize your data structure here. */
    public MedianFinder() {
        minPq = new PriorityQueue<>();
        maxPq = new PriorityQueue<>(Collections.reverseOrder());
    }

    public void addNum(int num) {
        //두개의 Pq의 size를 맞춘다.
        maxPq.offer(num);
        minPq.offer(maxPq.poll());

        //두개의 Pq의 size를 맞춘다.
        if(maxPq.size() < minPq.size()){
            maxPq.offer(minPq.poll());
        }
    }

    public double findMedian() {
        //짝수일 경우
        if(maxPq.size() == minPq.size()){
                return (double)((maxPq.peek() + minPq.peek()))/2;
        }

        //홀수일 경우
        return maxPq.peek();
    }
}