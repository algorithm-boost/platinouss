/**
 * [LeetCode Medium] 6. Zigzag Conversion
 * 링크: https://leetcode.com/problems/zigzag-conversion/description/
 * 접근방식:
 * 1) 아래 -> 대각선 -> 아래 ... 방향으로 문자가 배치되는데, 각 행마다 list를 만들어서 순차적으로 list에 값을 추가했다.
 * 2) 만약 numRows = 3이라면, list[0] -> list[1] -> list[2] -> list[1] -> list[0] -> list[1] ... 이런 순서로 담길 것이다.
 * 3) list[0]에 담겨 있는 모든 문자를 합하고 list[n]까지 진행해서 결과를 출력한다.
 */

import java.util.*;

class Solution {

    static int index = 0;
    static List<List<Character>> list;

    public String getResult() {
        String result = "";
        for (List<Character> chars : list) {
            result += chars.stream()
                    .map(Object::toString)
                    .reduce("", (x, y) -> x + y);
        }
        return result;
    }

    public void setRowValue(String s, int numRows) {
        for (int i=1; i<numRows; i++) {
            if (index >= s.length()) {
                return;
            }
            list.get(i).add(s.charAt(index));
            index++;
        }
    }

    public void setDiagonalValue(String s, int numRows) {
        for (int i=numRows - 2; i>=0; i--) {
            if (index >= s.length()) {
                return;
            }
            list.get(i).add(s.charAt(index));
            index++;
        }
    }

    public String convert(String s, int numRows) {
        if (numRows == 1) {
            return s;
        }
        list = new ArrayList<>();
        for (int i=0; i<numRows; i++) {
            list.add(new ArrayList<>());
        }
        index = 1;
        list.get(0).add(s.charAt(0));
        while (index < s.length()) {
            setRowValue(s, numRows);
            setDiagonalValue(s, numRows);
        }
        return getResult();
    }
}
