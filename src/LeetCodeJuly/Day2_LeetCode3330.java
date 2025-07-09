package LeetCodeJuly;

import java.util.HashMap;
import java.util.Map;

public class Day2_LeetCode3330 {
    public static void main(String[] args) {

    }
    public static int possibleStringCount(String word) {
        HashMap<Character, Integer> freq = new HashMap<>();
        for(int i=0;i<word.length();i++){
            if(freq.containsKey(word.charAt(i)) && word.charAt(i)!=word.charAt(i-1)){
                continue;
            }
            freq.put(word.charAt(i),freq.getOrDefault(word.charAt(i),0)+1);
        }
        int count = 0;
        for(Map.Entry<Character, Integer> entry : freq.entrySet() ){
            if(entry.getValue()>1){
                count+=entry.getValue()-1;
            }
        }
        return count+1;
    }
}
