import java.io.*;
import java.util.Random;

public class Files {
    public static void main(String[] args) {
        try {
            for (int i = 1; i <= 10; i++) {
                File file = new File("E:\\Обучение\\exercises\\" + i + ".txt");
                BufferedWriter bw = new BufferedWriter(new FileWriter(file));

                Random random = new Random();

                int n = 0;
                while (n < 3) {
                    bw.write("" + (random.nextInt(500) + 1));
                    bw.newLine();
                    n++;
                }
                bw.close();
            }
        } catch (IOException e) {
            System.out.println("Ошибка " + e);
        }
    }
}