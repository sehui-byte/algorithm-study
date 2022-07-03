package 카카오_1차캐시;

import java.util.LinkedHashMap;
import java.util.Map;

// Todo: map으로 풀 필요 X -> Set으로 바꾸기
class Solution {
    public int solution(int cacheSize, String[] cities) {
        int answer = 0;

        Map<String, Integer> m = new LinkedHashMap<String, Integer>(cacheSize) {
            // cacheSize 초과시 오래된 entry 제거 (lease recently used)
            @Override
            protected boolean removeEldestEntry(Map.Entry eldest) {
                return size() > cacheSize;
            }
        };

        for (String city : cities) {
            // 대소문자 구분 안하므로
            String c = city.toLowerCase();

            if (m.isEmpty()) {
                m.put(c, m.getOrDefault(c, 0) + 1);
                answer += 5;
            } else {
                //hit (hit하면 맨 뒤로 보내줘서 최신으로 만든다)
                if (m.containsKey(c)) {
                    int value = m.get(c);
                    m.remove(c);
                    m.put(c, value + 1);
                    answer += 1;
                }
                //pass
                else {
                    m.put(c, m.getOrDefault(c, 0) + 1);
                    answer += 5;
                }
            }
        }
        return answer;
    }
}