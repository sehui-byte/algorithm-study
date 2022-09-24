package Programmers.완주하지못한선수;

import java.util.Arrays;

class Solution {
    public String solution(String[] participant, String[] completion) {
        String answer = "";
        Arrays.sort(participant);
        Arrays.sort(completion);

        for(int i=0; i < participant.length; i++){
            try {
                if(!participant[i].equals(completion[i])){
                    return participant[i];
                }
            } catch (Exception e){
                return participant[i];
            }

        }
        return answer;
    }
}
