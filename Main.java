public class Main {
    public static void main(String[] args) {
        testArrayList();
        System.out.println();
        testLinkedList();
        System.out.println();
        testStack();
        System.out.println();
        testQueue();
        System.out.println();
        testMinHeap();
    }

    private static void printArray(Object[] array) {
        System.out.print("[");
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i]);
            if (i != array.length - 1) {
                System.out.print(", ");
            }
        }
        System.out.println("]");
    }

    private static void testArrayList() {
        System.out.println("=== TEST MyArrayList ===");
        MyArrayList<Integer> list = new MyArrayList<>();

        list.add(10);
        list.add(20);
        list.addFirst(5);
        list.addLast(30);
        list.add(2, 15);
        printArray(list.toArray());

        System.out.println("get(2): " + list.get(2));
        System.out.println("getFirst(): " + list.getFirst());
        System.out.println("getLast(): " + list.getLast());

        list.set(1, 7);
        printArray(list.toArray());

        System.out.println("indexOf(15): " + list.indexOf(15));
        System.out.println("lastIndexOf(30): " + list.lastIndexOf(30));
        System.out.println("exists(20): " + list.exists(20));
        System.out.println("size(): " + list.size());

        list.remove(2);
        list.removeFirst();
        list.removeLast();
        printArray(list.toArray());

        list.add(50);
        list.add(1);
        list.add(9);
        list.sort();
        System.out.print("sorted: ");
        printArray(list.toArray());

        System.out.print("iterator: ");
        for (Integer x : list) {
            System.out.print(x + " ");
        }
        System.out.println();

        list.clear();
        System.out.println("size after clear: " + list.size());
    }

    private static void testLinkedList() {
        System.out.println("=== TEST MyLinkedList ===");
        MyLinkedList<String> list = new MyLinkedList<>();

        list.add("b");
        list.add("d");
        list.addFirst("a");
        list.addLast("e");
        list.add(2, "c");
        printArray(list.toArray());

        System.out.println("get(2): " + list.get(2));
        System.out.println("getFirst(): " + list.getFirst());
        System.out.println("getLast(): " + list.getLast());

        list.set(4, "f");
        printArray(list.toArray());

        System.out.println("indexOf(c): " + list.indexOf("c"));
        System.out.println("lastIndexOf(f): " + list.lastIndexOf("f"));
        System.out.println("exists(x): " + list.exists("x"));
        System.out.println("size(): " + list.size());

        list.remove(2);
        list.removeFirst();
        list.removeLast();
        printArray(list.toArray());

        list.add("z");
        list.add("m");
        list.add("k");
        list.sort();
        System.out.print("sorted: ");
        printArray(list.toArray());

        System.out.print("iterator: ");
        for (String s : list) {
            System.out.print(s + " ");
        }
        System.out.println();

        list.clear();
        System.out.println("size after clear: " + list.size());
    }

    private static void testStack() {
        System.out.println("=== TEST MyStack ===");
        MyStack<Integer> stack = new MyStack<>();

        stack.push(1);
        stack.push(2);
        stack.push(3);

        System.out.println("peek: " + stack.peek());
        System.out.println("pop: " + stack.pop());
        System.out.println("pop: " + stack.pop());
        System.out.println("size: " + stack.size());
        System.out.println("isEmpty: " + stack.isEmpty());
    }

    private static void testQueue() {
        System.out.println("=== TEST MyQueue ===");
        MyQueue<String> queue = new MyQueue<>();

        queue.enqueue("A");
        queue.enqueue("B");
        queue.enqueue("C");

        System.out.println("peek: " + queue.peek());
        System.out.println("dequeue: " + queue.dequeue());
        System.out.println("dequeue: " + queue.dequeue());
        System.out.println("size: " + queue.size());
        System.out.println("isEmpty: " + queue.isEmpty());
    }

    private static void testMinHeap() {
        System.out.println("=== TEST MyMinHeap ===");
        MyMinHeap<Integer> heap = new MyMinHeap<>();

        heap.insert(8);
        heap.insert(3);
        heap.insert(10);
        heap.insert(1);
        heap.insert(6);

        System.out.println("peekMin: " + heap.peekMin());
        System.out.println("extractMin: " + heap.extractMin());
        System.out.println("extractMin: " + heap.extractMin());
        System.out.println("peekMin after removes: " + heap.peekMin());
        System.out.println("size: " + heap.size());
        System.out.println("isEmpty: " + heap.isEmpty());
    }
}
