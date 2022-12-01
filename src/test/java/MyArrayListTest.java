import org.junit.Assert;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MyArrayListTest {

    private final MyArrayList out = new MyArrayList();

    private String[] expectedStrings1;
    private String[] expectedStrings2;
    private String[] expectedStrings3;
    private String[] expectedStrings4;
    private String[] expectedStrings5;
    private final String S_THIRD = "Третий";

    @BeforeEach
    void setUp() {
        out.add("Нулевой");
        out.add("Первый");
        out.add("Второй");

        expectedStrings1 = new String[]{"Нулевой", "Первый", "Второй", "Третий"};
        expectedStrings2 = new String[]{"Нулевой", "Первый", "Третий", "Второй"};
        expectedStrings3 = new String[]{"Нулевой", "Первый", "Третий"};
        expectedStrings4 = new String[]{"Нулевой", "Первый"};
        expectedStrings5 = new String[]{"Нулевой", "Первый", "Второй"};
    }

    @Test
    void addItem() {
        out.add("Третий");
        Assert.assertArrayEquals(expectedStrings1, out.toArray());
    }

    @Test
    void testIndexItem() {
        out.add(2, S_THIRD);
        Assert.assertArrayEquals(expectedStrings2, out.toArray());
    }

    @Test
    void set() {
        out.set(2, S_THIRD);
        Assert.assertArrayEquals(expectedStrings3, out.toArray());
    }

    @Test
    void removeIndex() {
        String result = out.remove(2);
        Assert.assertArrayEquals(expectedStrings4, out.toArray());
        Assert.assertEquals("Второй", result);
    }

    @Test
    void RemoveString() {
        String result = out.remove("Второй");
        Assert.assertArrayEquals(expectedStrings4, out.toArray());
        Assert.assertEquals("Второй", result);
    }

    @Test
    void contains() {
        Assert.assertTrue(out.contains("Второй"));
        Assert.assertFalse(out.contains("Третий"));
    }

    @Test
    void indexOf() {
        Assert.assertEquals(2, out.indexOf("Второй"));
        Assert.assertEquals(-1, out.indexOf("Третий"));
    }

    @Test
    void lastIndexOf() {
        Assert.assertEquals(2, out.lastIndexOf("Второй"));
        Assert.assertEquals(-1, out.lastIndexOf("Третий"));
    }

    @Test
    void get() {
        Assert.assertEquals("Второй", out.get(2));
    }

    @Test
    void size() {
        Assert.assertEquals(3, out.size());
    }

    @Test
    void isEmpty() {
        Assert.assertFalse(out.isEmpty());
        out.clear();
        Assert.assertTrue(out.isEmpty());
    }

    @Test
    void clear() {
        out.clear();
        Assert.assertTrue(out.isEmpty());
    }

    @Test
    void toArray() {
        String[] result = out.toArray();
        Assert.assertArrayEquals(expectedStrings5, result);
    }
}