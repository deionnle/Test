import java.io.*;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class ZipAdd {
    public static void getZip(String name, String[] files) throws FileNotFoundException {
        try {
        // Создаю файл name и записываю данные в виде байтового потока;
        FileOutputStream fileOutputStream = new FileOutputStream(name);
        // Создаю ZIP архив. Инициализирую ZipOutputStream с помощью выходного потока FileOutputStream;
        ZipOutputStream zipOutputStream = new ZipOutputStream(fileOutputStream);
        // Цикл по всем файлам массива имен files;
            for (String file : files) {
                // Создаю новую запись в ZIP-архиве для текущего файла;
                ZipEntry zipEntry = new ZipEntry(file);
                // Добавляю новую сущность (заголовок) в архив;
                zipOutputStream.putNextEntry(zipEntry);
                try {
                    // копирую исходный файл в архив;
                    FileInputStream fileInputStream = new FileInputStream(file);
                    // Переменная длины;
                    int length;
                    // Буфер для чтения данных из файла;
                    byte[] buffer = new byte[1024];
                    // Считываю данные из fileInputStream в буфер. Переменной length присваивается возвращаемое значение метода read.
                    // Когда вернется -1, цикл завершится;
                    while ((length = fileInputStream.read(buffer)) > 0) {
                    // Записываю прочитанные данные в архив;
                    zipOutputStream.write(buffer, 0, length);
                    }
                    // Закрываю поток (в любом случае т.к. внутри блока try/catch);
                    fileInputStream.close();
                } catch (IOException e) {
                    System.err.println("Ошибка при чтении файла: " + e);
                }
            }
            // Закрываю потоки (в любом случае т.к. внутри блока try/catch);
            zipOutputStream.close();
            fileOutputStream.close();
        } catch (FileNotFoundException e) {
            System.err.println("Файл не найден: " + e);
        } catch (IOException e) {
            System.err.println("Ошибка " + e);
        }
    }
    public static void main(String[] args) {
        // Имя архива;
        String name = "test.zip";
        // Массив имен файлов;
        String[] files = {"Car.txt", "README.md", "ReflectionTask13.md"};
            try {
                // Вызываю метод. Передаю в метод имя архива и массив имен файлов;
                getZip(name,files);
                System.out.println("Файлы успешно добавлены");
            } catch (FileNotFoundException e) {
                System.err.println("Ошибка " + e);
            }
    }
}
