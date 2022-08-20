package Programmers.모의고사1회.문제4번;

class Solution {

    public int[][] switchColumn(int[][] beginning, int row){

        for(int i=0; i < beginning.length; i++){
            int value = beginning[i][row];
            beginning[i][row] = (value + 1) % 2;
        }

        return beginning;
    }

    public int[][] switchRow(int[][] beginning, int col){

        for(int i=0; i < beginning.length; i++){
            int value = beginning[col][i];
            beginning[col][i] = (value + 1) % 2;
        }

        return beginning;
    }

    void print(int[][] beginning){

        int length = beginning.length;

        for (int i = 0; i <length; i++){
            for (int j = 0; j < length; j++){
                System.out.print(beginning[i][j] + " ");
            }
            System.out.println("");
        }
    }

    public int solution(int[][] beginning, int[][] target) {
        int answer = 0;

        int length = beginning.length;

        print(beginning);
        System.out.println("#########################");
        // col 변경 테스트
        print(switchColumn(beginning, 1));

        return answer;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();

        int beginning[][] = {{0, 1, 0, 0, 0}, {1, 0, 1, 0, 1}, {0, 1, 1, 1, 0}, {1, 0, 1, 1, 0}, {0, 1, 0, 1, 0}};
        int target[][] = {{0, 0, 0, 1, 1}, {0, 0, 0, 0, 1}, {0, 0, 1, 0, 1}, {0, 0, 0, 1, 0}, {0, 0, 0, 0, 1}};

        sol.solution(beginning, target);
    }
}