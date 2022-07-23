import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Scanner;

public class BOJ11279 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int number = sc.nextInt();

		// 우선순위 큐 구조 활용 : 완전 이진트리의 최소힙 참조링크 : https://st-lab.tistory.com/205
		PriorityQueue<Integer> heap = new PriorityQueue<>(Collections.reverseOrder());	// 우선순위 큐는 기본적으로 최소-힙의 형태이므로 reverseOrder 로 역순 설정.

		for (int i = 0; i < number; i++) {
			int num = sc.nextInt();	//숫자 계속

			if (num == 0) {
				if (!heap.isEmpty()) {
					System.out.println(heap.poll());
				} else {
					System.out.println("0");
				}
			}
			heap.add(num);
		}
	}
}
