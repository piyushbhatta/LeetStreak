package LeetCodeJuly;

public class Day10_LeetCode3439 {
    public static void main(String[] args) {

    }
    public int maxFreeTime(int eventTime, int k, int[] startTime, int[] endTime) {
        int n = startTime.length;
        int[] duration = new int[n+1];
        duration[0]=startTime[0];
        for (int i = 1; i < n; i++) {
            duration[i] = startTime[i] - endTime[i-1];
        }
        duration[n]=eventTime-endTime[endTime.length-1];
        //Two Pointers
        int i=0;
        int j=0;
        int maxSum=0;
        int m=duration.length;
        int sum=0;
        while(j<m){
            sum+=duration[j];
            while(i<m && j-i+1>k+1){
                sum-=duration[i];
                i++;
            }
            maxSum=Math.max(maxSum, sum);
            j++;
        }
        return maxSum;
    }
}
