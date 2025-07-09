package LeetCodeJuly;

import java.util.ArrayList;

public class Day3_LeetCode3333 {
    public static void main(String[] args) {

    }
    public static int possibleStringCount(String word, int k) {
        int MOD = (int)1e9 + 7;
        if(word.isEmpty()){
            return 0;
        }
        ArrayList<Integer> groups = new ArrayList<>();
        int count =1;
        for(int i=1; i<word.length();i++){
            if(word.charAt(i)==word.charAt(i-1)){
                count++;
            }else{
                groups.add(count);
                count=1;
            }
        }
        groups.add(count);

        long total = 1;
        for(int num : groups){
            total = (total*num) % MOD;
        }

        if(k<=groups.size()){
            return (int)total;
        }

        int[] dp = new int[k];
        dp[0]=1;
        for(int freq : groups){
            int[] tempDp = new int[k];
            long sum = 0;
            for(int i=0; i<k; i++){
                if(i>0)
                    sum=(sum+dp[i-1]) % MOD;
                if(i>freq)
                    sum = (sum-dp[i-freq-1]+MOD) % MOD;
                tempDp[i]=(int)sum;
            }
            dp=tempDp;
        }
        long invalidCount = 0;
        for(int i = groups.size(); i<k; i++){
            invalidCount = (invalidCount + dp[i])%MOD;
        }
        return (int)((total-invalidCount+MOD)%MOD);
    }
}
