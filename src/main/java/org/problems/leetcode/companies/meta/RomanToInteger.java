package org.problems.leetcode.companies.meta;

import java.util.Map;
import java.util.HashMap;

public class RomanToInteger {
    public int romanToInt(String roman){
        int result =0, i = 0;
        Map<Character, Integer> map = new HashMap<>();
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);

        while(i < roman.length()){
            if(i + 1 < roman.length() && map.get(roman.charAt(i)) < map.get(roman.charAt(i + 1))){
                result += map.get(roman.charAt(i + 1)) - map.get(roman.charAt(i));
                i += 2;
            } else {
                result += map.get(roman.charAt(i));
                i++;
            }
        }

        return result;
    }
    public static void main(String[] args) {
        RomanToInteger converter = new RomanToInteger();
        String[] testCases = {"III", "IV", "IX", "LVIII", "MCMXCIV"};
        for (String roman : testCases) {
            int result = converter.romanToInt(roman);
            System.out.println("Roman: " + roman + " -> Integer: " + result);
        }
        // Expected outputs: 3, 4, 9, 58, 1994
    }
}
