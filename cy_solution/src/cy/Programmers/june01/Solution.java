package choi.Programmers.june01;

import java.util.Stack;

class Solution {
    public static boolean isRightParenthesis(String s){
        boolean result = false;

        Stack<Character> stack = new Stack<>();

        for(int i=0; i < s.length(); i++){
            char parenthesis = s.charAt(i);

            if(stack.size() == 0){
                stack.push(parenthesis);
                continue;
            }

            if(parenthesis == '('){
                stack.push(parenthesis);
            } else if(parenthesis == ')'){
                if(stack.peek() == '('){
                    stack.pop();
                } else{
                    result = false;
                    return result;
                }
            }
        }

        if(stack.size() == 0){
            result = true;
        }

        return result;
    }
    boolean solution(String s) {
        boolean answer = true;

        if(s.length() % 2 != 0){
            answer = false;
            return false;
        }

        answer = isRightParenthesis(s);

        return answer;
    }
}