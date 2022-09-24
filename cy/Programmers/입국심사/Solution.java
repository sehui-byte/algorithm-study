package Programmers.입국심사;

<<<<<<< HEAD
public class Solution {
=======
class Solution {
>>>>>>> fa099487947f51289eb3f66f64390c52c6b05ee2
    public long solution(int n, int[] times) {

        long answer = Long.MAX_VALUE;
        long max = 0;
        long min = 0;
        long mid;

        for(int time : times){
            if(max < time){
                max = time;
            }
        }

        max *= n;

        while(min <= max){
            mid = (min + max) / 2;
            long cnt = 0;

            for (int time : times) {
                cnt += mid / time;
            }

            if(cnt < n){
                min = mid + 1;
            } else {
                if (mid < answer) {
                    answer = mid;
                }
                max = mid - 1;
            }
        }
<<<<<<< HEAD
        return answer;
    }
}
=======

        return answer;
    }
}
>>>>>>> fa099487947f51289eb3f66f64390c52c6b05ee2
