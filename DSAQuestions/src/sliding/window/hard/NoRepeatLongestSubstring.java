package sliding.window.hard;

import java.util.HashMap;
import java.util.Map;


//same in leetcode
//keep curr char's index in map through windowEnd
//if repeated char found, skip windowStart to curr index(prev+1)
public class NoRepeatLongestSubstring {
    //here integer in map corresponds to index of the letter instead of frequency like other problems before
    private static int getMaxLength(String str){
        if(str == null || str.isBlank())
            return 0;
        int windowStart = 0;
        int maxLength = 0;
        Map<Character, Integer> characterIntegerMap = new HashMap<>();
        for(int windowEnd = 0; windowEnd < str.length(); windowEnd++){
            char c = str.charAt(windowEnd);
            if(characterIntegerMap.containsKey(c)){
                windowStart = Math.max(windowStart, characterIntegerMap.get(c) + 1);
            }
            characterIntegerMap.put(c, windowEnd);
            maxLength = Math.max(maxLength, windowEnd - windowStart + 1);
        }

        return maxLength;
    }

    public static void main(String[] args) {
        int minLength = getMaxLength(" ");
        System.out.println(minLength);
    }

}
