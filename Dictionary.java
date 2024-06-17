import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

public class Dictionary {
    public static ArrayList<Integer> getList(ArrayList<Integer> list, int N) {
        // Создаю словарь и список для возврата значений
        HashMap<Integer, Integer> equalsNum = new HashMap<>();
        ArrayList<Integer> resultList = new ArrayList<>();
        // Цикл по элементам списка list
        for (Integer i : list) {
            // Если элемент существует в списке - добавляю 1 к текущему значению
            if (equalsNum.containsKey(i)) {
                equalsNum.put(i, equalsNum.get(i) + 1);
            // Иначе добавляю ключ со значением 1
            } else {
                equalsNum.put(i, 1);
            // Если значение ключа >= N и список не содержит это значение, добавляю его в список
            } if (equalsNum.get(i) >= N) {
                if (!resultList.contains(i)) {
                    resultList.add(i);
                }
            }
        }

        return resultList;
    }
    public static void main(String[] args) {
        // Создаю словарь
        HashMap<Integer, String> NumbersList = new HashMap<>();
        Random rand = new Random();
        // Добавляю в словарь 100 случайных пар целый ключ + значение строка
        for (int i = 0; i < 100; i ++) {
            NumbersList.put(rand.nextInt(300)+1, Integer.toString(rand.nextInt(300)+200));
        }
        // Считываю ключ + значение
        for (Integer i : NumbersList.keySet()) {
            System.out.println("key: " + i + " value: " + NumbersList.get(i));
        }
        // Очищаю словарь
        NumbersList.clear();

        // Генерирую список из 100 значений с числами в диапазоне от 1 до 10
        ArrayList<Integer> tenNumbersList = new ArrayList<>();
        for (int i = 0; i < 100; i ++) {
            tenNumbersList.add(rand.nextInt(10)+1);
        }
        System.out.println(getList(tenNumbersList, 10));
    }
}
