public class MyMinHeap<T extends Comparable<T>> {
    private MyArrayList<T> heap;

    public MyMinHeap() {
        heap = new MyArrayList<>();
    }

    public void insert(T item) {
        heap.addLast(item);
        siftUp(heap.size() - 1);
    }

    public T peekMin() {
        if (isEmpty()) {
            throw new RuntimeException("Heap is empty");
        }
        return heap.get(0);
    }

    public T extractMin() {
        if (isEmpty()) {
            throw new RuntimeException("Heap is empty");
        }

        T min = heap.get(0);
        T last = heap.getLast();
        heap.removeLast();

        if (!heapExistsAfterRemove()) {
            return min;
        }

        heap.set(0, last);
        siftDown(0);
        return min;
    }

    private boolean heapExistsAfterRemove() {
        return heap.size() > 0;
    }

    private void siftUp(int index) {
        while (index > 0) {
            int parent = (index - 1) / 2;
            if (heap.get(index).compareTo(heap.get(parent)) < 0) {
                swap(index, parent);
                index = parent;
            } else {
                break;
            }
        }
    }

    private void siftDown(int index) {
        while (true) {
            int left = index * 2 + 1;
            int right = index * 2 + 2;
            int smallest = index;

            if (left < heap.size() && heap.get(left).compareTo(heap.get(smallest)) < 0) {
                smallest = left;
            }
            if (right < heap.size() && heap.get(right).compareTo(heap.get(smallest)) < 0) {
                smallest = right;
            }

            if (smallest != index) {
                swap(index, smallest);
                index = smallest;
            } else {
                break;
            }
        }
    }

    private void swap(int i, int j) {
        T temp = heap.get(i);
        heap.set(i, heap.get(j));
        heap.set(j, temp);
    }

    public boolean isEmpty() {
        return heap.size() == 0;
    }

    public int size() {
        return heap.size();
    }
}
