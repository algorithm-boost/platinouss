/**
 * [프로그래머스 Lv2] 연속된 부분 수열의 합
 * 링크: https://school.programmers.co.kr/learn/courses/30/lessons/178870
 * 사용한 알고리즘: 투 포인터
 * 접근방식 : 오른쪽 포인터가 배열의 범위를 넘지않는 선에서, 총합에 따라 왼쪽/오른쪽 포인터를 움직여서 최적의 인덱스를 반환했다.
 */

class Solution {

    static int N;
    static int sum;

    private void init(int[] sequence) {
        N = sequence.length;
        sum = sequence[0];
    }

    private void sumRightPointerValue(int right, int[] sequence) {
        if (right < N) {
            sum += sequence[right];
        }
    }

    public int[] solution(int[] sequence, int k) {
        init(sequence);
        int left = 0, right = 0;
        int result1 = 0, result2 = N;
        while (left <= right && right < N) {
            if (sum == k) {
                if (result2 - result1 > right - left) {
                    result1 = left;
                    result2 = right;
                }
                right++;
                sumRightPointerValue(right, sequence);
            }
            if (sum > k) {
                sum -= sequence[left];
                left++;
            }
            if (sum < k) {
                right++;
                sumRightPointerValue(right, sequence);
            }
        }
        return new int[] {result1, result2};
    }
}