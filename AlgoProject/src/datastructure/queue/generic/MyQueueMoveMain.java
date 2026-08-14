package datastructure.queue.generic;

public class MyQueueMoveMain {

	public static void main(String[] args) {
		int queueSize = 3;
		MyQueueMoveGeneric<String> q = new MyQueueMoveGeneric<>(queueSize);

		q.showQueue();
		System.out.println("데이터 수 : "+ q.size());
		
		System.out.println("\na,b,c 삽입 수행");
		q.enqueue("a");
		q.enqueue("b");
		q.enqueue("c");
		q.showQueue();
		System.out.println("데이터 수 : "+ q.size());
		
		System.out.println("\ndeque 수행");
		System.out.println("\n반환(삭제)된 값 : " + q.dequeue());
		System.out.println("\n반환(삭제)된 값 : " + q.dequeue());
		q.showQueue();
		System.out.println("데이터 수 : " + q.size());
		
		System.out.println("\nd enqueue 수행");
		q.enqueue("d");
		q.showQueue();
	}

}
