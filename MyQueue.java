public class MyQueue<T> {
    private MyLinkedList<T> data;

    public MyQueue() {
        data = new MyLinkedList<>();
    }

    public void enqueue(T item) {
        data.addLast(item);
    }

    public T dequeue() {
        if (isEmpty()) {
            throw new RuntimeException("Queue is empty");
        }
        T value = data.getFirst();
        data.removeFirst();
        return value;
    }

    public T peek() {
        if (isEmpty()) {
            throw new RuntimeException("Queue is empty");
        }
        return data.getFirst();
    }

    public boolean isEmpty() {
        return data.size() == 0;
    }

    public int size() {
        return data.size();
    }
}
