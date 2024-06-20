import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import java.util.Random;
import java.util.logging.Logger;
import java.util.ArrayList;

public class Numbers {
    public static int[] getSumSixNumbers (List files) {
        Random rand = new Random();
        int[] sum = new int[2];
        sum[0] = 0;
        sum[1] = 0;
        for (int i = 0; i < 2; i++) {
            File file = (File) files.get(rand.nextInt(files.size()));
            int[] s = sumSixNumbers(file);
            if (s[1] != 0) {
                sum[1] = s[1];
                return sum;
            }
            sum[0] += s[0];
        }
        return sum;
    }

public static int[] sumSixNumbers (File file) {
    Logger log = Logger.getLogger(Numbers.class.getName());
        int[] res = new int[2];
        res[1] = 0;
        int sum = 0;
        BufferedReader br = null;
            try {
                File my_fil = new File(String.valueOf(file));
                br = new BufferedReader(new FileReader(my_fil));
                String st = br.readLine();
                int count = 0;
                while (st != null) {
                    sum += Integer.parseInt(st);
                    st = br.readLine();
                    count++;
                }
                if (count != 3) {
                    res[1] = 1;
                    log.warning("Неверное количество строк");
                    return res;
                }
            } catch (IOException e) {
                log.warning ("Файл не найден");
            } catch (NumberFormatException e) {
                res[1] = 2;
                log.warning ("Некорректное значение в строке");
            } finally {
                try {
                    assert br != null : "Ошибка при открытии файла/Файл не найден";
                    br.close();
                } catch (IOException e) {
                    res[1] = 3;
                    log.warning("Ошибка чтения файла");
                }
            }
            res[0] = sum;
            return res;
        }

    public static void main(String[] args) {
        String way = "E:\\Обучение\\exercises";
        List<File> files = new ArrayList<>();
        File directory = new File(way);
        if (directory.isDirectory()) {
            File[] listFiles = directory.listFiles();
            assert listFiles != null : "Пустая директория!";
            for (File file : listFiles) {
                if (file.isFile() && file.getName().endsWith(".txt")) {
                    files.add(file);
                }
            }
        }
        int r[] = getSumSixNumbers(files);
        System.out.println(r[0]);
        System.out.println(r[1]);
    }
}
