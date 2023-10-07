/**
 * [LeetCode Medium] 5. Longest Palindromic Substring
 * 링크: https://leetcode.com/problems/longest-palindromic-substring/description/
 * 접근방식:
 * 1) 길이가 1인 문자열부터 양쪽 값을 확인해서 같으면 팰린드롬임을 확인하는 방식인다.
 * 2) 추가적으로 i ~ j 인덱스의 문자열이 팰린드롬인지 확인하는 방법은 (i + 1) ~ (j - 1)이 팰린드롬인지 확인하면 되고,
 *    dp를 사용해서 팰린드롬 여부를 저장해두면 O(n^2)로 가장 큰 팰린드롬을 구할 수 있다.
 */

class Solution {
    public String longestPalindrome(String s) {
        char[] arr = s.toCharArray();
        int start = 0, end = 0, N = arr.length;
        boolean[][] dp = new boolean[N][N];
        for (int i=0; i<N; i++) {
            dp[i][i] = true;
        }
        for (int i=0; i<N-1; i++) {
            if (arr[i] == arr[i + 1]) {
                dp[i][i + 1] = true;
                start = i;
                end = i + 1;
            }
        }
        for (int diff = 2; diff < N; diff++) {
            for (int i=0; i<N - diff; i++) {
                int j = i + diff;
                if (arr[i] == arr[j] && dp[i + 1][j - 1]) {
                    dp[i][j] = true;
                    start = i;
                    end = j;
                }
            }
        }
        return s.substring(start, end + 1);
    }
}