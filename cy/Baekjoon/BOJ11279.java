package Baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;

public class BOJ11279 {
    public static void main(String args[]) throws Exception{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuffer sb = new StringBuffer();

        PriorityQueue<Integer> queue = new PriorityQueue<>(Collections.reverseOrder());

        int count = Integer.parseInt(br.readLine());

        for(int i=0; i < count; i++) {

            int number = Integer.parseInt(br.readLine());

            if(number == 0){
                if(queue.size() == 0){
                    sb.append(0+"\n");
                } else{
                    sb.append(queue.poll()+"\n");
                }
            } else{
                queue.add(number);
            }
        }
        System.out.println(sb.toString()+"\n");
    }
}
