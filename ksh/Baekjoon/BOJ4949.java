import java.util.Stack;
import java.util.Scanner;

/*
백준 4949번 균형잡힌 세상
분류 : stack
* */

public class BOJ4949 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (true) {
            String str = sc.nextLine();
            Stack<Character> stack = new Stack<>();

            if (str.equals("."))
                break;

            for (int i = 0; i < str.length(); i++) {
                if (str.charAt(i) == '[' || str.charAt(i) == ']' || str.charAt(i) == '(' || str.charAt(i) == ')') {
                    if ((!stack.empty() && stack.peek() == '[' && str.charAt(i) == ']') || (!stack.empty() && stack.peek() == '(' && str.charAt(i) == ')')) {
                        stack.pop();
                    } else {
                        stack.push(str.charAt(i));
                    }
                }
            }
            System.out.println(stack.isEmpty() ? "yes" : "no");
        }
    }
}