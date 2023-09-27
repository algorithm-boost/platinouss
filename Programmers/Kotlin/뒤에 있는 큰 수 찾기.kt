/**
 * [프로그래머스 Lv2] 뒤에 있는 큰 수 찾기
 * 링크: https://school.programmers.co.kr/learn/courses/30/lessons/154539
 * 접근방식)
 * 1. 자바로 풀었던 문제라, 코틀린으로 작성된 코드들을 보면서 고차 함수를 최대한 사용해서 해결하려 노력했다.
 * 2. 다시 생각해보니 굳이 stack을 쓰지 않고 풀 수 있었다.
 * 3. numbers를 순회하며 특정 값을 저장할 때 특정 값보다 큰 값만 남겨두고, 결과 값은 기준 값 다음으로 큰 값을 가져오면 된다.
 */

class Solution {
    fun solution(numbers: IntArray): IntArray {
        val stored = sortedSetOf<Int>()
        return numbers.asList().asReversed().map { num ->
            val result = stored.higher(num) ?: -1
            stored.removeAll { it < num }
            stored.add(num)
            result
        }.asReversed().toIntArray()
    }
}