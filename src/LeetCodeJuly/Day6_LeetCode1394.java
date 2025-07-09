package LeetCodeJuly;

import java.util.HashMap;
import java.util.Map;

public class Day6_LeetCode1394 {
    public static void main(String[] args) {

    }
    public static int findLucky(int[] arr) {
        HashMap<Integer, Integer> freq = new HashMap<>();
        for(int a: arr){
            freq.put(a,freq.getOrDefault(a,0)+1);
        }
        int temp = 0;
        int max = Integer.MIN_VALUE;
        for(Map.Entry<Integer, Integer> entry : freq.entrySet()){
            if(entry.getKey().equals(entry.getValue())){
                temp=entry.getKey();
                max=Math.max(temp,max);
            }
        }
        if(max!=Integer.MIN_VALUE){
            return max;
        }
        return -1;
    }
}
