package sliding.window.hard;

import java.util.HashMap;
import java.util.Map;

//keep putting right char and its frequency till window doesnt have k char to replace
//update maxOcc acc
//when k reached, reduce occurrence of left char
//also update max
public class KCharacterReplacement {
    private static int getMax(String str, int k){
        int windowStart = 0;
        int maxLength = 0;
        int maxOccurence = 0;
        Map<Character, Integer> characterIntegerMap = new HashMap<>();
        for(int windowEnd = 0; windowEnd < str.length(); windowEnd++){
            char rightChar = str.charAt(windowEnd);
            characterIntegerMap.put(rightChar, characterIntegerMap.getOrDefault(rightChar, 0) + 1);
            maxOccurence = Math.max(maxOccurence, characterIntegerMap.get(rightChar));
            //since our max comes from windowLength,
            //we check if we have more than k chars left to replace in that window,
            //and shrink if true
            while(windowEnd - windowStart + 1 - maxOccurence > k){
                char leftChar = str.charAt(windowStart++);
                characterIntegerMap.put(leftChar, characterIntegerMap.get(leftChar) - 1);
            }

            maxLength = Math.max(maxLength, windowEnd - windowStart + 1);
        }
        return maxLength;
    }

    public static void main(String[] args) {
        System.out.println(getMax("abccde", 1));
    }
}
