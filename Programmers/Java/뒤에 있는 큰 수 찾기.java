/**
 * [프로그래머스 Lv2] 뒤에 있는 큰 수 찾기
 * 링크: https://school.programmers.co.kr/learn/courses/30/lessons/154539
 * 사용한 알고리즘: 스택
 * 접근방식)
 * 1. N이 100만이라 numbers 배열을 한번만 순회하는 방법을 생각해야 했다.
 * 2. 뒤에 있는 수 중에서 가까우면서 큰 수를 찾아야 하므로, numbers의 마지막 요소부터 순회하도록 하고 지나온 값을 저장해야겠다 생각했다.
 * 3. 최근에 저장된 값은 가까운 위치에 있다는 의미이니, 최근에 저장된 것이 먼저 뽑히는 stack 자료구조를 사용했다.
 */

import java.util.*;

class Solution {

    static Stack<Integer> stack = new Stack<>();

    private int getLargeNum(int value) {
        while (!stack.isEmpty()) {
            if (stack.peek() > value) {
                return stack.peek();
            }
            stack.pop();
        }
        return -1;
    }

    public int[] solution(int[] numbers) {
        int index = numbers.length - 1;
        int[] result = new int[numbers.length];
        while (index >= 0) {
            result[index] = getLargeNum(numbers[index]);
            stack.push(numbers[index]);
            index--;
        }
        return result;
    }
}
