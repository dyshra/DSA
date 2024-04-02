package sliding.window;

public class MaxSumSubArrayOfSizeK {

    private static int getMax(int[] arr, int k){
        int windowStart = 0;
        int windowSum = 0;
        int max = 0;
        for(int windowEnd = 0; windowEnd < arr.length; windowEnd++){
            windowSum += arr[windowEnd];
            if(windowEnd >= k-1){
                max = Math.max(max, windowSum);
                windowSum -= arr[windowStart];
                windowStart++;
            }
        }
        return max;
    }

    public static void main(String[] args) {
        int max = getMax(new int[]{2,1,5,1,3,2}, 3);
        System.out.println(max);
    }
}
