package 모의고사1차.number1;

import java.util.*;

class Solution {
    public String solution(String X, String Y) {

        //공통 문자열 찾기
        char[] xArr = X.toCharArray();
        char[] yArr = Y.toCharArray();
        List<Character> commonList = new ArrayList<Character>();

        //Todo: 이 부분 반복문 2번 돌아서 시간초과 발생하는듯
//        for (char xChar : xArr) {
//            for (int i = 0; i < yArr.length; i++) {
//                //   System.out.println(new String(yArr));
//                if (xChar == yArr[i]) {
//                    yArr[i] = 'a';
//                    commonList.add(xChar);
//                    break;
//                }
//            }
//        }

        //Todo: 아래와 같이 반복문 1번으로 돌렸는데도 여전히 시간초과가 발생한다
        for (int i = 0; i<xArr.length; i++) {
            int yIdx = Y.indexOf(String.valueOf(xArr[i]));
            if (yIdx != -1) {
                // 공통 문자 찾은 후 다시 공통문자 찾지 않도록 알파벳으로 체크한다
                commonList.add(xArr[i]);
                xArr[i] = 'a';
                yArr[yIdx] = 'b';
//                Y = Arrays.toString(yArr); // 이거 잘못됨 [1,2,3,4] 이런식으로 됨
                Y = new String(yArr);
//                System.out.println("Y : " + Y);
            }
        }

        if (commonList.isEmpty()) {
            return "-1";
        }

        // 큰 수부터 정렬
        Collections.sort(commonList, Collections.reverseOrder());
//        commonList.sort(Collections.reverseOrder());
        // 0 제거하기
        if (commonList.get(0) == '0' && commonList.size() > 1) {
            return "0";
        }

        StringBuilder sb = new StringBuilder();
        for (Character c : commonList) {
            sb.append(c);
        }

        return sb.toString();
    }
}