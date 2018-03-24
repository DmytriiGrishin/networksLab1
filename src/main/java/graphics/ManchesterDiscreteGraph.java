package graphics;

public class ManchesterDiscreteGraph extends Drawer {
    private boolean isUp;
    public ManchesterDiscreteGraph(int width, int height){
        super(width, height);
        drawBackground();
        hBaseLength /= 2;
        vGraphOffset -= vBaseLength;
        isUp = true;
    }

    public void doMagic(String text){
        String str = text.substring(0, 31);
        char[] chars = str.toCharArray();
        for(char symbol: chars){
            if(symbol == '1'){
                draw1();
                isUp = !isUp;
            } else {
                draw0();
            }

        }
        save("ManchesterDiscrete", "png");
    }

    private void draw0(){
        drawText(getHTextOffset(), vTextOffset, "0");
        if(isUp) {
            drawVerticalLineDown(hGraphOffset, vGraphOffset, vBaseLength);
            vGraphOffset += vBaseLength;
            drawHorizontalLine(hGraphOffset, vGraphOffset, hBaseLength);
            hGraphOffset += hBaseLength;
            drawVerticalLineUp(hGraphOffset, vGraphOffset, vBaseLength);
            vGraphOffset -= vBaseLength;
            drawHorizontalLine(hGraphOffset, vGraphOffset, hBaseLength);
            hGraphOffset += hBaseLength;
        } else {
            drawVerticalLineUp(hGraphOffset, vGraphOffset, vBaseLength);
            vGraphOffset -= vBaseLength;
            drawHorizontalLine(hGraphOffset, vGraphOffset, hBaseLength);
            hGraphOffset += hBaseLength;
            drawVerticalLineDown(hGraphOffset, vGraphOffset, vBaseLength);
            vGraphOffset += vBaseLength;
            drawHorizontalLine(hGraphOffset, vGraphOffset, hBaseLength);
            hGraphOffset += hBaseLength;
        }

    }

    private void draw1(){
        drawText(getHTextOffset(), vTextOffset, "1");
        if(isUp) {
            drawHorizontalLine(hGraphOffset, vGraphOffset, hBaseLength);
            hGraphOffset += hBaseLength;
            drawVerticalLineDown(hGraphOffset, vGraphOffset, vBaseLength);
            vGraphOffset += vBaseLength;
            drawHorizontalLine(hGraphOffset, vGraphOffset, hBaseLength);
            hGraphOffset += hBaseLength;
        } else {
            drawHorizontalLine(hGraphOffset, vGraphOffset, hBaseLength);
            hGraphOffset += hBaseLength;
            drawVerticalLineUp(hGraphOffset, vGraphOffset, vBaseLength);
            vGraphOffset -= vBaseLength;
            drawHorizontalLine(hGraphOffset, vGraphOffset, hBaseLength);
            hGraphOffset += hBaseLength;
        }
    }
}
