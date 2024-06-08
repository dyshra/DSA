package sliding.window.leetcode;

import java.util.Arrays;

//No fixed size provided in this question
//Kadane's algorithm, we do currMaxTillIndex and maxOverall step to handle reduction of sum by negative integers
//negative curr to handle all negative integers
public class MaxSubArray {
    private static int max(int[] arr){
        int max = arr[0];
        int curr = arr[0];
        int negativeCurr = Arrays.stream(arr).sum();
        int maxNegative = Arrays.stream(arr).sum();
        for(int i = 1; i < arr.length; i++){
            int num = arr[i];
            curr = Math.max(num, curr+num);
            negativeCurr = Math.max(negativeCurr, negativeCurr-curr);
            max = Math.max(curr, max);
            maxNegative = Math.max(negativeCurr, maxNegative);
        }

        return Math.max(max, maxNegative);
    }

    public static void main(String[] args) {
        int max = max(new int[]{-2, -3, -4, -1});
//        int max = max(new int[]{1});
        System.out.println(max);
    }
}
