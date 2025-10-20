package org.problems.leetcode.heap;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

/*
left child = i * 2
right child = i * 2 + 1
parent = i/2
*/
public class Heap {
    List<Integer> heap;
    public Heap(){
        heap = new ArrayList<>();
        heap.add(0);
    }
    /*
    * minHeap push pushes to 0 the element
    * heap
    * */
    public void push(int n){

        heap.add(n);
        int i = heap.size() - 1;
        // percolate up
        // check if parent is smaller than current i starting from last added element
        // then move element up
        while(i > 1 && heap.get(i) < heap.get(i / 2)){
            int temp = heap.get(i); // get the parent
            heap.set(i, heap.get(i / 2)); // swap the parent with i
            heap.set(i / 2, temp);
            i = i / 2;
        }
    }
    // pop the min element at the top
    // then percolate down
    public int pop(){
        if(heap.size() == 1)
            return 0;
        if(heap.size() == 2)
            return heap.remove(heap.size() - 1);
        int res = heap.get(1);
        // set last element as first then percolate down
        heap.set(1, heap.remove(heap.size() - 1));
        int i = 1;
        // i > left child percolate down
        while(heap.size() > 2 * i){
           if(heap.get(i) > heap.get(i * 2)){
               int temp = heap.get(i);
               heap.set(i, heap.get(i * 2));
               heap.set(i * 2, temp);
               i = i * 2;
           }else if (heap.size() > i * 2 + 1 && heap.get(i) > heap.get(i * 2 + 1)
                   && heap.get(2 * i + 1) < heap.get(2 * i)){
               int temp = heap.get(i);
               heap.set(i, heap.get(i * 2 + 1));
               heap.set(i * 2 + 1, temp);
               i = i * 2 + 1;
           } else {
               break;
           }
        }
        return res;
    }

    public void heapify(List<Integer> list){
        // to make space for 0th no element
        list.add(list.get(0));
        list.set(0, 0);
        int curr = (list.size() - 1) / 2;
        while( curr > 0){
            int i = curr;
            while(i * 2 < list.size()){
                if(i * 2 + 1 < list.size() &&
                        list.get(i * 2 + 1) < list.get(i * 2) &&
                        list.get(i * 2 + 1) < list.get(i)){
                    int temp = list.get(i);
                    list.set(i, list.get(i * 2 + 1));
                    list.set(i * 2 + 1, temp);
                    i = 2 * i + 1;
                } else if (list.get(i) > list.get(i * 2)) {
                    int temp = list.get(i);
                    list.set(i, list.get(i * 2));
                    list.set(i * 2, temp);
                    i = i * 2;
                } else {
                    break;
                }
            }
            curr--;
        }
    }

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(1);list.add(4);list.add(5);list.add(2);list.add(3);
        Heap heap = new Heap();
        heap.heapify(list);
        for(int n: list)
            System.out.print(" " + n);
    }
}
