/**
 * [프로그래머스 Lv3] 가장 먼 노드
 * 링크: https://school.programmers.co.kr/learn/courses/30/lessons/49189
 * 접근방식: 경로 이동 비용이 모두 1이므로 큐를 사용한 다익스트라 알고리즘으로 쉽게 풀 수 있다.
 */

import java.util.*;

class Solution {

    static int maxPrice;
    static int[] arr;
    static Queue<Integer> q = new LinkedList<>();
    static List<List<Integer>> list = new ArrayList<>();

    public void init(int n) {
        arr = new int[n + 1];
        Arrays.fill(arr, Integer.MAX_VALUE);
        arr[1] = 0;
        for (int i=0; i<=n; i++) {
            list.add(new ArrayList<>());
        }
    }

    public void dijkstra() {
        while (!q.isEmpty()) {
            int index = q.remove();
            for (int next : list.get(index)) {
                if (arr[next] > arr[index] + 1) {
                    arr[next] = arr[index] + 1;
                    maxPrice = Math.max(maxPrice, arr[next]);
                    q.add(next);
                }
            }
        }
    }

    public int solution(int n, int[][] edge) {
        init(n);
        for (int[] road : edge) {
            list.get(road[0]).add(road[1]);
            list.get(road[1]).add(road[0]);
        }
        q.add(1);
        dijkstra();
        int count = 0;
        for (int i=1; i<=n; i++) {
            if (arr[i] == maxPrice) {
                count++;
            }
        }
        return count;
    }
}