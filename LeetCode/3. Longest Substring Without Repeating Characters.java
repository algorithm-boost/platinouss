/**
 * [LeetCode Medium] 3. Longest Substring Without Repeating Characters
 * 링크: https://leetcode.com/problems/longest-substring-without-repeating-characters/
 * 느낀 점: 오랜만에 알고리즘 문제 푸니까 생각보다 예외 처리가 부족했어서, 엣지 케이스에 적지 않게 틀렸다.
 */

import java.util.*;

class Solution {

    static Set<Character> set;

    private void init(char[] arr) {
        set = new HashSet<>();
        set.add(arr[0]);
    }

    private int findSameCharIndex(int start, char c, char[] arr) {
        while (start < arr.length) {
            set.remove(arr[start]);
            if (c == arr[start]) {
                return start;
            }
            start++;
        }
        return 0;
    }

    public int lengthOfLongestSubstring(String s) {
        char[] arr = s.toCharArray();
        if (arr.length == 0) {
            return 0;
        }
        init(arr);
        int start = 0 , end = 0, maxCount = 0;
        while ((end + 1) < arr.length) {
            if (set.contains(arr[end + 1])) {
                maxCount = Math.max(maxCount, end + 1 - start);
                start = findSameCharIndex(start, arr[end + 1], arr) + 1;
            }
            end++;
            set.add(arr[end]);
        }
        return Math.max(maxCount, (end + 1) - start);
    }
}