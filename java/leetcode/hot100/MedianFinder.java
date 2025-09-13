package hot100;

import java.util.PriorityQueue;

public class MedianFinder {
    PriorityQueue<Integer>larger;//比中位数大的元素，升序
    PriorityQueue<Integer>smaller;//比中位数小的元素，降序

    public MedianFinder(){
        larger=new PriorityQueue<>();
        smaller=new PriorityQueue<>((x,y)->y-x);
    }

    public void addNum(int num) {
        if(larger.isEmpty() || num>larger.peek()){
            larger.add(num);
        }
        else {
            smaller.add(num);
        }

        if(larger.size()>smaller.size()+1){
            smaller.add(larger.poll());
        }
        else if (smaller.size()>larger.size()){
            larger.add(smaller.poll());
        }
    }

    public double findMedian() {
        return larger.size()==smaller.size()?(larger.peek()+smaller.peek())/2.0:larger.peek();
    }
}
