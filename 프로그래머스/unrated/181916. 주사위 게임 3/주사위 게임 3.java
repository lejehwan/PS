import java.util.*;
class Solution {
    public int solution(int a, int b, int c, int d) {
        Set<Integer> set = new HashSet<>();
        set.add(a);
        set.add(b);
        set.add(c);
        set.add(d);
        // case 1
        if (set.size() == 1) return a * 1111;
        // case 5
        if (set.size() == 4) return Math.min(Math.min(Math.min(a, b), c), d);
        // case 4
        if (set.size() == 3) {
            if (a == b) return c * d;
            if (b == c) return a * d;
            if (c == d) return a * b;
            if (d == a) return b * c;
            if (a == c) return b * d;
            if (b == d) return a * c;
        }
        // case 3
        if (a == b && c == d) return (a + c) * (Math.abs(a - c));
        if (a == c && b == d) return (a + b) * (Math.abs(a - b));
        // distinct
        if (a == d && b == c) return (a + b) * (Math.abs(a - b));

        // case 2
        // d만 다름
        if (a == b && b == c) return (int) Math.pow((10 * a + d),2);
        // c만 다름
        if (a == b && b == d) return (int) Math.pow((10 * a + c),2);
        // b만 다름
        if (a == c && c == d) return (int) Math.pow((10 * a + b),2);
        // a만 다름
        if (b == c && c == d) return (int) Math.pow((10 * b + a),2);
        return 0;
    }
}