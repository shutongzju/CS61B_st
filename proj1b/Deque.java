public interface Deque<Item> {
    public void addFirst(Item x);
    public void addLast(Item y);
    public Item removeFirst();
    public Item removeLast();
    public Item get(int i);
//    public void insert(Item x, int position);
    public int size();
    default public boolean isEmpty() {
        if (size() == 0) {
            return true;
        }
        return false;
    }

}
