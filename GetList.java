import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class GetList {
    public static List<List<String>> getArrayList(File path, String extension, boolean flag) {
        List<String> files = new ArrayList<>();
        List<String> directories = new ArrayList<>();
        List<File> expand = new ArrayList<>();

        expand.add(path);

        int n = 2;
        if (!flag) {
            n = 1;
        }

        for (int depth = 0; depth < n; depth++) {
            List<File> expandCopy = new ArrayList<>(expand);
            expand.clear();

            for (File file : expandCopy) {
                if (file.isDirectory()) {
                    List<File> expandIn = Arrays.asList(file.listFiles());
                        for (File fil : expandIn) {
                            if (fil.isDirectory()) {
                                expand.add(fil);
                                directories.add(fil.getAbsolutePath());
                            } else if (fil.isFile() && fil.getName().endsWith(extension)) {
                                files.add(fil.getAbsolutePath());
                            }
                        }
                }
            }
        }

        List<List<String>> result = new ArrayList<>();
        result.add(files);
        result.add(directories);

        return result;
    }

    public static void main(String[] args) {
        File file = new File("E:\\exercises2");
        String extension = ".txt";
        boolean flag = true;

        System.out.println(getArrayList(file,extension,flag));
    }
}