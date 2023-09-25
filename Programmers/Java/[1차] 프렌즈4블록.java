/**
 * 프로그래머스 Lv2
 * 문제: [1차] 프렌즈4블록
 * 링크: https://school.programmers.co.kr/learn/courses/30/lessons/17679
 * 사용한 알고리즘: 구현
 * 한줄평: 재사용 될 만한 기능을 잘 분리해서 풀었다.
 */

import java.util.*;

class Solution {

    static int N, M;
    static int count;
    static char[][] arr;
    static int[] di = {0, 0, 1, 1};
    static int[] dj = {0, 1, 0, 1};
    static List<Point> deletablePoint = new ArrayList<>();

    private void init(int m, int n, String[] board) {
        N = m;
        M = n;
        arr = new char[N][M];
        for (int i=0; i<N; i++) {
            arr[i] = board[i].toCharArray();
        }
    }

    private boolean isDeletablePoint(int a, int b) {
        char c = arr[a][b];
        if (c == '0') {
            return false;
        }
        for (int k=0; k<di.length; k++) {
            if (c != arr[a + di[k]][b + dj[k]]) {
                return false;
            }
        }
        deletablePoint.add(new Point(a, b));
        return true;
    }

    private boolean isDeleted() {
        boolean check = false;
        for (int i=0; i<N-1; i++) {
            for (int j=0; j<M-1; j++) {
                if (isDeletablePoint(i, j)) {
                    check = true;
                }
            }
        }
        if (!check) {
            return false;
        }
        setDeletableBlock();
        deleteBlock();
        return true;
    }

    private void setDeletableBlock() {
        for (Point point : deletablePoint) {
            for (int k=0; k<di.length; k++) {
                if (arr[point.i + di[k]][point.j + dj[k]] != '0') {
                    count++;
                }
                arr[point.i + di[k]][point.j + dj[k]] = '0';
            }
        }
    }

    private void deleteBlock() {
        for (int i=N-2; i>=0; i--) {
            for (int j=0; j<M; j++) {
                moveBlock(i, j);
            }
        }
    }

    private void moveBlock(int a, int b) {
        int result = a;
        while (result + 1 < N) {
            if (arr[result + 1][b] != '0') {
                break;
            }
            result++;
        }
        if (result == a) {
            return;
        }
        arr[result][b] = arr[a][b];
        arr[a][b] = '0';
    }

    public int solution(int m, int n, String[] board) {
        init(m, n, board);
        while (true) {
            deletablePoint.clear();
            if (!isDeleted()) {
                break;
            }
        }
        return count;
    }
}

class Point {
    int i, j;

    public Point(int i, int j) {
        this.i = i;
        this.j = j;
    }
}