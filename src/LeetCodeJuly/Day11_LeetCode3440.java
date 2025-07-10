package LeetCodeJuly;

public class Day11_LeetCode3440 {
    public static void main(String[] args) {

    }
    public static int maxFreeTime(int eventTime, int[] startTime, int[] endTime) {
        int[] duration= new int[startTime.length+1];
        duration[0]=startTime[0];
        for(int i=1;i<startTime.length;i++){
            duration[i]=startTime[i]-endTime[i-1];
        }
        duration[startTime.length]=eventTime-endTime[startTime.length-1];
        int n=duration.length;
        int[] maxLeftArray = new int[n+1];
        int[] maxRightArray = new int[n+1];
        for(int i=n-2;i>=0;i--){
            maxRightArray[i]=Math.max(maxRightArray[i+1], duration[i+1]);
        }
        for(int i=1;i<n;i++){
            maxLeftArray[i]=Math.max(maxLeftArray[i-1], duration[i-1]);
        }
        // Iterating on the FreeArray(Duration)
        int result =0;
        for(int i=1;i<n;i++){
            int currEventTime=endTime[i-1]-startTime[i-1];// Duration of Event d
            // Case-1
            if(currEventTime<=Math.max(maxRightArray[i],maxLeftArray[i-1])){
                result=Math.max(result, duration[i-1]+currEventTime+duration[i]);
            }

            //Case-2
            result=Math.max(result, duration[i-1]+duration[i]);
        }
        return result;
    }
}
