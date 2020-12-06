/*This is a Deque implemented by circle linked list*/
public class LinkedListDeque<Generic> {

    private class GenericNode{
        private Generic item;
        private GenericNode front;
        private GenericNode rear;

        private GenericNode(Generic i, GenericNode Pf, GenericNode Pr) {
            item = i;
            front = Pf;
            rear = Pr;
        }
    }

    private int size;
    private GenericNode sentinel;


    public LinkedListDeque() {
        size = 0;
        sentinel = new GenericNode(null, null, null);
        sentinel.rear = sentinel;
        sentinel.front = sentinel;
    }

    public LinkedListDeque(Generic item) {
        size = 1;
        GenericNode P = new GenericNode(item, sentinel, sentinel);
        sentinel.rear = P;
        sentinel.front = P;
    }

    public LinkedListDeque(LinkedListDeque P) {
        sentinel.rear = sentinel;
        sentinel.front = sentinel;
        size = 0;
        int i = 0;
        GenericNode PP = P.sentinel.rear;
        while (i < P.size) {
            GenericNode temp = sentinel.front;
            sentinel.front = new GenericNode(PP.item, temp, sentinel);
            temp.rear = sentinel.front;
            PP = PP.rear;
            size++;
            i++;
        }
    }

    public void addFirst(Generic item) {
        GenericNode P = sentinel.rear;
        sentinel.rear = new GenericNode(item, sentinel, P);
        P.front = sentinel.rear;
        size++;
    }

    public void addLast(Generic item) {
        GenericNode P = sentinel.front;
        sentinel.front = new GenericNode(item, P, sentinel);
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
        GenericNode P = sentinel;
        while (P.rear != sentinel) {
            System.out.println(P.rear.item + " ");
            P = P.rear;
        }
        System.out.println("\n");
    }

    public Generic removeFirst() {
        if (size == 0) {
            return null;
        }
        size--;
        Generic item = sentinel.rear.item;
        sentinel.rear.rear.front = sentinel;
        sentinel.rear = sentinel.rear.rear;
        return item;
    }

    public Generic removeLast() {
        if (size == 0) {
            return null;
        }
        size--;
        Generic item = sentinel.front.item;
        sentinel.front.front.rear = sentinel;
        sentinel.front = sentinel.front.front;
        return item;
    }

    public Generic get(int index) {
        if(index - size >= 0) {
            return null;
        }
        GenericNode P = sentinel.rear;
        while (index > 0) {
            P = P.rear;
        }
        return P.item;
    }

    public Generic getRecursive(int index) {
        if (index - size >= 0) {
            return null;
        }
        return getRecursiveHelper(sentinel.rear, index);
    }

    private Generic getRecursiveHelper(GenericNode P, int index) {
        if(index == 0) {
            return P.item;
        }
        return getRecursiveHelper(P.rear, index - 1);
    }


}
