/**
 * [프로그래머스 Lv2] 롤케이크 자르기
 * 링크: https://school.programmers.co.kr/learn/courses/30/lessons/132265
 * 접근방식:
 * 1) 왼쪽과 오른쪽의 케이크 개수를 저장하는 map 자료구조를 선언한다.
 * 2) 처음에 오른쪽에 케이크를 모두 저장해두고, 왼쪽으로 케이크 개수를 하나씩 옮기면서 map size를 비교한다.
 */

import java.util.*;

class Solution {

    static Map<Integer, Integer> left = new HashMap<>();
    static Map<Integer, Integer> right = new HashMap<>();

    private void init(int[] topping) {
        for (int cake : topping) {
            right.put(cake, right.getOrDefault(cake, 0) + 1);
        }
    }

    private void addCake(int cake) {
        left.put(cake, left.getOrDefault(cake, 0) + 1);
    }

    private void deleteCake(int cake) {
        right.put(cake, right.get(cake) - 1);
        if (right.get(cake) == 0) {
            right.remove(cake);
        }
    }

    private boolean isFair() {
        if (left.size() == right.size()) {
            return true;
        }
        return false;
    }

    public int solution(int[] topping) {
        int count = 0;
        init(topping);
        for (int cake : topping) {
            addCake(cake);
            deleteCake(cake);
            if (isFair()) {
                count++;
            }
        }
        return count;
    }
}