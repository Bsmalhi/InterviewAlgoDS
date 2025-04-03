package org.problems.leetcode.backtrack;

import java.util.ArrayList;
import java.util.List;

public class PalindromePartitioning {
    public List<List<String>> partition(String s){
        List<List<String>> result = new ArrayList<>();
        if(s.length() == 0)
            return result;
        helperDfs(0, s, result, new ArrayList<String>());
        return result;
    }
    public void helperDfs(int i, String s, List<List<String>> result, List<String> list){
        if(i >= s.length()){
            result.add(new ArrayList<>(list));
        }
        for(int end = i + 1; end <= s.length(); end++){
            if(isPalindrome(s, i, end - 1)){
                list.add(s.substring(i, end));
                helperDfs(end, s, result, list);
                list.remove(list.size() - 1);
            }
        }
    }
    public boolean isPalindrome(String s, int i , int j){
        while(i < j){
            if(s.charAt(i) != s.charAt(j))
                return false;
            i++;
            j--;
        }
        return true;
    }

    public static void main(String[] args) {
        String s = "aab";
        PalindromePartitioning partitioning = new PalindromePartitioning();
        for(List<String> l : partitioning.partition(s)){
            System.out.println();
            for (String str: l){
                System.out.print(" " + str);
            }
        }
    }
}
