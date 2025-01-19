package sorting.comparators;

import model.Bus;

import java.util.Comparator;

public class BusComparator implements Comparator<Bus> {

    @Override
    public int compare(Bus o1, Bus o2) {
//        if (o1.getNumber - o2.getNumber == 0)
//            return 0;
//        else if (o1.getNumber % 2 == 1 && o2.getNumber % 2 == 1 && o1.getNumber > o2.getNumber) {
//            return 1;
//        } else
//            return -1;
        return o1.getNumberBus().compareTo(o2.getNumberBus());

    }
}

