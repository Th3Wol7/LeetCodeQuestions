package RomantoInteger;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class RomanToInteger {
    public static int romanToInt(String s) {
        int value = 0;
        Map<Character, Integer> symbolValues = new HashMap<Character, Integer>();
        symbolValues.put('I', 1);
        symbolValues.put('V', 5);
        symbolValues.put('X', 10);
        symbolValues.put('L', 50);
        symbolValues.put('C', 100);
        symbolValues.put('D', 500);
        symbolValues.put('M', 1000);
        s = s.toUpperCase();

        //process input
        for (int i = 0; i < s.length(); i++) {
            char symbol = s.charAt(i);
            switch (symbol) {
                case 'I':
                    if (i + 1 != s.length() && (s.charAt(i + 1) == 'V' || s.charAt(i + 1) == 'X')) {
                        value += symbolValues.get(s.charAt(i + 1)) - 1;
                        i++;
                    } else {
                        value += symbolValues.get(symbol);
                    }
                    break;
                case 'X':
                    if (i + 1 != s.length() && (s.charAt(i + 1) == 'L' || s.charAt(i + 1) == 'C')) {
                        value += symbolValues.get(s.charAt(i + 1)) - symbolValues.get(symbol);
                        i++;
                    } else {
                        value += symbolValues.get(symbol);
                    }
                    break;
                case 'C':
                    if (i + 1 != s.length() && (s.charAt(i + 1) == 'D' || s.charAt(i + 1) == 'M')) {
                        value += symbolValues.get(s.charAt(i + 1)) - symbolValues.get(symbol);
                        i++;
                    } else {
                        value += symbolValues.get(symbol);
                    }
                    break;
                case 'V':
                case 'L':
                case 'D':
                case 'M':
                    value += symbolValues.get(symbol);
                    break;
                default:
                    break;
            }
        }
        return value;
    }


    public static void main(String[] args) {
        System.out.println(romanToInt("CDD"));//"MCMXCIV"));
    }

}

