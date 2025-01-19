import model.Bus;
import model.Student;
import model.User;
import net.datafaker.providers.base.App;
import org.w3c.dom.ls.LSOutput;
import sorting.ArraySorting;

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
    private static int getIntInput(Scanner scanner) {
        while (true) {
            try {
                return Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.print("Неверный ввод. Пожалуйста, введите целое число: ");
            }
        }
    }
    public static void start() {
        Scanner scanner = new Scanner(System.in);
        Object[] inputData = null;
        Object[] outputData = null;
        while (true) {
            System.out.println("Введите пункт");
            System.out.println("1 - создания массива объектов из файла");
            System.out.println("2 - создания массива объектов рандомная ");
            System.out.println("3 - создания массива объектов пользовательская");
            System.out.println("4 - вывод содержимого файла на экран");
            System.out.println("5 - вывод содержимого массива на экран");
            System.out.println("6 - Сохранения в файл массива объектов");
            System.out.println("7 - Сортировка массива");
            System.out.println("8 - Сохранения резульатов поиска или сортировки");
            System.out.println("0 - выход");
            String input = scanner.nextLine();
            try {
                int index = Integer.parseInt(input);
                switch (index) {
                    case 1: {
                        System.out.println("Укажите путь к файлу");
                        String filePath = scanner.nextLine();
                        if (!filePath.isBlank()) {
                            for (Object el : LoadObject.readObjects(filePath)) {
                                inputData = (Object[]) el;
                            }
                        }
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
                        System.out.println("Выберите класс для заполнения:");
                        System.out.println("31. Студент");
                        System.out.println("32. Пользователь");
                        System.out.println("33. Автобус");
                        System.out.println("0. Вернуться назад");
                        System.out.print("Ваш выбор: ");
                        input = scanner.nextLine();
                        try {
                            index = Integer.parseInt(input);
                            switch (index) {
                                case 31: {
                                    System.out.print("Введите количество студентов: ");
                                    int studentCount = getIntInput(scanner);
                                    inputData = new Student[studentCount];
                                    for (int i = 0; i < studentCount; i++) {
                                        System.out.print("Введите номер группы студента: ");
                                        String groupNumber = scanner.nextLine();
                                        System.out.print("Введите средний балл студента: ");
                                        String averageGrade = scanner.nextLine();
                                        System.out.print("Введите номер зачетной книжки студента: ");
                                        String gradeBookNumber = scanner.nextLine();
                                        inputData[i]= new Student.BuilderStudent()
                                                .setNumberGroup(groupNumber)
                                                .setScore(Double.parseDouble(averageGrade))
                                                .setStudentsRecordBook(gradeBookNumber)
                                                .build();
                                    }
                                    System.out.println("Массив студентов заполнен вручную.");
                                    break;
                                }
                                case 32: {
                                    inputData = User.randomUser(5);
                                    break;
                                }
                                case 33: {
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
                    case 7: {
                        outputData = ArraySorting.sortArray(inputData);
                        System.out.println(Arrays.toString(outputData));
                        //System.out.println(Arrays.toString(ArraySorting.sortArray(inputData)));

                        break;
                    }
                    case 8:{
                        System.out.println("Введите имя файла для сохранения результата");
                        input = scanner.nextLine();
                        AppendObject.saveObject(input,outputData);
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