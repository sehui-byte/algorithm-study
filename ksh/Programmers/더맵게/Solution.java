package 더맵게;

import java.util.PriorityQueue;

public class Solution {
    public int solution(int[] scoville, int K) {
        int answer = 0;

        PriorityQueue<Integer> q = new PriorityQueue<>();
        for (int s : scoville) {
            q.offer(s);
        }

        while (q.peek() < K) {
            if (q.size() < 2) {
                return -1;
            }
            int first = q.poll();
            int second = q.poll();

            int mixed = first + (second * 2);
            q.offer(mixed);
            answer++;
        }
        return answer;
    }
}
