import java.io.File;

public class DelFolder {
    public static boolean deleteFolder(File path) {
        try {
            File directory = new File(path.getAbsolutePath());

            File[] files = directory.listFiles();
            for (File file : files) {
                if (file.isDirectory()) {
                    return false;
                }
            }
            for (File file : files) {
                file.delete();
                }
            directory.delete();

            return true;
        } catch (Exception e) {
            System.out.println("Ошибка удаления каталога '" + path.getAbsolutePath() + e);
            return false;
        }
    }
    public static void main(String[] args) {
        File file = new File("E:\\exercises3");
        if (deleteFolder(file)) {
            System.out.println("Каталог удален");
        } else {
            System.out.println("Каталог содержит вложенные папки");
        }
    }
}
