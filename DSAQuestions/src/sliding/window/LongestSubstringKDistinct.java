package sliding.window;

import java.security.InvalidParameterException;
import java.util.HashMap;
import java.util.Map;

//leetcode version is premium
//same as MaxFruitCountOf2types, just k = 2
//line 24 has while loop in grokking
public class LongestSubstringKDistinct {

    private static int longestSubstring(String str, int k) {
        //constraint check
        if(str == null || str.length() == 0 || str.length() < k){
            throw new InvalidParameterException();
        }

        int windowStart = 0;
        int maxLength = 0;
        Map<Character, Integer>  characterIntegerMap = new HashMap<>();
        for(int windowEnd = 0; windowEnd < str.length(); windowEnd++){
            char current = str.charAt(windowEnd);
            characterIntegerMap.put(current, characterIntegerMap.getOrDefault(current, 0) + 1);
            if (characterIntegerMap.size() > k){
                char start = str.charAt(windowStart);
                characterIntegerMap.put(start, characterIntegerMap.get(start) - 1);
                if(characterIntegerMap.get(start) == 0)
                    characterIntegerMap.remove(start);
                windowStart++;
            }
            maxLength = Math.max(maxLength, windowEnd - windowStart + 1);
        }

        return maxLength;
    }

    public static void main(String[] args) {
        int maxLength = longestSubstring("cbbebi", 3);
        System.out.println(maxLength);
    }
}
