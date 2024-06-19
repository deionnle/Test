import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Random;
import java.util.logging.Logger;

public class Numbers {
    public static int[] getSumSixNumbers (int a, int b, String way) {
        int[] sum = new int[2];
        sum[0] = 0;
        sum[1] = 0;
        for (int i = 0; i < 2; i++) {
            int[] s;
            if (i == 0) {
                s = sumSixNumbers(a, way);
            } else {
                s = sumSixNumbers(b, way);
            }
            if (s[1] != 0) {
                sum[1] = s[1];
                return sum;
            }
            sum[0] += s[0];
        }
        return sum;
    }

public static int[] sumSixNumbers (int f, String way) {
    Logger log = Logger.getLogger(Numbers.class.getName());
        int[] res = new int[2];
        res[1] = 0;
        int sum = 0;
        BufferedReader br = null;
            try {
                File my_fil = new File(way + f + ".txt");
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

    Random rand = new Random();
    int a = rand.nextInt(10) + 1;
    int b = rand.nextInt(10) + 1;
    String way = "E:\\Обучение\\exercises\\";

    int r[] = getSumSixNumbers(a, b, way);
        System.out.println(r[0]);
        System.out.println(r[1]);
    }
}
