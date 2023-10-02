/**
 * [프로그래머스 Lv2] 택배상자
 * 링크: https://school.programmers.co.kr/learn/courses/30/lessons/131704
 * 접근방식:
 * 1) 기본 컨테이너 벨트는 상자번호가 순차적으로 들어오므로 int형으로 관리한다.
 * 2) 서브 컨테이너 벨트는 마지막에 저장한 상자를 꺼낼 수 있으므로 stack 자료구조형태로 관리한다.
 * 3) 택배 기사님이 원하는 상자 번호가 기본 컨테이너 번호보다 작고, 서브 컨테이너에 마지막에 저장된 상자 번호랑 같지 않다면 더이상 싣을 수 없다.
 */

import java.util.*;

class Solution {

    static int count = 0;
    static int containerSeq = 1;
    static Deque<Integer> subContainer = new ArrayDeque<>();

    private boolean isPossibleLoadOnTruck(int num) {
        if (containerSeq <= num) {
            while (containerSeq != num) {
                subContainer.addLast(containerSeq);
                containerSeq++;
            }
            count++;
            containerSeq++;
            return true;
        }
        if (!subContainer.isEmpty() && subContainer.getLast() == num) {
            subContainer.removeLast();
            count++;
            return true;
        }
        return false;
    }

    public int solution(int[] order) {
        for (int num : order) {
            if (!isPossibleLoadOnTruck(num)) {
                break;
            }
        }
        return count;
    }
}