package Programmers.모의고사1회.문제1번;

import java.util.*;

class Solution_2 {

    public String solution(String X, String Y) {
        String answer = "";

        ArrayList<String> list = new ArrayList<>();

        for(int i=0; i < X.length(); i++){
            // Y에 있으면
            char c = X.charAt(i);

            if(Y.indexOf(c) != -1){
                Y = Y.replaceFirst(Character.toString(c), "");
                list.add(Character.toString(c));
            }
        }
        Collections.sort(list, Collections.reverseOrder());

        if(list.size() > 0){
            for(String s : list){
                answer += s;
            }
        } else{
            answer = "-1";
        }

        return String.valueOf(Integer.parseInt(answer));
    }
}
