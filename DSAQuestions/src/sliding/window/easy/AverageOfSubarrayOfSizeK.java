package sliding.window.easy;

import java.util.Arrays;

public class AverageOfSubarrayOfSizeK {

    private static double[] getAverages(int[] arr, int k){
        double[] avg = new double[arr.length - k + 1];
        int windowStart = 0;
        double windowSum = 0;
        for(int windowEnd = 0; windowEnd < arr.length; windowEnd++){
            windowSum += arr[windowEnd];
            if(windowEnd >= k - 1){
                avg[windowStart] = windowSum/k;
                windowSum -= arr[windowStart];
                windowStart++;
            }
        }
        return avg;
    }

    public static void main(String[] args) {
        double[] result = getAverages(new int[]{1,3,2,6,-1,4,1,8,2}, 5);
        System.out.println(Arrays.toString(result));
    }
}
