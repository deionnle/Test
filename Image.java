import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Image {
    public static void convertImages(String ext1, String ext2) {
        // Создаю объект File (текущий каталог)
        File directory = new File(".");
        // Получаю список всех файлов каталога
        File[] files = directory.listFiles();
        // Если спикок файлов не пустой
        if (files != null) {
            // Цикл по всем файлам
            for (File file : files) {
                // Если имя файла заканчивается нужным расширением
                if (file.getName().endsWith(ext1)) {
                    try {
                        // Считываю файл в буфер
                        BufferedImage img = ImageIO.read(file);
                        // Меняю цвет каждого пикселя на красный
                        for (int x = 0; x < img.getWidth(); x++) {
                            for (int y = 0; y < img.getHeight(); y++) {
                                img.setRGB(x, y, Color.RED.getRGB());
                            }
                        }
                        // Получаю доступ к графической части (холсту)
                        Graphics2D g = img.createGraphics();
                        // Задаю размеры прямоугольника, цвет и располагаю на холсте в нужных координатах
                        int w = 500, h = 500;
                        g.setColor(Color.white);
                        g.fillRect((img.getWidth()-w)/2, (img.getHeight()-h)/2, w, h);
                        // Задаю цвет и добавляю текст
                        g.setColor(Color.black);
                        g.drawString("Hello,", (img.getWidth()/2), (img.getHeight()/2));
                        g.drawString("World!", (img.getWidth()/2), (img.getHeight()/2+15));
                        // Освобождаю холст
                        g.dispose();
                        // Переименовываю файл
                        String newImgName = file.getName().replace(ext1, ext2);
                        // Записываю итоговое изображение с новым именем
                        ImageIO.write(img, ext2, new File(directory, newImgName));
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                }
            }
        }
    }
    public static void main(String[] args) throws RuntimeException {
        // Создаю несколько изображений чтобы не делать вручную
        for (int i = 1; i < 4; i ++) {
            BufferedImage img = new BufferedImage(1000, 1000, BufferedImage.TYPE_INT_RGB);
            try {
                ImageIO.write(img, "png", new File("img" + i + ".png"));
                ImageIO.write(img, "jpg", new File("image" + i + ".jpg"));
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

        String ext1 = "png";
        String ext2 = "jpg";

        convertImages(ext1, ext2);
    }
}
