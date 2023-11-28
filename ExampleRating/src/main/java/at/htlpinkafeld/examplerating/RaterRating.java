package at.htlpinkafeld.examplerating;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class RaterRating extends Rating<Rater> {
    @Override
    protected double sumUpRatings(List<Rater> ratingList) {
        int sum = 0;
        for (Rater rater : ratingList) {
            sum += rater.getRating();
        }
        return sum;
    }

    protected void sortRatings(List<Rater> ratingList) {
        Collections.sort(ratingList, new Comparator<Rater>() {
            @Override
            public int compare(Rater r1, Rater r2) {
                return Integer.compare(r1.getRating(), r2.getRating());
            }
        });
    }

    @Override
    public double rate(List<Rater> ratingList) {
        sortRatings(ratingList);
        ratingList.remove(0);
        ratingList.remove(ratingList.size() - 1);
        return sumUpRatings(ratingList);
    }
}
