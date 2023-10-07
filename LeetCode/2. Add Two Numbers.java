/**
 * [LeetCode Medium] 2. Add Two Numbers
 * 링크: https://leetcode.com/problems/add-two-numbers/submissions/
 * 접근방식
 * 1) 각 자리수마다 계산한다음 10이 넘으면 체크해주고 10을 뺀 결과를 list에 저장해준다.
 * 2) list 순회하면서 ListNode 만들어준다.
 */

import java.util.*;

class Solution {

    static List<Integer> totalSum;

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        totalSum = new ArrayList<>();
        boolean isTen = false;
        int v = l1.val + l2.val;
        if (v >= 10) {
            isTen = true;
            v -= 10;
        }
        totalSum.add(v);
        while (!(l1.next == null && l2.next == null)) {
            int sum = (isTen) ? 1 : 0;
            isTen = false;
            if (l1.next != null) {
                sum += l1.next.val;
                l1 = l1.next;
            }
            if (l2.next != null) {
                sum += l2.next.val;
                l2 = l2.next;
            }
            if (sum >= 10) {
                isTen = true;
                sum -= 10;
            }
            totalSum.add(sum);
        }
        if (totalSum.size() == 0) {
            return new ListNode();
        }
        if (isTen) {
            isTen = false;
            totalSum.add(1);
        }
        ListNode result = new ListNode(totalSum.get(0));
        ListNode tmp = result;
        for (int i=1; i<totalSum.size(); i++) {
            tmp.next = new ListNode(totalSum.get(i));
            tmp = tmp.next;
        }
        return result;
    }
}