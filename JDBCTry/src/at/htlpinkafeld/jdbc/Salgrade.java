package at.htlpinkafeld.jdbc;

public class Salgrade {
    private int grade;
    private double losal;
    private double hisal;

    public Salgrade(int grade, double losal, double hisal) {
        this.grade = grade;
        this.losal = losal;
        this.hisal = hisal;
    }

    @Override
    public String toString() {
        return "Salgrade{" +
                "grade=" + grade +
                ", losal=" + losal +
                ", hisal=" + hisal +
                '}';
    }
}
