package Programmers.모의고사1회.문제1번;

class Solution {
    public String solution(String X, String Y) {
        String answer = "";

        int[] numbers = new int[10];

        String S = "";
        String L = "";

        if(X.length() > Y.length()){
            L = X;
            S = Y;
        } else {
            S = X;
            L = Y;
        }

        for(int i=0; i < S.length(); i++){
            if(L.indexOf(S.charAt(i)) != -1){

                int index = Character.getNumericValue(S.charAt(i));

                numbers[index] = numbers[index]+1;
                L = L.replaceFirst(String.valueOf(index), "");
            }
        }

        for(int i=9; i >= 0; i--){
            if(numbers[i] != 0){
                for(int j=0; j < numbers[i]; j++){
                    answer = answer + i;
                }
            }
        }

        if(answer.length() == 0){
            answer = "-1";
        }
        // System.out.println(Long.MAX_VALUE);
        if(answer.startsWith("0")){
            answer = "0";
        }
        return answer;
    }

    public static void main(String args[]){
        Solution sol = new Solution();
        String answer = sol.solution("9999999999999999999999999999999", "99999999999999999999999999999999999999");
        System.out.println(answer);
    }
}
