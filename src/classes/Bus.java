package classes;

public class Bus implements Comparable<Bus> {


    @Override
    public int compareTo(Bus other) {
        int numberComparison = this.number.compareTo(other.number);
        int modelComparison = this.model.compareTo(other.model);

        if (numberComparison != 0) {
            return numberComparison;
        } else if (modelComparison != 0) {
            return modelComparison;
        } else
            return this.mileage.compareTo(other.mileage);
    }
}
