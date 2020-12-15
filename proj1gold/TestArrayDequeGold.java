import static org.junit.Assert.*;
import org.junit.Test;

public class TestArrayDequeGold {
    static ArrayDequeSolution<Integer> cDeque = new ArrayDequeSolution<>();
    static StudentArrayDeque<Integer> wDeque =  new StudentArrayDeque<>();

    @Test
    public void testDeque() {
        String message = "";
        for (int i = 0; i < 200; i++) {
            if (StdRandom.uniform() > 0.75 ) {
                int j = StdRandom.uniform(20);
                cDeque.addLast(j);
                wDeque.addLast(j);
                message += String.format("addLast(%d)\n", i);
            } else if (StdRandom.uniform() > 0.5) {
                int j = StdRandom.uniform(20);
                cDeque.addFirst(j);
                wDeque.addFirst(j);
                message += String.format("addFirst(%d)\n", i);
            } else if (StdRandom.uniform() > 0.25 && !cDeque.isEmpty()) {
                message += String.format("removeLast()\n");
                assertEquals(message, cDeque.removeLast(), wDeque.removeLast());
            } else if (!cDeque.isEmpty()) {
                message += String.format("removeFirst()\n");
                assertEquals(message, cDeque.removeFirst(), wDeque.removeFirst());
            }
        }
    }
}
