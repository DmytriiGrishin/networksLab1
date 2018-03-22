import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

class Drawer {
    private BufferedImage img;
    private Graphics2D  g2;

    Drawer(int width, int height){
        img = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
        g2 = img.createGraphics();
        g2.fillRect(0,0, width, height);
        g2.setBackground(Color.white);
        g2.setColor(Color.BLACK);
    }

    void drawHorizontalLine(int x, int y, int length){
        g2.drawLine(x, y, x + length, y);
    }

    void drawVerticalLineUp(int x, int y, int length){
        g2.drawLine(x, y, x, y - length);
    }

    void drawVerticalLineDown(int x, int y, int length){
        g2.drawLine(x, y, x, y + length);
    }

    void drawText(int x, int y, String text){
        g2.drawString(text, x, y);
    }

    void save(String fileName, String format) {
        try {
            File outF = new File(fileName + "." + format);
            ImageIO.write(img, format, outF);
        } catch (IOException e){
            System.out.println(e.getMessage());
        }
    }
}
