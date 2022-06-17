package com.pantos.vms.biz.test;

import java.util.Stack;

class CorrectParenthesis {

	public static boolean main(String[] args) {

		boolean solution(String s){
            boolean answer = true;
            Stack<Character> stack = new Stack<Character>();

            for (int i = 0; i < s.length(); i++) {
                if (s.charAt(i) == '(')  // 현재 (가 들어갈 자리면 스택에 넣기...
                    stack.push('(');
                else {
                    if (stack.isEmpty()) // 현재 )가 들어갈 자리인데 없으면..?
                        return false;
                    else
                        stack.pop();    // 현재 )가 들어갈 상태에서 스택에 괄호('(')가 있는경우
                }
            }
            answer = (stack.isEmpty()) ? true : false;
            return answer;
        }
    }
}
