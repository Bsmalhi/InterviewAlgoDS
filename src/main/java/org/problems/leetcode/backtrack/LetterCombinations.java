package org.problems.leetcode.backtrack;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LetterCombinations {
    private Map<Character, String> map;
    public List<String> letterCombination(String digits){
        List<String> result = new ArrayList<>();
        if(digits.length() == 0)
            return result;
        this.map = new HashMap<>();
        map.put('2', "abc");
        map.put('3', "def");
        map.put('4', "ghi");
        map.put('5', "jkl");
        map.put('6', "mno");
        map.put('7', "pqrs");
        map.put('8', "tuv");
        map.put('9', "wxyz");
        helper(0,"", result, digits);
        return result;
    }
    public void helper(int i, String temp, List<String> result, String digits){
        if(temp.length() >= digits.length()){
            result.add(new String(temp));
            return;
        }
        for(char c : map.get(digits.charAt(i)).toCharArray()){
            helper(i + 1, temp + c, result, digits);
        }
    }

    public static void main(String[] args) {
        String digits = "34";
        LetterCombinations comb = new LetterCombinations();
        System.out.print("Letter combination of the digits " + digits + ": ");
        for(String s : comb.letterCombination(digits)){
            System.out.print(" " + s);
        }
    }
}
