import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

class Drawer {
    int vTextOffset;
    int hGraphOffset;
    int vGraphOffset;
    int hBaseLenght;
    int vBaseLength;
    final int PIECES_COUNT = 32;
    private BufferedImage img;
    private Graphics2D  g2;

    Drawer(int width, int height){
        img = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
        g2 = img.createGraphics();
        g2.fillRect(0,0, width, height);
        g2.setBackground(Color.white);
        g2.setColor(Color.BLACK);
        hBaseLenght = width / (PIECES_COUNT + 1);
        vBaseLength = height / 5 * 3;
        vTextOffset = height / 5 ;
        vGraphOffset = height / 5 / 2 * 9;
        hGraphOffset = hBaseLenght / 2;
    }

    void drawBackground(){
        int localHOffset = hGraphOffset;
        int localVOffset = vGraphOffset;
        Stroke dashed = new BasicStroke(1, BasicStroke.CAP_BUTT, BasicStroke.JOIN_ROUND, 0, new float[]{1, 1}, 0);
        g2.setStroke(dashed);
        for(int i = 0; i<PIECES_COUNT; i++){
            drawVerticalLineUp(localHOffset, localVOffset, vBaseLength);
            drawHorizontalLine(localHOffset, localVOffset - vBaseLength/2, hBaseLenght);
            localHOffset += hBaseLenght;
        }
        g2.setStroke(new BasicStroke(1));
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
