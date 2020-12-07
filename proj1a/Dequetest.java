public class Dequetest {
    public static void main(String[] args) {
        ArrayDeque temp = new ArrayDeque();
        for (int i = 0; i < 15; i++) {
            temp.addLast(i);
            temp.addFirst(2 * i);
        }
        for (int i = 0; i < 8; i++) {
            temp.removeFirst();
            temp.removeFirst();
            temp.removeLast();
        }
    }
}
