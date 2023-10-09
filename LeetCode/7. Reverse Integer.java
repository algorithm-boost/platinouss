/**
 * [LeetCode Medium] 7. Reverse Integer
 * 링크: https://leetcode.com/problems/reverse-integer/description/
 * 접근방식: MOD 10 연산 결과로 차근차근 역순 정수를 만들어준다.
 */

class Solution {
    public int reverse(int x) {
        int sign = (x < 0) ? -1 : 1;
        int num = Math.abs(x);
        int result = 0, prev = 0;
        while (num > 0) {
            int remain = num % 10;
            result = (result * 10) + remain;
            if (prev != (result - remain) / 10) {
                return 0;
            }
            prev = result;
            num /= 10;
        }
        return result * sign;
    }
}