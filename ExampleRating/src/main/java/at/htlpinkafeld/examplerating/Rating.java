package at.htlpinkafeld.examplerating;

import java.util.Collections;
import java.util.List;

public abstract class Rating<T extends Comparable<T>> {

    public double rate(List<T> ratingList) {
        sortRatings(ratingList);
        ratingList.remove(0);
        ratingList.remove(ratingList.size() - 1);
        return sumUpRatings(ratingList);
    }

    protected abstract double sumUpRatings(List<T> ratingList);

    protected void sortRatings(List<T> ratingList) {
        Collections.sort(ratingList);
    }
}
