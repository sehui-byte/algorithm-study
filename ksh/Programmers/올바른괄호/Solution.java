package 올바른괄호;

import java.util.*;

class Solution {
    boolean solution(String s) {

        Stack<Character> stack = new Stack<>();
        char[] arr = s.toCharArray();

        if (arr.length < 2) {
            return false;
        }

        stack.push(arr[0]);
        char top = stack.peek();

        for (int i = 1; i < arr.length; i++) {
            stack.push(arr[i]);

            if (stack.size() == 1) {
                continue;
            }

            if (top == '(' && arr[i] == ')') {
                stack.pop();
                stack.pop();
            }
        }

        if (!stack.empty()) {
            return false;
        } else {
            return true;
        }
    }
}