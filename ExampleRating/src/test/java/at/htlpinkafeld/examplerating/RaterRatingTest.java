package at.htlpinkafeld.examplerating;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class RaterRatingTest {
    private RaterRating raterRating;
    private List<Rater> list;

    @BeforeEach
    void setUp() {
        raterRating = new RaterRating();
        list = new ArrayList<>();
        list.add(new Rater("Joe", 3));
        list.add(new Rater("Amy", 5));
        list.add(new Rater("Tim", 6));
        list.add(new Rater("Fay", 1));
    }

    @Test
    void rate() {
        double result = raterRating.rate(list);
        double expected = 8.0;
        assertEquals(expected, result);
    }

    @Test
    void sumUpRatings() {
        double sum = raterRating.sumUpRatings(list);
        assertEquals(15, sum);
    }

    @Test
    void sortRatings() {
        raterRating.sortRatings(list);
        assertEquals(Arrays.asList(new Rater("Fay", 1),new Rater("Joe", 3),
                new Rater("Amy", 5),new Rater("Tim", 6)), list);
    }
}