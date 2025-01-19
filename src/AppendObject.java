

import model.Student;
import net.datafaker.providers.entertainment.SouthPark;

import java.io.*;

public class AppendObject {
    public static <T> void saveObject(String fileName, T[] students) {
        boolean append = new File(fileName).exists();
        try (FileOutputStream fos = new FileOutputStream(fileName, append);
             ObjectOutputStream oos = append ? new AppendObjectToFile(fos) : new ObjectOutputStream(fos)) {
            oos.writeObject(students);
            System.out.println("Объект сохранен");
        } catch (FileNotFoundException e) {
            System.out.println("Файла с таким именем не сущеcтвует " + e.getMessage());

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        ;
    }

    private static class AppendObjectToFile extends ObjectOutputStream {

        public AppendObjectToFile(OutputStream out) throws IOException {
            super(out);
        }

        @Override
        protected void writeStreamHeader() throws IOException {

            System.out.println("Объект добавлен и сохранен");

            reset();
        }
    }
}
