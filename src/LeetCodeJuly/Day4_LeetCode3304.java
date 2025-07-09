package LeetCodeJuly;

public class Day4_LeetCode3304 {
    public static void main(String[] args) {
        System.out.println(KthCharacter(5));
    }
    public static char KthCharacter(int k){
        StringBuilder word = new StringBuilder("a");
        while(word.length() < k){
            int length = word.length();
            for(int i=0; i<length;i++){
                char newChar = nextChar(word.charAt(i));
                word.append(newChar);
            }
        }
        return word.charAt(k-1);
    }
    public static char nextChar(char c){
        return c=='z'? 'a':(char)(c+1);
    }

}
