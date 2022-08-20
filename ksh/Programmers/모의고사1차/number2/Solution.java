package 모의고사1차.number2;

import java.util.Arrays;
import java.util.HashMap;

class Solution {
    public static int solution(String[] want, int[] number, String[] discount) {
        int answer = 0;

        // i는 가입할 날
        for (int i = 0; i < 5; i++) {
            System.out.println(" ===================" + (i+1) + "일차 ===============");
            boolean satisfy = false;
            // 가입한 날부터 10일간 내가 바라는것들과 일치하는지 체크
            String[] tenDays = Arrays.copyOfRange(discount, i, i + 10);
            for(String tenDay : tenDays) {
                System.out.print(tenDay + ", ");
            }
            /* tenDays를 hashMap으로 바꾼다
            그리고 tenDays에서 그 상품 개수랑 number랑 개수 비교하면 되지 않나?
            * */
            HashMap<String, Integer> discountMap = new HashMap<String, Integer>();
            for (int j = 0; j < 10; j++) {
                discountMap.put(tenDays[j], discountMap.getOrDefault(tenDays[j], 0) + 1);
            }

            for (int k = 0; k < want.length; k++) {
                System.out.println("내가 원하는 수량 : " + want[k] + " " + number[k] + " , 할인중 상품 개수 : " + discountMap.get(want[k]));
                // 원하는 상품이 아예 없거나 개수가 적을때
                if (discountMap.get(want[k]) == null || discountMap.get(want[k]) < number[k]) {
                    satisfy = false;
                    break;
                }

                satisfy = true;
            }
            if (satisfy) {
                answer = i + 1;
                break;
            }
        }
        return answer;
    }


    public static void main(String[] args) {
        //
        String[] want = {"banana", "apple", "rice", "pork", "pot"};
        int[] number = {3, 2, 2, 2, 1};
        String[] discount = {"chicken", "apple", "apple", "banana", "rice",
                "apple", "pork", "banana", "pork", "rice", "pot", "banana",
                "apple", "banana"};
        System.out.println(solution(want, number, discount));
    }

}