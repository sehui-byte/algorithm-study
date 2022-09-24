import java.util.HashMap;
import java.util.Iterator;

class Solution {
    public int solution(String[][] clothes) {
        // 1. 옷을 종류별로 구분하기
        HashMap<String, Integer> map = new HashMap<>();
        
        // 순열과 조합 참조 링크 : https://m.blog.naver.com/galaxyenergy/221565884833
        // 문제는 6가지의 서로 다른 옷의 종류를 순서 상관 없이 입는다..
        // 서로 다른 n개중에 r개를 선택하는 경우의 수 : 서로 다른 3가지 중 2개를 선택하는 경우의 수
        // >> 3P2 : 3!/(3-2)! 이 되므로 3*2*1 이다.
        
        // 참고 자료 : https://coding-grandpa.tistory.com/entry/%ED%94%84%EB%A1%9C%EA%B7%B8%EB%9E%98%EB%A8%B8%EC%8A%A4-%EC%9C%84%EC%9E%A5-%ED%95%B4%EC%8B%9C-Lv-2-%EC%9E%90%EB%B0%94-Java
        for (String[] clothe : clothes) {
            // 옷을 입으면 1이 추가.
            String type = clothe[1];
            map.put(type, map.getOrDefault(type, 0) + 1);
        }

        // 2. 입지 않는 경우를 추가하여 모든 조합 계산하기
        Iterator<Integer> it = map.values().iterator();
        int answer = 1;
        
        while(it.hasNext())
            // 옷을 입었으면 값이 1이 들어가므로 키에 대한 밸류가 존재하면 1+
            answer *= it.next().intValue() + 1;

        // 3. 아무종류의 옷도 입지 않는 경우 제외하기
        return answer - 1;
    }
}
