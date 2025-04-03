package org.problems.leetcode.heap;

import java.util.PriorityQueue;
import java.util.Queue;

/*
We want to run a simulation on the stones as follows:
At each step we choose the two heaviest stones, with weight x and y and smash them togethers
If x == y, both stones are destroyed
If x < y, the stone of weight x is destroyed, and the stone of weight y has new weight y - x.
*/
public class LastStoneWeight {
    public static int lastStoneWeight(int [] stones){
        Queue<Integer> pq = new PriorityQueue<>();
        for(int n : stones)
            pq.offer(n);
        while(pq.size() > 1){
            int a = pq.poll();
            int b = pq.poll();
            if( a != b ){
                pq.offer(Math.abs(a - b));
            }
        }
        return pq.size() == 0 ? 0 : pq.poll();
    }

    public static void main(String[] args) {
        int [] nums = {1, 2, 1, 2, 4};
        System.out.println("Last stone in the nums array " + lastStoneWeight(nums));
    }
}
