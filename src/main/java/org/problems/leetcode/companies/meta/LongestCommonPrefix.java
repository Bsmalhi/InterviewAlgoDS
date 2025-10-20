package org.problems.leetcode.companies.meta;

public class LongestCommonPrefix {
    public String longestCommonPrefix(String[] str){
        if(str.length == 0)
            return "";
        String result = str[0];
        for(String s: str){
            while(s.indexOf(result) != 0){
                result = result.substring(0, result.length() - 1);
            }
        }
        return result;
    }
    public static void main(String[] args) {
        LongestCommonPrefix lcp = new LongestCommonPrefix();
        String[][] testCases = {
            {"flower", "flow", "flight"},
            {"dog", "racecar", "car"},
            {"interspecies", "interstellar", "interstate"},
            {"throne", "throne"},
            {}
        };
        for (String[] test : testCases) {
            String result = lcp.longestCommonPrefix(test);
            System.out.print("Input: ");
            for (String s : test) {
                System.out.print(s + " ");
            }
            System.out.println("\nLongest Common Prefix: " + result + "\n");
        }
    }
}
