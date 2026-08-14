package datastructure.queue.generic;

import java.util.NoSuchElementException;

public class MyQueueMoveGeneric <E> {
	private int queueSize;
    private int front;
    private int rear;
    private int num;
    private Object[] queue;

    public MyQueueMoveGeneric(int queueSize) {
        this.front = this.rear = -1;
        this.num = 0;
        this.queueSize = queueSize;
        this.queue = new Object[queueSize];
    }

    public boolean isEmpty() {
        if(front == rear) {
            front = rear = -1;
        }
        return front == rear;
    }

    public boolean isFull() {
        return (rear == queueSize - 1 && num == queueSize);
    }

    public void enqueue(E item) {
        if(isFull()) {
            System.out.println("enqueue 실패! Queue Full!");
        } else if(rear == queueSize - 1 && num != 0) {
            System.arraycopy(queue, front + 1, queue, 0, num);
            System.out.println("큐 이동 발생");
            front = -1;
            rear = num - 1;
            queue[++rear] = item;
            num++;
        } else {
            queue[++rear] = item;
            num++;
        }
    }

    public E dequeue() {
        if(isEmpty()) {
            System.out.println("큐 비었습니다");
            throw new NoSuchElementException();
        } else {
            num--;
            front++;
            @SuppressWarnings("unchecked")
            E item = (E) queue[front];
            return item;
        }
    }

    public E peek() {
        if(isEmpty()) {
            System.out.println("peek 실패 Empty!");
            throw new NoSuchElementException();
        } else {
            @SuppressWarnings("unchecked")
            E item = (E) queue[front + 1];
            return item;
        }
    }

    public void clear() {
        front = rear = -1;
        num = 0;
        System.out.println("clear!");
    }

    public int size() {
        return num;
    }

    public void showQueue() {
        if(isEmpty()) {
            System.out.println("Queue Empty");
        } else {
            System.out.print("Queue items : ");
            for(int i = front + 1; i <= rear; i++) {
                System.out.print(i + ":" + queue[i] + " ");
            }
            System.out.println();
        }
    }

    public int contains(E item) {
        if (isEmpty()) {
            return -1;
        } else {
            for (int i = front + 1; i <= rear; i++) {
                if (queue[i].equals(item)) {
                    return i;
                }
            }
        }
        return -1;
    }
}
