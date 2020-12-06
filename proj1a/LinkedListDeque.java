/*This is a Deque implemented by circle linked list*/
public class LinkedListDeque<T> {

    private class TNode{
        private T item;
        private TNode front;
        private TNode rear;

        private TNode(T i, TNode pf, TNode pr) {
            item = i;
            front = pf;
            rear = pr;
        }
    }

    private int size;
    private TNode sentinel;


    public LinkedListDeque() {
        size = 0;
        sentinel = new TNode(null, null, null);
        sentinel.rear = sentinel;
        sentinel.front = sentinel;
    }

    public LinkedListDeque(T item) {
        size = 1;
        TNode P = new TNode(item, sentinel, sentinel);
        sentinel.rear = P;
        sentinel.front = P;
    }

    public LinkedListDeque(LinkedListDeque P) {
        sentinel.rear = sentinel;
        sentinel.front = sentinel;
        size = 0;
        int i = 0;
        TNode PP = P.sentinel.rear;
        while (i < P.size) {
            TNode temp = sentinel.front;
            sentinel.front = new TNode(PP.item, temp, sentinel);
            temp.rear = sentinel.front;
            PP = PP.rear;
            size++;
            i++;
        }
    }

    public void addFirst(T item) {
        TNode P = sentinel.rear;
        sentinel.rear = new TNode(item, sentinel, P);
        P.front = sentinel.rear;
        size++;
    }

    public void addLast(T item) {
        TNode P = sentinel.front;
        sentinel.front = new TNode(item, P, sentinel);
        P.rear = sentinel.front;
        size++;
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
        TNode P = sentinel;
        while (P.rear != sentinel) {
            System.out.println(P.rear.item + " ");
            P = P.rear;
        }
        System.out.println("\n");
    }

    public T removeFirst() {
        if (size == 0) {
            return null;
        }
        size--;
        T item = sentinel.rear.item;
        sentinel.rear.rear.front = sentinel;
        sentinel.rear = sentinel.rear.rear;
        return item;
    }

    public T removeLast() {
        if (size == 0) {
            return null;
        }
        size--;
        T item = sentinel.front.item;
        sentinel.front.front.rear = sentinel;
        sentinel.front = sentinel.front.front;
        return item;
    }

    public T get(int index) {
        if(index - size >= 0) {
            return null;
        }
        TNode P = sentinel.rear;
        while (index > 0) {
            P = P.rear;
            index--;
        }
        return P.item;
    }

    public T getRecursive(int index) {
        if (index - size >= 0) {
            return null;
        }
        return getRecursiveHelper(sentinel.rear, index);
    }

    private T getRecursiveHelper(TNode P, int index) {
        if(index == 0) {
            return P.item;
        }
        return getRecursiveHelper(P.rear, index - 1);
    }


}
