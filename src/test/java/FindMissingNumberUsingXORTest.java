import org.junit.jupiter.api.Test;

import static me.yurasevv.MissingNumberFinder.findMissingNumberUsingXOR;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class FindMissingNumberUsingXORTest {
    @Test
    public void testMissingInTheMiddle() {
        int[] arr = {5, 0, 1, 3, 2};
        assertEquals(4, findMissingNumberUsingXOR(arr));
    }

    @Test
    public void testMissingAtStart() {
        int[] arr = {7, 9, 10, 11, 12};
        assertEquals(8, findMissingNumberUsingXOR(arr));
    }

    @Test
    public void testMissingAtEnd() {
        int[] arr = {0, 1, 2};
        assertEquals(3, findMissingNumberUsingXOR(arr));
    }

    @Test
    public void testSingleMissingNumber() {
        int[] arr = {1, 2, 4, 5, 6};
        assertEquals(3, findMissingNumberUsingXOR(arr));
    }

    @Test
    public void testNoMissingNumber() {
        int[] arr = {0, 1, 2, 3, 4, 5};
        assertEquals(6, findMissingNumberUsingXOR(arr));
    }
}
