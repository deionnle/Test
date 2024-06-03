import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Random;

public class Numbers {
    static int getSumSixNumbers (int a, int b, String way) {
        int sum = 0;
        for (int i = 0; i <2; i ++) {
            File my_fil = new File("" + way + a + ".txt");
            BufferedReader br = null;
            try {
                br = new BufferedReader(new FileReader(my_fil));
                String st = br.readLine();
                int count = 0;
                while (st != null) {
                    sum += Integer.valueOf(st);
                    st = br.readLine();
                    count++;
                }
                a = b;
                if (count != 3) {
                    System.err.println("Неверное количество строк");
                }
            } catch (IOException e) {
                System.out.println("Фаил не найден");
            } catch (NumberFormatException e) {
                System.out.println("Некорректное значение в строке  " + e);
            } finally {
                try {
                    br.close();
                } catch (IOException e) {
                    System.out.println("Ошибка " + e);
                }
            }
        }
        return sum;
    }

    public static void main(String[] args) {

    Random rand = new Random();
    int a = rand.nextInt(10) + 1;
    int b = rand.nextInt(10) + 1;
    String way = "E:\\Обучение\\exercises\\";

    System.out.println(getSumSixNumbers(a, b, way));
    }
}
