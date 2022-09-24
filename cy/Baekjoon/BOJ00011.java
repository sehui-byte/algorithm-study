package Baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.Stack;

public class BOJ00011 {
    public static void main(String args[]) throws Exception{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Scanner sc = new Scanner(System.in);

        StringBuffer sb = new StringBuffer();

        while (true) {
            Stack<Character> stack =  new Stack<>();
            // 엔터 기준으로 받는 글자
            // String s = br.readLine();
            String s = "";

            while(true){
                s += sc.next();

                if(s.indexOf(".") != -1){
                    break;
                }
            }
            // 문제 조건이 "."값을 받으면 종료
            if (".".equals(s)) {
                break;
            }

            // 글자 하나씩 읽고, Stack add하기
            for (int i = 0; i < s.length(); i++) {
                Character c = s.charAt(i);

                if ('(' == c) {
                    stack.add(c);
                } else if (')' == c) {
                    stack.add(c);
                } else if ('[' == c) {
                    stack.add(c);
                } else if (']' == c) {
                    stack.add(c);
                }
            }
            // 괄호 없는 글
            if(stack.isEmpty()){
                sb.append("yes\n");
                continue;
            }
            // 스택 size가 홀수면 false
            if(stack.size() % 2 == 1){
                sb.append("no\n");
                continue;
            }
            // 끝에 ( 나 [ 로 끝나면 false
            if(stack.peek() == '(' || stack.peek() == '['){
                sb.append("no\n");
                continue;
            }

            Stack<Character> checkStack = new Stack<>();

            while(!stack.isEmpty()) {
                char curr = stack.pop();
                if(checkStack.isEmpty()){
                    checkStack.add(curr);
                    continue;
                }

                if(curr == ')' || curr == ']'){
                    checkStack.add(curr);
                } else if(curr == '('){
                    if(checkStack.peek() == ')'){
                        checkStack.pop();
                    } else {
                        sb.append("no\n");
                        continue;
                    }
                } else if(curr == '['){
                    if(checkStack.peek() == ']'){
                        checkStack.pop();
                    } else {
                        sb.append("no\n");
                        continue;
                    }
                }
            }
            if(checkStack.isEmpty()){
                sb.append("yes\n");
            }
        }
        System.out.println(sb.toString());
    }
}
