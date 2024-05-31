import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class SortArraysTest {
    @Test
    public void PositiveNumbersEqualsTest() {
        int expected[] = new int[] {1,2,3,4,5};
        assertArrayEquals(expected, SortArrays.sort(new int[] {5,1,3,4,2}));
    }
    @Test
    public void MixNumbersEqualsTest() {
        int expected[] = new int[] {-4,-3,0,1,2};
        assertArrayEquals(expected, SortArrays.sort(new int[] {-3,2,1,-4,0}));
    }
    @Test
    public void NegativeNumbersEqualsTest() {
        int expected[] = new int[] {-5,-4,-3,-2,-1};
        assertArrayEquals(expected, SortArrays.sort(new int[] {-1,-4,-2,-3,-5}));
    }
    @Test
    public void NotNullTest() {
        int[] expected = SortArrays.sort(new int[] {9,5,6,1,4,3,7,2,8,0});

        for (int i = 0; i < expected.length; i ++) {
            assertNotNull(expected[i]);
        }
    }
    @Test
    public void OneNumbTest() {
        int expected[] = new int[] {1};
        assertArrayEquals(expected, SortArrays.sort(new int[] {1}));
    }
    @Test
    public void EqualsNumbersTest() {
        int expected[] = new int[] {1,1,1,1,1};
        assertArrayEquals(expected, SortArrays.sort(new int[] {1,1,1,1,1}));
    }
    @Test
    public void ZeroTest() {
        int expected[] = new int[] {};
        assertArrayEquals(expected, SortArrays.sort(new int[] {}));
    }
}