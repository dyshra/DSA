package sliding.window.leetcode;

import java.util.HashMap;
import java.util.Map;

public class FruitIntoBaskets {

    private static int getMaxFruits(int[] fruits){
        int windowStart = 0;
        int maxFruits = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for(int windowEnd = 0; windowEnd < fruits.length; windowEnd++){
            int fruit = fruits[windowEnd];
            map.put(fruit, map.getOrDefault(fruit, 0) + 1);
            if(map.size() > 2){
                int startFruit = fruits[windowStart];
                map.put(startFruit, map.get(startFruit) - 1);
                if(map.get(startFruit) == 0)
                    map.remove(startFruit);
                windowStart++;
            }
            maxFruits = Math.max(maxFruits, windowEnd - windowStart + 1);
        }
        return maxFruits;
    }

    public static void main(String[] args) {
        int maxFruits = getMaxFruits(new int[]{1,2,3,2,2});
        System.out.println(maxFruits);
    }
}
