# Assignment 2 - ArrayList and LinkedList

This project contains my own implementations of:
- `MyArrayList`
- `MyLinkedList` (doubly linked list)
- `MyStack`
- `MyQueue`
- `MyMinHeap`

## Rules from task
- I did not use `java.util.*` except `Iterator`
- `MyArrayList` and `MyLinkedList` implement `MyList<T>`
- `MyStack`, `MyQueue`, `MyMinHeap` are based on previously implemented structures

## Project files
- `MyList.java` - interface
- `MyArrayList.java` - array list implementation
- `MyLinkedList.java` - doubly linked list implementation
- `MyStack.java` - stack based on `MyArrayList`
- `MyQueue.java` - queue based on `MyLinkedList`
- `MyMinHeap.java` - min heap based on `MyArrayList`
- `Main.java` - testing all classes

## How to run
```bash
javac *.java
java Main
```

## Notes
- `sort()` works for elements that implement `Comparable`
- In linked list I tried to prevent loops by always updating `head.prev = null` and `tail.next = null`
- The code is written simply, like a first-year student project
