package org.problems.leetcode.backtrack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SubsetsII {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        helper(0, nums, result, new ArrayList<>());
        return result;
    }
    public void helper(int index, int [] nums, List<List<Integer>> result, List<Integer> list){

        // Step 2: Add the current subset to the result
        result.add(new ArrayList<>(list));

        for (int i = index; i < nums.length; i++) {
            // Step 3: Skip duplicates
            if (i > index && nums[i] == nums[i - 1])
                continue;

            // Include the current element
            list.add(nums[i]);
            // Move to the next element
            helper(i + 1, nums, result, list);
            // Backtrack by removing the last added element
            list.remove(list.size() - 1);
        }
    }

    public static void main(String[] args) {
        SubsetsII subset = new SubsetsII();
        int[] arr = {1,2,2};
        System.out.println("Printing subsets of array");
        for(List<Integer> l : subset.subsetsWithDup(arr)){
            System.out.print("[ ");
            for(int n : l)
                System.out.print(n + " ");
            System.out.print(" ]");
        }
    }
}
