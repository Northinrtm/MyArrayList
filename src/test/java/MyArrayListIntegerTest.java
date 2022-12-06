import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MyArrayListIntegerTest {
    MyArrayListInteger out = new MyArrayListInteger();


    @Test
    void containsBinary() {
        out.add(5);
        out.add(1);
        out.add(3);
        out.add(4);
        out.add(6);
        out.add(7);
        assertTrue(out.contains(4));
    }
}