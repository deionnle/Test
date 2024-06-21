import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;

public class DelFolder {
    public static ArrayList<ArrayList<File>> arrayList(File path) {
        ArrayList<File> files = new ArrayList<>();
        ArrayList<File> directories = new ArrayList<>();

        ArrayList<File> expand = new ArrayList<>();
        File root = new File(String.valueOf(path));
        expand.addAll(Arrays.asList(root.listFiles()));

        File[] expandCopy = expand.toArray(new File[expand.size()]);
        expand.clear();
        for (File file : expandCopy) {
            if (file.isDirectory()) {
                directories.add(file);
            } else if (file.isFile()) {
                files.add(file);
            }
        }

        ArrayList<ArrayList<File>> result = new ArrayList<ArrayList<File>>();
        result.add(files);
        result.add(directories);
        return result;
    }

    public static boolean deleteFolder(File path) {
        try {
            ArrayList<ArrayList<File>> fil = arrayList(path);
            if (fil.get(1).size() > 0) return false;

            File directory = new File(path.getAbsolutePath());
            File[] files = directory.listFiles();
            if (files != null) {
                for (File file : files) {
                    file.delete();
                }
            }
            if (!directory.delete()) return false;
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
