import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Drawer {
    private BufferedImage img;
    private Graphics2D  g2;
    public Drawer(int width, int height){
        img = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
        g2 = img.createGraphics();
    }
    public void drawHorizontalLine(int x, int y, int length){
        g2.drawLine(x, y, x + length, y);
    }
    public void drawVerticalLine(int x, int y, int length){
        g2.drawLine(x, y, x, y + length);
    }
    public void drawText(int x, int y, String text){
        g2.drawString(text, x, y);
    }
    public void save(String fileName, String format) {
        try {
            File outF = new File(fileName + "." + format);
            ImageIO.write(img, format, outF);
        } catch (IOException e){
            System.out.println(e.getMessage());
        }
    }
}
