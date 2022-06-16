package choi.Programmers.june02;

import java.util.PriorityQueue;

class Solution {
    public int solution(int[] scoville, int K) {
        int answer = 0;

        PriorityQueue<Integer> queue = new PriorityQueue<>();

        for(int i : scoville){
            queue.add(i);
        }

        while(true) {

            int first = queue.poll();

            if(first >= K){
                return answer;
            }

            if(queue.size() == 0){
                return -1;
            }

            int second = queue.poll();

            queue.add(first + second * 2);
            answer++;
        }
    }
}
