import java.util.Arrays;
import java.util.ArrayList;
import java.util.List;
import java.util.HashSet;
import java.util.Collections;

class Solution {
    public String solution(String X, String Y) {
        String answer = "";

        String[] arrX = X.split(""); // [1, 0, 0] 

        String[] arrY = Y.split(""); // [2, 3, 4, 5]

        //System.out.println(Arrays.toString(arrX));
        //System.out.println(Arrays.toString(arrY));

        HashSet<String> s1 = new HashSet<>(Arrays.asList(arrX));
        HashSet<String> s2 = new HashSet<>(Arrays.asList(arrY));

        HashSet<String> intersection = new HashSet<> (s1);  // s1으로 intersection 생성
        intersection.retainAll(s2);  // 교집합 수행 
        //System.out.println(intersection); 테스트 케이스 3 : [0, 1]

        if(intersection.isEmpty()){
            System.out.println("일치하는거 없음.");
            return "-1";
        }
        // Arrays.sort(intersection, Collections.reverseOrder()); // 내림차순 : 해시셋이라 정렬 그냥 안됨.
        List value = new ArrayList(intersection);
        // List 내림차순...
        Collections.sort(value, Collections.reverseOrder());

        System.out.println((value.toString()));
        String joinString = String.join("", value);

        // System.out.println((joinString.toString()));

        answer = joinString.toString();
        // 그냥 어레이 비교로 하면 에러남..
        //arrX.retainAll(arrY);
        //System.out.println(arrX.toString());

        return answer;
    }
}
