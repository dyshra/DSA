package sliding.window.problems;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class StringAnagrams {
    public static List<Integer> hasPermutation(String str, String pattern){
        int windowStart = 0;
        int match = 0;
        List<Integer> indexList = new ArrayList<>();
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

            if(match == charFreqMap.size()) {
                indexList.add(windowStart);
            }

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

        return indexList;
    }

    public static void main(String[] args) {
        List<Integer> x = hasPermutation("cbaebabacd", "abc");
        System.out.println(x);
    }
}
