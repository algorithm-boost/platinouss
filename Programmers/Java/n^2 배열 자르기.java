/**
 * [프로그래머스 Lv2] n^2 배열 자르기
 * 링크: https://school.programmers.co.kr/learn/courses/30/lessons/87390
 * 접근방식 :
 * 1. n이 10^7이므로 배열의 모든 값을 구하면 무조건 TLE가 난다.
 * 2. 따라서 left ~ right 인덱스로 해당 값을 바로 가져올 수 있는 방식은 없을까 고민하다가, 행렬의 인덱스로 바로 구할 수 있었다.
 */

class Solution {

    private int getValue(int n, long index) {
        int i = (int) (index % n) + 1;
        int j = (int) (index / n) + 1;
        return Math.max(i, j);
    }

    public int[] solution(int n, long left, long right) {
        int index = 0;
        int N = (int) (right - left) + 1;
        int[] result = new int[N];
        for (long i=left; i<=right; i++) {
            result[index] = getValue(n, i);
            index++;
        }
        return result;
    }
}