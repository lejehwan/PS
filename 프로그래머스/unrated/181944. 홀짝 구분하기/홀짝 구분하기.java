import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String flag = n % 2 == 0 ? "even" : "odd";
        System.out.println(n + " is " + flag);
    }
}