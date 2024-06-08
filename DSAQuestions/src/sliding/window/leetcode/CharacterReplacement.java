package sliding.window.leetcode;


//leetcode version done with int array for frequency instead of hashmap for speed
public class CharacterReplacement {
    private static int getMax(String s, int k){
        int windowStart = 0;
        int[] arr = new int[26];
        char[] chars = s.toCharArray();
        int max = 0;
        for(int windowEnd = 0; windowEnd < s.length(); windowEnd++)
        {
            arr[chars[windowEnd] - 'A']++;
            max = Math.max(max, arr[chars[windowEnd] - 'A']);
            while(windowEnd - windowStart + 1 - max > k){
                arr[chars[windowStart] - 'A']--;
                windowStart++;
            }
        }
        //window length is kept valid through the above for loop so below condition can be used to get the length
        return chars.length - windowStart;
    }

    public static void main(String[] args) {
        int x = getMax("AAABAA", 1);
        System.out.println(x);
    }
}
