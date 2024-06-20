package sliding.window.problems;


import java.util.HashMap;
import java.util.Map;

public class MinimumWindowSubstring {

    public static String getMinimumWindowSubstring(String str, String pattern){
        int windowStart = 0;
        int matched = 0;
        int substrStart = 0;
        int minLength = str.length() + 1;
        Map<Character, Integer> charFreqMap = new HashMap<>();
        for(char c: pattern.toCharArray()){
            charFreqMap.put(c, charFreqMap.getOrDefault(c, 0) + 1);
        }

        for(int windowEnd = 0; windowEnd < str.length(); windowEnd++){
            char rightChar = str.charAt(windowEnd);
            if(charFreqMap.containsKey(rightChar)){
                charFreqMap.put(rightChar, charFreqMap.get(rightChar) - 1);
                if(charFreqMap.get(rightChar) >= 0){
                    matched++;
                }
            }

            while(matched == pattern.length()){
                if (minLength > windowEnd - windowStart + 1) {
                    minLength = windowEnd - windowStart + 1;
                    substrStart = windowStart;
                }
                char leftChar = str.charAt(windowStart++);
                if(charFreqMap.containsKey(leftChar)){
                    if(charFreqMap.get(leftChar) == 0){
                        matched--;
                    }
                    charFreqMap.put(leftChar, charFreqMap.get(leftChar) + 1);
                }
            }

        }
        return minLength > str.length() ? "" : str.substring(substrStart, substrStart + minLength);
    }

    public static void main(String[] args) {
        String s = getMinimumWindowSubstring("aabdec", "abc");
        System.out.println(s);
    }
}
