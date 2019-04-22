package array;

/**
 * @Author: xck
 * @File: MyCircularQueue
 * @Time: 17:31 2019/4/22
 */
public class MyCircularQueue {
    private int head;
    private int tail;
    private int[] values;

    /**
     * Initialize your data structure here. Set the size of the queue to be k.
     */
    public MyCircularQueue(int k) {
        head = -1;
        tail = -1;
        values = new int[k];
    }

    /**
     * Insert an element into the circular queue. Return true if the operation is successful.
     */
    public boolean enQueue(int value) {
        if (head == -1 && tail == -1) {
            head = 0;
            tail = 0;
            values[tail] = value;
            return true;
        }
        if (!isFull()) {
            tail = ++tail % values.length;
            values[tail] = value;
            return true;
        } else
            return false;
    }

    /**
     * Delete an element from the circular queue. Return true if the operation is successful.
     */
    public boolean deQueue() {
        if (isEmpty()) return false;
        if (head != tail) {
            values[head] = 0;
            head++;
        } else {
            values[head] = 0;
            head = -1;
            tail = -1;
        }
        return true;
    }

    /**
     * Get the front item from the queue.
     */
    public int Front() {
        if (!isEmpty()) {
            int tmp = values[head];
            return tmp;
        } else
            return -1;
    }

    /**
     * Get the last item from the queue.
     */
    public int Rear() {
        if (!isEmpty()) {
            int tmp = values[tail];
            return tmp;
        } else
            return -1;

    }

    /**
     * Checks whether the circular queue is empty or not.
     */
    public boolean isEmpty() {
        return head == -1 && tail == -1;
    }

    /**
     * Checks whether the circular queue is full or not.
     */
    public boolean isFull() {
        return (tail + 1) % values.length == head;
    }

    public static void main(String[] args) {
        MyCircularQueue circularQueue = new MyCircularQueue(3); // set the size to be 3
        circularQueue.enQueue(1);  // return true
        circularQueue.enQueue(2);  // return true
        circularQueue.enQueue(3);  // return true
        System.out.println(circularQueue.enQueue(4));
        System.out.println(circularQueue.Rear());
        circularQueue.deQueue();  // return true
        circularQueue.enQueue(4);  // return true
        System.out.println(circularQueue.Rear());
    }
}
