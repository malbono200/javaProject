package exam.heap;

import java.util.Arrays;

public class HeapMain {

	public static void main(String[] args) {
		Heap<Integer> heap = new Heap<>();

		Integer[] data = {2, 4, 5, 7, 3, 10, 8, 1, 9, 6};

		heap.sort(data);
		
		System.out.println("최종 결과 반환: " + Arrays.toString(data));
	}

}
