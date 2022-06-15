import java.util.*;

/*
백준 4949번 균형잡힌 세상
분류 : stack
직접 스택 구현해서 풀기
* */


public class BOJ4949_2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            String str = scanner.nextLine();
            Stack stack = new Stack();
            if (str.equals("."))
                break;

            for (int i = 0; i < str.length(); i++) {
                if (str.charAt(i) == '[' || str.charAt(i) == ']' || str.charAt(i) == '(' || str.charAt(i) == ')') {
                    if ((!stack.isEmpty() && stack.peek() == '[' && str.charAt(i) == ']') || (!stack.isEmpty() && stack.peek() == '(' && str.charAt(i) == ')')) {
                        stack.pop();
                    } else {
                        stack.push(str.charAt(i));
                    }
                }
            }
            System.out.println(stack.isEmpty() ? "yes" : "no");
        }
    }

    private static class Stack {
        private List<Character> elements;
        private int elementSize;

        public Stack() {
            this.elements = new ArrayList<>();
            this.elementSize = 0;
        }

        public void push(char element) {
            elements.add(element);
            elementSize++;
        }

        public void pop() {
            if (isEmpty()) {
                throw new EmptyStackException();
            }

            elements.remove(elementSize - 1);
            elementSize--;
        }

        public char peek() {
            if (isEmpty()) {
                throw new EmptyStackException();
            }

            return elements.get(elementSize - 1);
        }

        public boolean isEmpty() {
            return elementSize == 0;
        }


    }
}
