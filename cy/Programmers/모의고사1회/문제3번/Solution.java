package Programmers.모의고사1회.문제3번;

import java.util.*;

class Solution {
    public int solution(int[] order) {
        int answer = 0;

        Queue<Integer> queue = new LinkedList<Integer>();
        Stack<Integer> stack = new Stack<>();

        for(int i = 1; i <= order.length; i++){
            queue.add(i);
        }

        int i = 0;

        while(order.length > i){
            int box = order[i];

            if(!queue.isEmpty() && box == queue.peek()){
                answer++;
                i++;
                queue.poll();
            } else if(!stack.isEmpty() && box == stack.peek()){
                answer++;
                i++;
                stack.pop();
            } else if(!queue.isEmpty()) {
                stack.add(queue.poll());
            } else{
                break;
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();

        int answer = sol.solution(new int[]{5, 4, 3, 2, 1});

        System.out.println(answer);
    }
}
