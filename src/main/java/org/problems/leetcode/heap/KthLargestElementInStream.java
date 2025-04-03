package org.problems.leetcode.heap;

import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

public class KthLargestElementInStream {
    private Queue<Integer> pq;
    private int k;
    public KthLargestElementInStream(int k, int [] nums){
        this.pq = new PriorityQueue<>();
        this.k = k;
        for(int num: nums){
            add(num);
        }
    }
    // adds num to minHeap and return kth largest
    public int add(int num){
        pq.offer(num);
        if(pq.size() > k)
            pq.poll();
        return pq.peek();
    }

    public static void main(String[] args) {
        int [] nums = {4,2,15,3};
        KthLargestElementInStream kthLargest = new KthLargestElementInStream(3, nums);
        System.out.println("3rd largest element in stream is " + kthLargest.add(10));
    }
}
