package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class BOJ4949 {

    private void checkStackSize(Stack<Character> stack){

    }

    public static void main(String args[]) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringBuffer sb = new StringBuffer();

        while(true) {
            Stack<Character> stack =  new Stack<>();
            // 엔터 기준으로 받는 글자
            String s = br.readLine();

            if(".".equals(s)) break;

            // 문제 조건이 "."값을 받으면 종료
            for(int i=0; i < s.length(); i++){

                char c = s.charAt(i);

                if(c == '.'){
                    break;
                }

                if(c == '(' || c == '['){
                    stack.add(c);
                } else if(c == ')'){
                    if(stack.size() == 0 || stack.peek() != '('){
                        stack.add(c);
                        break;
                    } else{
                        stack.pop();
                    }
                } else if(c == ']'){
                    if(stack.size() == 0 || stack.peek() != '['){
                        stack.add(c);
                        break;
                    } else{
                        stack.pop();
                    }
                }
            }
            if(stack.size() > 0){
                sb.append("no\n");
            } else{
                sb.append("yes\n");
            }
        }

        System.out.println(sb.toString());
    }
}
