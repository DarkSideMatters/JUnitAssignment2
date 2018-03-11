import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.contains;
import static org.hamcrest.Matchers.containsInAnyOrder;
import static org.hamcrest.Matchers.greaterThan;
import static org.hamcrest.collection.IsCollectionWithSize.hasSize;
import static org.hamcrest.core.Every.everyItem;


import static org.junit.jupiter.api.Assertions.*;
public class HandlerImplTest {


    private final Handler handler = new HandlerImpl();

    @Test
    public void testReadFile() {
        String expected = "5 12 65 33 2 11 10 98 66 -12 -9 0 10 12";
        try {
            String actual = handler.readFile("numbers.txt");
            assertEquals(expected, actual);
        } catch (IOException ex) {
            fail("File not found!");
        } catch (Exception e) {
            fail(e.getMessage());
        }
    }

    @Test
    public void testSortArray() {
        int[] unsorted = new int[] {1, 4, 5, 3, 2, -1, 0};
        int[] expected = new int[] {-1, 0, 1, 2, 3, 4, 5};
        int[] actual = handler.sortArray(unsorted);

        assertArrayEquals(expected, actual);
    }

    @Test
    public void testConvertToArray() {
        String content = "0 1 2 3 4 5";
        int[] actual = handler.convertToArray(content);
        int[] expected = new int[] {0, 1, 2, 3, 4, 5};

        assertArrayEquals(expected, actual);
    }

    @Test
    public void testConvertToArrayInvalidValues() {
        String content = "mdasmodfkas fsdjiofsd";
        int[] actual = handler.convertToArray(content);
        int expectedLenght = 0;
        assertEquals(expectedLenght, actual.length);
    }

    @Test
    public void testEvens() {
        // equivalence classes:
        // even numbers.txt: [-2, 0, 10]
        int[] numbers = new int[] {-3, 0, 1, 4, 6};
        int[] expected = new int[] {0, 4, 6};
        int[] actual = handler.getEvenNumbers(numbers);

        for (int num : actual) {
            System.out.println(num);
        }

        assertArrayEquals(expected, actual);
    }
    @Test
    public void testSum(int[] numArray, int sumExpected) {
        int sumActual = handler.calculateSum(numArray);

        System.out.println("Sum expected: " + sumExpected + "; sum actual: " + sumActual);
        assertEquals(sumExpected, sumActual);
    }

    //Hamcrest Tests
    @Test
    public void testReadFileHC() {
        try {
            String actualString = handler.readFile("numbers.txt");
            Pattern pattern = Pattern.compile(", ");
            List<Integer> list = pattern.splitAsStream(actualString)
                    .map(Integer::valueOf)
                    .collect(Collectors.toList());

            List<Integer> expected = Arrays.asList(5, 12, 65, 33, 2, 11, 10, 98, 66, -12, -9, 0, 10, 12);

            assertThat(list, hasSize(14));
            assertThat(list, contains(expected));

        } catch (IOException ex) {
            fail("File not found!");
        } catch (Exception e) {
            fail(e.getMessage());
        }
    }
    @Test
    public void testSortArrayHC() {
        int[] unsorted = new int[] { 1, 4, 5, 3, 2, -1, 0 };
        int[] ints = handler.sortArray(unsorted);
        List<Integer> actual = Arrays.stream(ints).boxed().collect(Collectors.toList());

        assertThat(actual, contains(-1, 0, 1, 2, 3, 4, 5));
    }

    // Data-driven
    @Test
    public void testSumDataDriven() {
        int[] dataplus = new int[] { 0, 1, 2 };
        int expected1 = 3;

        int[] dataminus = new int[] { 0, -1, -2 };
        int expected2 = -3;

        testSum(dataplus, expected1);
        testSum(dataminus, expected2);
    }


}
