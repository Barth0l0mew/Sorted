import model.Bus;
import model.Student;
import model.User;
import net.datafaker.providers.base.App;
import org.w3c.dom.ls.LSOutput;

import java.io.Serializable;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("Create new main");
        System.out.println("Hello world!");
        //AppendObject.saveObject("student.dat", Student.randomStudents(5));
//        for (Object el: LoadObject.readObjects("student.dat")) {
//            System.out.println(Arrays.toString((Student[]) el));
//        }
        start();
    }
    public static void start() {
        Scanner scanner = new Scanner(System.in);
        Object[] inputData = null;
        while (true) {
            System.out.println("Введите пункт");
            System.out.println("1 - загрузка с файла");
            System.out.println("2 - загрузка рандомная");
            System.out.println("3 - загрузка пользовательская");
            System.out.println("4 - вывод содержимого файла на экран");
            System.out.println("5 - вывод содержимого массива");
            System.out.println("6 - Сохранения в файл");
            System.out.println("0 - выход");
            String input = scanner.nextLine();
            try {
                int index = Integer.parseInt(input);
                switch (index) {
                    case 1: {
                        System.out.println("1");
                        break;
                    }
                    case 2: {
                        System.out.println("21 - класс  Студент ");
                        System.out.println("22 - класс Пользователь");
                        System.out.println("23 - класс Автобус");
                        System.out.println("0 - Выход на верх");
                         input = scanner.nextLine();
                        try {
                            index = Integer.parseInt(input);
                            switch (index) {
                                case 21: {
                                    inputData = Student.randomStudents(5);
                                    break;
                                }
                                case 22: {
                                    inputData = User.randomUser(5);
                                    break;
                                }
                                case 23: {
                                    inputData = Bus.randomBus(5);
                                    break;
                                }

                                case 0: {
                                    break;
                                }
                                default:
                                    System.out.println("Нет такого пункта");
                            }
                        } catch (NumberFormatException e) {
                            System.out.println("Не верный пункт");
                        }
                        break;
                    }
                    case 3: {
                        System.out.println("3");
                        break;
                    }
                    case 4: {
                        System.out.println("Укажите путь к файлу");
                        String filePath = scanner.nextLine();
                        if (!filePath.isBlank()) {
                            for (Object el: LoadObject.readObjects(filePath)) {
                                String name = el.getClass().getSimpleName();
                                if (name.equals("Student[]")) {
                                    System.out.println(Arrays.toString((Student[]) el));
                                }
                                if (name.equals("User[]")) {
                                    System.out.println(Arrays.toString((User[]) el));
                                }
                                if (name.equals("Bus[]")) {
                                    System.out.println(Arrays.toString((Bus[]) el));
                                }

                            }
                        }
                        break;
                    }
                    case 5: {
                        System.out.println(Arrays.toString(inputData));
                        break;
                    }
                    case 6:{
                        System.out.println("Введите путь к файлу" );
                        String namePath = scanner.nextLine();
                        AppendObject.saveObject(namePath,inputData);
                        break;
                    }
                    case 0: {
                        return;
                    }
                    default:
                        System.out.println("Нет такого пункта");
                }
            } catch (NumberFormatException e) {
                System.out.println("Не верный пункт");
            }

        }
    }
}