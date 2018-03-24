package graphics;

public class NRZIGraph extends Drawer {
    private boolean isUp;
    public NRZIGraph(int width, int height){
        super(width,height);
        isUp = false;
        drawBackground();
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
        save("NRZI", "png");
    }

    private void draw1(){
        drawText(getHTextOffset(), vTextOffset, "1");
        if(!isUp) {
            drawVerticalLineUp(hGraphOffset, vGraphOffset, vBaseLength);
            vGraphOffset -= vBaseLength;
            drawHorizontalLine(hGraphOffset, vGraphOffset, hBaseLength);
            hGraphOffset += hBaseLength;
        } else {
            drawVerticalLineDown(hGraphOffset, vGraphOffset, vBaseLength);
            vGraphOffset += vBaseLength;
            drawHorizontalLine(hGraphOffset, vGraphOffset, hBaseLength);
            hGraphOffset += hBaseLength;
        }
    }

    private void draw0(){
        drawText(getHTextOffset(), vTextOffset, "0");
        drawHorizontalLine(hGraphOffset, vGraphOffset, hBaseLength);
        hGraphOffset += hBaseLength;
    }

}
