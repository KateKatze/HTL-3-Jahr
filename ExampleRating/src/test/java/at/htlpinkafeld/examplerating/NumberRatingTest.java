package at.htlpinkafeld.examplerating;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class NumberRatingTest {
    private NumberRating numberRating;
    private List<Integer> list;

    @BeforeEach
    void setUp() {
        numberRating = new NumberRating();
        list = new ArrayList<>();
        list.add(3);
        list.add(5);
        list.add(6);
        list.add(1);
    }
    @Test
    void rate() {
        double result = numberRating.rate(list);
        double expected = 8.0;
        assertEquals(expected, result);
    }

    @Test
    void sumUpRatings() {
        double sum = numberRating.sumUpRatings(list);
        assertEquals(15, sum);
    }

    @Test
    void sortRatings() {
        numberRating.sortRatings(list);
        assertEquals(Arrays.asList(1, 3, 5, 6), list);
    }
}