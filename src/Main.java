import model.Student;
import net.datafaker.providers.base.App;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        System.out.println("Create new main");
        System.out.println("Hello world!");
        //AppendObject.saveObject("student.dat", Student.randomStudents(5));
        for (Object el: LoadObject.readObjects("student.dat")) {
            System.out.println(Arrays.toString((Student[]) el));
        }
    }
}