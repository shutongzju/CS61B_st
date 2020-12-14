public class ArrayDeque<T> implements Deque<T> {
    private T[] array;
    private double ratio;
    private int size;
    private int front;
    private int rear;

    public ArrayDeque() {
        array = (T[]) new Object[8];
        size = 0;
        ratio = (double) size / array.length;
        front = 0;
        rear = 0;
    }

//    public arrayDeque(T item) {
//        array = (T[]) new Object[8];
//        array[0] = item;
//        size = 1;
//        ratio = (double) size / array.length;
//        front = 0;
//        rear = 0;
//    }
//
//    public arrayDeque(arrayDeque other) {
//        size = other.size;
//        front = other.front;
//        rear = other.rear;
//        array = (T[]) new Object[other.array.length];
//        System.arraycopy(other, 0, array, 0, array.length);
//        ratio = (double) size / array.length;
//    }

    private void resizearray(int length) {
        T[] temp = (T[]) new Object[length];
        if (front < rear) {
            System.arraycopy(array, front, temp, 0, size);
            front = 0;
            rear = size - 1;
        } else {
            System.arraycopy(array, front, temp, 0, size - front);
            System.arraycopy(array, 0, temp, size - front, rear + 1);
            front = 0;
            rear = size - 1;
        }
        ratio = (double) size / length;
        array = temp;
    }

    @Override
    public void addFirst(T item) {
        if (size == array.length) {
            resizearray(size * 2);
        }
        if (size == 0) {
            rear = front;
            array[front] = item;
            size++;
            ratio = (double) size / array.length;
            return;
        }
        front = (front - 1 + array.length) % array.length;
        array[front] = item;
        size++;
        ratio = (double) size / array.length;
    }

    @Override
    public void addLast(T item) {
        if (size == array.length) {
            resizearray(size * 2);
        }
        if (size == 0) {
            front = rear;
            array[rear] = item;
            size++;
            ratio = (double) size / array.length;
            return;
        }
        rear = (rear + 1) % array.length;
        array[rear] = item;
        size++;
        ratio = (double) size / array.length;
    }

    @Override
    public boolean isEmpty() {
        if (size == 0) {
            return true;
        }
        return false;
    }

    @Override
    public int size() {
        return size;
    }

    public void printDeque() {
        if (front < rear) {
            for (int i = 0; i < size; i++) {
                System.out.println(array[i] + " ");
            }
        } else {
            for (int i = front; i < size; i++) {
                System.out.println(array[i] + " ");
            }
            for (int i = 0; i <= rear; i++) {
                System.out.println(array[i] + " ");
            }
        }
    }

    @Override
    public T removeFirst() {
        if (size == 0) {
            return null;
        }
        T temp = array[front];
        front = (front + 1) % array.length;
        size--;
        ratio = (double) size / array.length;
        if (ratio < 0.25 && array.length >= 16) {
            resizearray(array.length / 2);
        }
        return temp;
    }

    @Override
    public T removeLast() {
        if (size == 0) {
            return null;
        }
        T temp = array[rear];
        rear = (rear - 1 + array.length) % array.length;
        size--;
        ratio = (double) size / array.length;
        if (ratio < 0.25 && array.length >= 16) {
            resizearray(array.length / 2);
        }
        return temp;
    }

    @Override
    public T get(int index) {
        if (index >= size) {
            return null;
        }
        return array[(front + index) % array.length];
    }



}
