package VerifyAnAlienDictionary;

import java.util.HashMap;

public class VerifyDictionary {

    public static boolean isAlienSorted(String[] words, String order) {
        HashMap<Character, Integer> alphabet  = new HashMap<>();
        boolean check = true;
        for(int i = 0; i < order.length(); i++){
            alphabet.put(order.charAt(i), i+1);
        }
        for(int i = 0; i < words.length-1; i++) {
            for (int j = 0; j < words[i].length(); j++) {
                if(j == words[i + 1].length()){
                    return false;
                }
                if(words[i].charAt(j) != words[i + 1].charAt(j)){
                    if(alphabet.get(words[i].charAt(j)) > alphabet.get(words[i+1].charAt(j))){
                        return false;
                    }
                    break;
                }
            }
        }
        return check;
    }
    public static void main(String[] args){
        String[] words = {"my","f"};
        System.out.println(isAlienSorted(words, "gelyriwxzdupkjctbfnqmsavho"));
    }

}

