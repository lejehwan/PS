import java.util.*;
class Solution {
    public int solution(int a, int b) {
        if (check(a) && check(b)) return a * a + b * b;
        if (check(a) || check(b)) return (a + b) * 2;
        return Math.abs(a - b);
    }
    
    public static boolean check(int num){
        return num % 2 != 0 ? true : false;
    }
}