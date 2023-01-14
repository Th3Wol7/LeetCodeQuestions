package longestSubstring;

import java.util.HashMap;
import java.util.Map;

public class LongestSubstring {

    /*//Optimised version
    public static int lengthOfLongestSubstring(String s) {
        int count = 0, track = 0;
        Set<Character> prev = new HashSet<>();

        for (int i = 0, j = 0; j < s.length(); j++) {
            if (!prev.contains(s.charAt(j))) {
                prev.add(s.charAt(j));
                track = j - i + 1;
                count = Math.max(count, track);
            } else {
                while (s.charAt(i) != s.charAt(j)) {
                    prev.remove(s.charAt(i));
                    i++;
                }
                i++;
            }
        }
        return count;
    }*/



    //Original
    public static int lengthOfLongestSubstring(String s) {
        int count = 0, track = 0;
        Map<Integer, Character> prev = new HashMap<>();
        for(int i = 0; i < s.length(); i++){
            if (prev.containsValue(s.charAt(i))) {
                for (Map.Entry<Integer, Character> entry: prev.entrySet()) {
                    if (s.charAt(i) == entry.getValue()) {
                        i = entry.getKey()+1;
                        break;
                    }
                }
                prev = new HashMap<>();
                prev.put(i, s.charAt(i));
                track = 1;
            } else {
                prev.put(i, s.charAt(i));
                track++;
                if(track > count) {
                    count = track;
                }
            }
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println("\n" + lengthOfLongestSubstring("abcabcbb"));//"ohvhjdml"));

    }


}
