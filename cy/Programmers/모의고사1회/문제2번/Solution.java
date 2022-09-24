package Programmers.모의고사1회.문제2번;

import java.util.*;

class Solution {

    public int solution(String[] want, int[] number, String[] discount) {
        int answer = 0;
        boolean join = false;
        int day = 0;

        // 회원 할인 10 + 날 마다 증가 < 총 세일 기간일
        while(10 + day < discount.length + 1){
            join = false;

            for(int i=0; i < want.length; i++){
                // 현재 찾는 물건
                String buy = want[i];
                // 찾는 물건 목표 갯수
                int howMany = number[i];

                int count = 0;

                for(int k=0; k < 10; k++){
                    // 찾는 물건 세일 품목에 있는 count 증가
                    if(buy.equals(discount[k+day])){
                        count++;
                    }
                }
                // count가 찾는 물건 목표 갯수 도달 못하면 day 증가
                if(count != howMany){
                    break;
                }

                // 마지막으로 찾는 물건까지 목표 갯수 찾으면 가입 가능
                if(i == want.length -1){
                    answer++;
                }
            }

            day++;
        }
        return answer;
    }
}