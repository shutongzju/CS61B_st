public class ArrayDeque<Generic> {
    private Generic[] Array;
    private double ratio;
    private int size;
    private int front;
    private int rear;

    public ArrayDeque() {
        Array = (Generic[]) new Object[8];
        size = 0;
        ratio = (double) size / Array.length;
        front = 0;
        rear = 0;
    }

    public ArrayDeque(Generic item) {
        Array = (Generic[]) new Object[8];
        Array[0] = item;
        size = 1;
        ratio = (double) size / Array.length;
        front = 0;
        rear = 0;
    }

    public ArrayDeque(ArrayDeque other) {
        size = other.size;
        front = other.front;
        rear = other.rear;
        Array = (Generic[]) new Object[other.Array.length];
        System.arraycopy(other, 0, Array, 0, Array.length);
        ratio = (double) size / Array.length;
    }

    private void resizeArray(int length) {
        Generic[] temp = (Generic[]) new Object[length];
        if (front < rear) {
            System.arraycopy(this, 0, temp, 0, size);
        } else {
            System.arraycopy(this, front, temp, 0, size - front);
            System.arraycopy(this, 0, temp, size - front, rear + 1);
            front = 0;
            rear = size - 1;
        }
        ratio = (double) size / length;
        Array = temp;
    }

    public void addFirst(Generic item) {
        if (size == Array.length) {
            resizeArray(size * 2);
        }
        front = (front - 1 + Array.length) % Array.length;
        Array[front] = item;
        size++;
        ratio = (double) size / Array.length;
    }

    public void addLast(Generic item) {
        if (size == Array.length) {
            resizeArray(size * 2);
        }
        rear = (rear + 1) % Array.length;
        Array[rear] = item;
        size++;
        ratio = (double) size / Array.length;
    }

    public boolean isEmpty() {
        if (size == 0) {
            return true;
        }
        return false;
    }

    public int size() {
        return size;
    }

    public void printDeque() {
        if (front < rear) {
            for (int i = 0; i < size; i++) {
                System.out.println(Array[i] + " ");
            }
        } else {
            for (int i = front; i < size; i++) {
                System.out.println(Array[i] + " ");
            }
            for (int i = 0; i <= rear; i++) {
                System.out.println(Array[i] + " ");
            }
        }
    }

    public Generic removeFirst() {
        if (size == 0) {
            return null;
        }
        Generic temp = Array[front];
        front = (front - 1 + Array.length) % Array.length;
        size--;
        ratio = (double) size / Array.length;
        if (ratio < 0.25 && Array.length >= 16) {
            resizeArray(Array.length / 2);
        }
        return temp;
    }

    public Generic removeLast() {
        if (size == 0) {
            return null;
        }
        Generic temp = Array[rear];
        rear = (rear + 1) % Array.length;
        size--;
        ratio = (double) size / Array.length;
        if (ratio < 0.25 && Array.length >= 16) {
            resizeArray(Array.length / 2);
        }
        return temp;
    }

    public Generic get(int index) {
        if (index >= size) {
            return null;
        }
        return Array[(front + index) % Array.length];
    }


}