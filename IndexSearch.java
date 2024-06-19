import java.util.logging.Logger;

public class IndexSearch {
    static Logger logger = Logger.getLogger(IndexSearch.class.getName());
    static int num(int[] array, int a) {
        logger.info("Функция поиск индекса");
        assert array.length > 0;
        for (int i = 0; i < array.length; i ++) {
            if (array[i] == a) {
                logger.info("Поиск успешно завершен");
                return i;
            }
        }
        logger.info("Индекс не был найден");
        return -1;
    }

    public static void main(String[] args) {
        int[] arr = {1, 5, 4, 30, 2, 36, 8, 11, 7, 94};
        int x = 94;
        System.out.println(num(arr, x));
    }
}