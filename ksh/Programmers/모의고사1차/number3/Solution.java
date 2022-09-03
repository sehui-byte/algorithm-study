package 모의고사1차.number3;

import java.util.*;

class Solution {
    public static int solution(int[] order) {
        int answer = 0;
        Stack<Integer> supportBelt = new Stack<Integer>();
        Stack<Integer> mainBelt = new Stack<Integer>();

        for (int i = 5; i>0; i--) {
            mainBelt.add(i);
        }

        int orderIdx = 0;
        while (true) {
            if(orderIdx == order.length) {
                break;
            }

            int element = order[orderIdx];

            // 메인벨트에 더이상 찾는 것이 없다면 종료
            if (!mainBelt.contains(element) && !supportBelt.isEmpty() && supportBelt.peek() != element) {
                break;
            }



            // 메인 컨테이너벨트에 원하는 상품이 있으면 꺼낸다
            if (!mainBelt.isEmpty() && mainBelt.peek() == element) {
                mainBelt.pop();
                orderIdx++;
                answer++;
            } else {
                // 메인 컨테이너에 찾는게 없을 경우 보조벨트에서 찾는다
                if (!supportBelt.isEmpty() && supportBelt.peek() == element) {
                    supportBelt.pop();
                    answer++;
                    orderIdx++;
                } else { //보조벨트에도 없으면 보조벨트로 메인벨트에 있는걸 옮긴다
                    supportBelt.push(mainBelt.peek());
                    mainBelt.pop();
                }
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        //
//        int[] order = {4, 3, 1, 2, 5};
//        System.out.println(solution(order));

        int[] order2 = {5,4,3,2,1};
        System.out.println(solution(order2));
    }
}