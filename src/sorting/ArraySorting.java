package sorting;

import sorting.comparators.BusComparator;
import sorting.comparators.StudentComparator;
import sorting.comparators.UserComparator;

import java.util.Arrays;

public class ArraySorting {
    public static <T> T[] sortArray(T[] array) {
        Class<? extends Object[]> var = array.getClass();
        String classType = var.getSimpleName();
        System.out.println(classType);
        switch (classType) {
            case ("Bus[]"):
                Arrays.sort(array);

                BusComparator busComparator = new BusComparator();
                //busComparator.compare();
                break;

            case ("User[]"):

                Arrays.sort(array);

                UserComparator userComparator = new UserComparator();
                //userComparator.compare();
                break;

            case ("Student[]"):
                System.out.println("Сортировка студент");
                Arrays.sort(array);

                StudentComparator studentComparator = new StudentComparator();
                //studentComparator.compare();
                break;

        }
        return array;
    }
}

