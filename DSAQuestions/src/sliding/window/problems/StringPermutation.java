package sliding.window.problems;

import java.util.HashMap;
import java.util.Map;

//leetcode has a version with arr[26] which im not doing

public class StringPermutation {
    public static boolean hasPermutation(String str, String pattern){
        int windowStart = 0;
        int match = 0;
        Map<Character, Integer> charFreqMap = new HashMap<>();
        for(char c: pattern.toCharArray()){
            charFreqMap.put(c, charFreqMap.getOrDefault(c, 0) + 1);
        }

        for(int windowEnd = 0; windowEnd < str.length(); windowEnd++){
            char c = str.charAt(windowEnd);
            if(charFreqMap.containsKey(c)){
                charFreqMap.put(c, charFreqMap.get(c) - 1);
                if(charFreqMap.get(c) == 0)
                    match++;
            }

            if(match == charFreqMap.size())
                return true;

            if(windowEnd >= pattern.length() - 1){
                char left = str.charAt(windowStart);
                if(charFreqMap.containsKey(left)) {
                    if(charFreqMap.get(left) == 0)
                        match--;
                    charFreqMap.put(left, charFreqMap.getOrDefault(left, 0) + 1);
                }
                windowStart++;
            }

        }

        return false;
    }

    public static void main(String[] args) {
        boolean x = hasPermutation("dcda", "adc");
        System.out.println(x);
    }
}
