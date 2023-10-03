/**
 * [프로그래머스 Lv3] 이중우선순위큐
 * 링크: https://school.programmers.co.kr/learn/courses/30/lessons/42628
 * 접근방식:
 * 1) 최댓값, 최솟값이 우선순위가 높은 우선순위 큐 2개를 생성한다.
 * 2) 값이 추가가 될 때는 두 우선순위 큐에 모두 값을 추가한다.
 * 3) 최댓값 삭제 연산은 최댓값이 우선순위가 높은 우선순위 큐에서 값을 삭제하고, 최솟값 삭제 연산은 반대로 진행한다.
 * 4) 연산을 진행하고, 특정 큐에 값이 없거나 '최대 우선순위큐'.peek() < '최소 우선순위큐'.peek()일 경우에는 두 개의 큐를 초기화한다.
 * 5) 결과 산출 시, 특정 큐가 비었다면 [0, 0] 반환한다. 이외에는 각 큐에서 값을 뽑아서 결과로 출력한다.
 */

import java.util.*;

class Solution {

    static PriorityQueue<Integer> pqHigh = new PriorityQueue<>((o1, o2) -> {
        return o2 - o1;
    });
    static PriorityQueue<Integer> pqLow = new PriorityQueue<>();

    public int[] solution(String[] operations) {
        for (String operation : operations) {
            String[] oper = operation.split(" ");
            if (oper[0].equals("I")) {
                pqHigh.add(Integer.parseInt(oper[1]));
                pqLow.add(Integer.parseInt(oper[1]));
            }
            if (oper[0].equals("D") && oper[1].equals("1") && !pqHigh.isEmpty()) {
                pqHigh.remove();
            }
            if (oper[0].equals("D") && oper[1].equals("-1") && !pqLow.isEmpty()) {
                pqLow.remove();
            }
            if (pqHigh.isEmpty() || pqLow.isEmpty() || pqHigh.peek() < pqLow.peek()) {
                pqHigh.clear();
                pqLow.clear();
            }
        }
        if (pqHigh.isEmpty() || pqLow.isEmpty()) {
            return new int[]{0, 0};
        }
        return new int[]{pqHigh.remove(), pqLow.remove()};
    }
}