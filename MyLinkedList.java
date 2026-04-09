import java.util.Iterator;

public class MyLinkedList<T> implements MyList<T> {
    private class MyNode {
        T data;
        MyNode next;
        MyNode prev;

        MyNode(T data) {
            this.data = data;
        }
    }

    private MyNode head;
    private MyNode tail;
    private int size;

    public MyLinkedList() {
        head = null;
        tail = null;
        size = 0;
    }

    private void checkIndex(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Wrong index: " + index);
        }
    }

    private void checkIndexForAdd(int index) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("Wrong index: " + index);
        }
    }

    private boolean same(Object a, Object b) {
        if (a == null && b == null) {
            return true;
        }
        if (a == null || b == null) {
            return false;
        }
        return a.equals(b);
    }

    private MyNode getNode(int index) {
        checkIndex(index);
        MyNode current;
        if (index < size / 2) {
            current = head;
            for (int i = 0; i < index; i++) {
                current = current.next;
            }
        } else {
            current = tail;
            for (int i = size - 1; i > index; i--) {
                current = current.prev;
            }
        }
        return current;
    }

    private void fixBorders() {
        if (head != null) {
            head.prev = null;
        }
        if (tail != null) {
            tail.next = null;
        }
    }

    @Override
    public void add(T item) {
        addLast(item);
    }

    @Override
    public void set(int index, T item) {
        getNode(index).data = item;
    }

    @Override
    public void add(int index, T item) {
        checkIndexForAdd(index);
        if (index == 0) {
            addFirst(item);
            return;
        }
        if (index == size) {
            addLast(item);
            return;
        }

        MyNode nextNode = getNode(index);
        MyNode prevNode = nextNode.prev;
        MyNode newNode = new MyNode(item);

        newNode.prev = prevNode;
        newNode.next = nextNode;
        prevNode.next = newNode;
        nextNode.prev = newNode;
        size++;
        fixBorders();
    }

    @Override
    public void addFirst(T item) {
        MyNode newNode = new MyNode(item);
        if (size == 0) {
            head = newNode;
            tail = newNode;
        } else {
            newNode.next = head;
            head.prev = newNode;
            head = newNode;
        }
        size++;
        fixBorders();
    }

    @Override
    public void addLast(T item) {
        MyNode newNode = new MyNode(item);
        if (size == 0) {
            head = newNode;
            tail = newNode;
        } else {
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
        }
        size++;
        fixBorders();
    }

    @Override
    public T get(int index) {
        return getNode(index).data;
    }

    @Override
    public T getFirst() {
        if (size == 0) {
            throw new RuntimeException("List is empty");
        }
        return head.data;
    }

    @Override
    public T getLast() {
        if (size == 0) {
            throw new RuntimeException("List is empty");
        }
        return tail.data;
    }

    @Override
    public void remove(int index) {
        checkIndex(index);
        if (index == 0) {
            removeFirst();
            return;
        }
        if (index == size - 1) {
            removeLast();
            return;
        }

        MyNode current = getNode(index);
        MyNode prevNode = current.prev;
        MyNode nextNode = current.next;

        prevNode.next = nextNode;
        nextNode.prev = prevNode;
        current.next = null;
        current.prev = null;
        size--;
        fixBorders();
    }

    @Override
    public void removeFirst() {
        if (size == 0) {
            throw new RuntimeException("List is empty");
        }
        if (size == 1) {
            head = null;
            tail = null;
        } else {
            head = head.next;
            head.prev.next = null;
            head.prev = null;
        }
        size--;
        fixBorders();
    }

    @Override
    public void removeLast() {
        if (size == 0) {
            throw new RuntimeException("List is empty");
        }
        if (size == 1) {
            head = null;
            tail = null;
        } else {
            tail = tail.prev;
            tail.next.prev = null;
            tail.next = null;
        }
        size--;
        fixBorders();
    }

    @Override
    @SuppressWarnings("unchecked")
    public void sort() {
        if (size < 2) {
            return;
        }
        for (int i = 0; i < size - 1; i++) {
            MyNode current = head;
            while (current != null && current.next != null) {
                Comparable<Object> left = (Comparable<Object>) current.data;
                Object right = current.next.data;
                if (left.compareTo(right) > 0) {
                    T temp = current.data;
                    current.data = current.next.data;
                    current.next.data = temp;
                }
                current = current.next;
            }
        }
    }

    @Override
    public int indexOf(Object object) {
        MyNode current = head;
        int index = 0;
        while (current != null) {
            if (same(current.data, object)) {
                return index;
            }
            current = current.next;
            index++;
        }
        return -1;
    }

    @Override
    public int lastIndexOf(Object object) {
        MyNode current = tail;
        int index = size - 1;
        while (current != null) {
            if (same(current.data, object)) {
                return index;
            }
            current = current.prev;
            index--;
        }
        return -1;
    }

    @Override
    public boolean exists(Object object) {
        return indexOf(object) != -1;
    }

    @Override
    public Object[] toArray() {
        Object[] result = new Object[size];
        MyNode current = head;
        int index = 0;
        while (current != null) {
            result[index] = current.data;
            current = current.next;
            index++;
        }
        return result;
    }

    @Override
    public void clear() {
        MyNode current = head;
        while (current != null) {
            MyNode next = current.next;
            current.next = null;
            current.prev = null;
            current = next;
        }
        head = null;
        tail = null;
        size = 0;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            private MyNode current = head;

            @Override
            public boolean hasNext() {
                return current != null;
            }

            @Override
            public T next() {
                T value = current.data;
                current = current.next;
                return value;
            }
        };
    }
}
