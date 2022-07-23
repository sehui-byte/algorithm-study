import java.util.Arrays;

class Solution {
    public long solution(int n, int[] times) {
        
        long answer = 0;
        
        // 걸리는 시간
        Arrays.sort(times);
        
        // 걸리는 시간의 최소와 최대를 이분탐색의 left, right로 설정
        long left = 0;
        long right = (long) n * times[times.length - 1]; //가장 최악의 경우의(오래걸리는) 시간
        
        //이분탐색 시간(mid)을 사용하여 각 심사위원들이 몇명을 처리할 수 있는지 합산해줌.
        
        // 문제에서 동일하게 인원 심사를 한 N 분을 중복 Key 로 생각하기.
        // 이분 탐색 자료 링크 : https://cjh5414.github.io/binary-search/
        while (left <= right) {
            long mid = (left + right) / 2;
            long sum = 0; // 총 심사한 인원
            for (int i = 0; i < times.length; i++) { //빨리 심사하는 심사관 순으로 심사처리
                sum += mid / times[i];
            }
            if (sum < n) { // 해야할 인원보다 심사처리 못함 -> 시간 더 필요 >> 최소의 N 분을 찾는데 상한 검색을해서 최적의 시간보다 낮으면 +1 로 시간을 재 탐색.
                left = mid + 1;
            } else { // 해야할 인원보다 심사처리 많이함 -> 시간을 줄여서 최소의 N 분을 찾는데 하한 검색을해서 최적의 시간보다 높으면 -1 로 시간을 재 탐색.
                right = mid - 1;
                answer = mid;
            }
        }
        return answer;
    }
}
