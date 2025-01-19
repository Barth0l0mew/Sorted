package sorting.comparators;

import model.Student;

import java.util.Comparator;

public class StudentComparator implements Comparator<Student> {
    @Override
    public int compare(Student o1, Student o2) {
//        if (o1.getGroupNumber - o2.getGroupNumber == 0)
//            return 0;
//        else if (o1.getGroupNumber % 2 == 1 && o2.getGroupNumber % 2 == 1 && o1.getGroupNumber > o2.getGroupNumber) {
//            return 1;
//        } else
//            return -1;
    return o1.getNumberGroup().compareTo(o2.getNumberGroup());

    }

}

