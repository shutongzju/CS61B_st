public interface Deque<Item> {
    void addLast(Item y);
    void addFirst(Item x);
    Item removeFirst();
    Item removeLast();
    Item get(int i);
    int size();
    void printDeque();
    default  boolean isEmpty() {
        if (size() == 0) {
            return true;
        }
        return false;
    }

}
