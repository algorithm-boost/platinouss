/**
 * [프로그래머스 Lv3] 정수 삼각형
 * 링크: https://school.programmers.co.kr/learn/courses/30/lessons/43105
 * 사용한 알고리즘: DP
 * 접근방식 : 양쪽 사이드 부분은 위의 한 부분만 더해질 수 있고, 나머지 부분은 위의 왼쪽 오른쪽 값 중 최댓값이 더해질 수 있도록 구현했다.
 */

import java.util.*;

class Solution {

    static int N;
    static int[][] dp;

    private void init(int[][] triangle) {
        N = triangle.length;
        dp = new int[N][N];
        dp[0][0] = triangle[0][0];
    }

    private int getMaxValue(int a, int b, int[][] triangle) {
        if (b == 0) {
            return dp[a - 1][b] + triangle[a][b];
        }
        if (a == b) {
            return Math.max(dp[a][b], dp[a - 1][b - 1] + triangle[a][b]);
        }
        return Math.max(dp[a][b], Math.max(dp[a - 1][b - 1], dp[a - 1][b]) + triangle[a][b]);
    }

    public int solution(int[][] triangle) {
        init(triangle);
        for (int i=1; i<N; i++) {
            for (int j=0; j<=i; j++) {
                dp[i][j] = getMaxValue(i, j, triangle);
            }
        }
        return Arrays.stream(dp[N - 1]).max().getAsInt();
    }
}