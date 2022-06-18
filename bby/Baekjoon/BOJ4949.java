package com.pantos.vms.biz.test;

import java.util.Scanner;
import java.util.Stack;

public class BOJ4949 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);	// 콘솔 입력

		String s = sc.nextLine();
		while (!s.equals(".")) {

			Stack<Character> st = new Stack<>();
			for (int i = 0; i < s.length(); i++) {
				if (s.charAt(i) == '(' || s.charAt(i) == '[') {	// ( 와 [ 를 넣어보자... 다른거 안 넣어줄거야,
					st.push(s.charAt(i));
				} else {
					if (s.charAt(i) == ')') {	// ) 로 들어가 대칭일때...
						if (!st.isEmpty() && st.peek() == '(')
							st.pop();
						else
							st.push(s.charAt(i));
					} else if (s.charAt(i) == ']') {
						if (!st.isEmpty() && st.peek() == '[')
							st.pop();
						else
							st.push(s.charAt(i));
					}

				}
			}
			if (st.isEmpty())
				System.out.println("yes");
			else
				System.out.println("no");
			s = sc.nextLine();
		}

	}
}
