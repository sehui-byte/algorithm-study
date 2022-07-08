package Baekjoon;

import java.util.*;
import java.io.*;

public class BOJ2805 {

    public static long M;
    public static int N;
    public static long [] tree;

    public static long cut(long mid) {
        long sum = 0;
        for(int i=0; i < N; i++) {
            if(tree[i]-mid>0)
                sum += tree[i]-mid;
        }
        return sum;
    }

    public static void main(String[] args) throws Exception{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer str = new StringTokenizer(br.readLine());


        N = Integer.parseInt(str.nextToken());
        M = Long.parseLong(str.nextToken());

        long ans =0;

        String [] s = br.readLine().split(" ");

        tree = new long[N];

        for(int i=0; i < N; i++) {
            tree[i] = Long.parseLong(s[i]);
        }

        Arrays.sort(tree);

        long start = 0;
        long end = tree[N-1];

        while(start<=end) {
            long mid = (start + end)/2;

            if(cut(mid)>=M) {
                ans = Math.max(ans, mid);
                start = mid+1;
            }
            else {
                end = mid-1;
            }
        }
        System.out.println(ans);
    }
}


