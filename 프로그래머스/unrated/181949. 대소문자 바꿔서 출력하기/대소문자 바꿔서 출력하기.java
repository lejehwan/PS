import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String a = sc.next();
        char[] chars = a.toCharArray();
        String answer = "";
        for (int i = 0; i < chars.length; i++) {
            if (Character.isUpperCase(chars[i])) answer += Character.toLowerCase(chars[i]);
            else answer += Character.toUpperCase(chars[i]);
        }
        System.out.println(answer);
    }
}