public class HurricaneRowData {

    private final int year;
    private final int aceIndex;
    private final int storms;
    private final int hurricanes;
    private final int majorHurricanes;

    // constructor
    public HurricaneRowData(int year, int aceIndex, int storms, int hurricanes, int majorHurricanes) {
        this.year = year;
        this.aceIndex = aceIndex;
        this.storms = storms;
        this.hurricanes = hurricanes;
        this.majorHurricanes = majorHurricanes;
    }

    // year getter
    public int getYear() { return year; }

    // aceIndex getter
    public int getAceIndex() { return aceIndex; }

    // storms getter
    public int getStorms() { return storms; }

    // hurricanes getter
    public int getHurricanes() { return hurricanes; }

    // majorHurricanes getter
    public int getMajorHurricanes() { return majorHurricanes; }

    // toString method
    @Override
    public String toString() {
        return
            "\nYear: " + year +
            "\nACE Index: " + aceIndex +
            "\nNumber of Storms: " + storms +
            "\nNumber of Hurricanes: " + hurricanes +
            "\nNumber of Major Hurricanes: " + majorHurricanes +
            System.lineSeparator();
    }
}