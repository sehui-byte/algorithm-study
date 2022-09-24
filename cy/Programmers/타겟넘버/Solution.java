package Programmers.타겟넘버;

import java.util.*;

class Solution {
    public int solution(int[] numbers, int target) {

        int answer = 0;
        int length = numbers.length;

        Queue<State> queue = new LinkedList<>();

        queue.add(new State(numbers[0], 1));
        queue.add(new State(-numbers[0], 1));

        while(!queue.isEmpty()){
            State currentState = queue.poll();

            int number = currentState.number;
            int depth = currentState.depth;

            if(length == depth){
                if(target == number){
                    answer++;
                }

                // 더 더할 항목이 없음
                continue;
            }

            // 다음 숫자(+, -) 추가
            queue.add(new State(number+numbers[depth], depth+1));
            queue.add(new State(number-numbers[depth], depth+1));
        }

        return answer;
    }
}

class State {
    public int number;
    public int depth;

    public State(int number, int depth){
        this.number = number;
        this.depth = depth;
    }
}