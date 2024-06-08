package sliding.window.easy;

//leetcode version is same
//while loop -> in case arr[windowEnd] > arr[windowStart], might need to subtract more

public class MinSizeSubArraySum {

    private static int getMinSize(int s, int[] arr){
        //min size of array whose sum is greater than equal to s
        int windowSum = 0;
        int windowStart = 0;
        int minSize = Integer.MAX_VALUE;
        for(int windowEnd = 0; windowEnd < arr.length; windowEnd++){
            windowSum += arr[windowEnd];

            while(windowSum >= s){
                minSize = Math.min(minSize, windowEnd - windowStart + 1);
                windowSum -= arr[windowStart];
                windowStart++;
            }
        }

        return minSize == Integer.MAX_VALUE ? 0 : minSize;
    }

    public static void main(String[] args) {
        int minSize = getMinSize(7, new int[]{2,1,5,2,3,2});
        System.out.println(minSize);
    }
}
