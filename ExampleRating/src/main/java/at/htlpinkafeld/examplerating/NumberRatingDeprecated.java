package at.htlpinkafeld.examplerating;

import java.util.Collections;
import java.util.List;

public class NumberRatingDeprecated {
    public double rate(List<Integer> ratingList) {
        sortRatings(ratingList);
        ratingList.remove(0);
        ratingList.remove(ratingList.size() - 1);
        return sumUpRatings(ratingList);
    }

    double sumUpRatings(List<Integer> ratingList) {
        int sum = 0;
        for (Integer i : ratingList) {
            sum+= i;
        }
        return sum;
    }


    void sortRatings(List<Integer> ratingList) {
        Collections.sort(ratingList);
    }
}

