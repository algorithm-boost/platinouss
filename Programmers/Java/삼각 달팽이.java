/**
 * [프로그래머스 Lv2] 삼각 달팽이
 * 링크: https://school.programmers.co.kr/learn/courses/30/lessons/68645
 * 접근방식
 * 1) n*n 배열을 만들고, 인덱스 값을 조절하여 요구사항에 맞는 값을 추가했다.
 * 2) 여기서 반시계 방향으로 움직일 때, 움직이는 방식은 3가지 중 하나임을 고려하여 진행했다.
 */

import java.util.*;

class Solution {

    static int[][] arr;
    static List<Integer> list;

    private void init(int n) {
        arr = new int[n][n];
        list = new ArrayList<>();
    }

    private void addNum(int n) {
        for (int i=0; i<n; i++) {
            for (int j=0; j<=i; j++) {
                list.add(arr[i][j]);
            }
        }
    }

    public int[] solution(int n) {
        init(n);
        int value = 1;
        int a = -1, b = 0;
        for (int i=0; i<n; i++) {
            for (int j=i; j<n; j++) {
                if (i % 3 == 0) {
                    a++;
                }
                if (i % 3 == 1) {
                    b++;
                }
                if (i % 3 == 2) {
                    a--;
                    b--;
                }
                arr[a][b] = value;
                value++;
            }
        }
        addNum(n);
        return list.stream().mapToInt(v -> v).toArray();
    }
}