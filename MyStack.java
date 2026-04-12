public class MyStack<T> {
    private MyArrayList<T> data;

    public MyStack() {
        data = new MyArrayList<>();
    }

    public void push(T item) {
        data.addLast(item);
    }

    public T pop() {
        if (isEmpty()) {
            throw new RuntimeException("Stack is empty");
        }
        T value = data.getLast();
        data.removeLast();
        return value;
    }

    public T peek() {
        if (isEmpty()) {
            throw new RuntimeException("Stack is empty");
        }
        return data.getLast();
    }

    public boolean isEmpty() {
        return data.size() == 0;
    }

    public int size() {
        return data.size();
    }
}
