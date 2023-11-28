package at.htlpinkafeld.examplerating;

import java.util.List;

public class NumberRating extends Rating<Integer> {

    @Override
    protected double sumUpRatings(List<Integer> ratingList) {
        int sum = 0;
        for (Integer i : ratingList) {
            sum += i;
        }
        return sum;
    }
}