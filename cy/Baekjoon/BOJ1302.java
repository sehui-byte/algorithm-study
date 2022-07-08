package Baekjoon;

import java.util.*;

public class BOJ1302 {
    public static void main(String args[]){

        Scanner sc = new Scanner(System.in);
        HashMap<String, Integer> map = new HashMap<>();

        int size = sc.nextInt();
        int maxFreq = 0;

        String key = "";
        String answer = "";

        for(int i=0; i < size; i++){
            key = sc.next();
            map.put(key, map.getOrDefault(key, 0)+1);
        }

        //  List<String> list = new ArrayList<>(map.keySet());
        // Collections.sort(list, (k1, k2) -> (map.get(k2).compareTo(map.get(k1))));
        // System.out.println("a".compareTo("b")); // -1

        for(String s : map.keySet()){
            int currValue = map.get(s);
            // 빈도 수 더 높으면
            if(currValue > maxFreq){
                maxFreq = currValue;
                answer = s;
            // 빈도 수가 같으면 문자열 비교
            } else if(currValue == maxFreq){
                if(s.compareTo(answer) < 0){
                    answer = s;
                }
            }
        }
        System.out.println(answer);
    }
}
