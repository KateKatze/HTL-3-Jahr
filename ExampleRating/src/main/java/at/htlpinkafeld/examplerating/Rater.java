package at.htlpinkafeld.examplerating;

import java.util.Objects;

public class Rater implements Comparable<Rater> {
    private String name;
    private int rating;

    public Rater(String name, int rating) {
        this.name = name;
        this.rating = rating;
    }

    public String getName() {
        return name;
    }

    public int getRating() {
        return rating;
    }

    @Override
    public int compareTo(Rater o) {
        return this.name.compareTo(o.name);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Rater rater = (Rater) o;
        return rating == rater.rating &&
                Objects.equals(name, rater.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, rating);
    }
}

