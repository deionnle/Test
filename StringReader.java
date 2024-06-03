import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;

public class StringReader {
    public static void main(String[] args) {
        BufferedReader br = null;
        try {
            class Car {
                String name;
                int maxSpeed;
                int weight;

                public Car(String n, int m, int w) {
                    this.name = n;
                    this.maxSpeed = m;
                    this.weight = w;
                }
            }

            File file = new File("Car.txt");
            br = new BufferedReader(new FileReader(file));
            String st = br.readLine();
            ArrayList<Car> list = new ArrayList<>();
            while (st != null) {
                String[] arr = st.split(" ");
                list.add(new Car(arr[0],Integer.parseInt(arr[1]),Integer.parseInt(arr[2])));
                st = br.readLine();
                System.out.println(Arrays.toString(arr));
            }
        } catch (IOException e) {
            System.out.println("Ошибка " + e);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Некорректная длина строки " + e);
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
}
