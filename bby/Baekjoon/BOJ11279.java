import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Scanner;

public class BOJ11279 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int number = sc.nextInt();

		PriorityQueue<Integer> heap = new PriorityQueue<>(Collections.reverseOrder());

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
