package 카카오_1차캐시;

import java.util.LinkedHashSet;
import java.util.Set;

class Solution {
    public int solution(int cacheSize, String[] cities) {
        int answer = 0;
        final int HIT = 1;
        final int PASS = 5;

        Set<String> hashSet = new LinkedHashSet<String>(cacheSize);

        for (String city : cities) {
            // 대소문자 구분 안하므로
            String c = city.toLowerCase();

            if (hashSet.isEmpty()) {
                hashSet.add(c);
                answer += PASS;
            } else {
                // 가장 오래 참조되지 않은 값을 제거
                if (cacheSize < hashSet.size()) {
                    hashSet.remove(hashSet.stream().findFirst().get());
                }
                //hit (hit하면 맨 뒤로 보내줘서 최신으로 만든다)
                if (hashSet.contains(c)) {
                    hashSet.remove(c);
                    hashSet.add(c);
                    answer += HIT;
                }
                //pass
                else {
                    hashSet.add(c);
                    answer += PASS;
                }
            }
        }
        return answer;
    }
}