
import static org.junit.Assert.*;
import org.junit.Test;


public class Apptest {


    @Test
    public void testNormalNextDate() {
        int[] nextDate = App.getNextDate(28, 2, 2024);
        assertArrayEquals(new int[]{29, 2, 2024}, nextDate);
    }

    @Test
    public void testEndOfMonth() {
        int[] nextDate = App.getNextDate(31, 12, 2021);
        assertArrayEquals(new int[]{1, 1, 2022}, nextDate);
    }

    @Test
    public void testLeapYear() {
        int[] nextDate = App.getNextDate(28, 2, 2020);
        assertArrayEquals(new int[]{29, 2, 2020}, nextDate);
    }

    @Test
    public void testInvalidDate() {
        int[] nextDate = App.getNextDate(32, 1, 2021);
        assertArrayEquals(new int[]{-1, -1, -1}, nextDate);
    }
}
