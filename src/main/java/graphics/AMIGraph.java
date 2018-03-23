package graphics;

public class AMIGraph extends Drawer {
    private boolean wasOnTop;
    public AMIGraph(int wight, int height){
        super(wight, height);
        wasOnTop = false;
        drawBackground();
        vBaseLength /= 2;
        vGraphOffset -= vBaseLength;
    }

    public void doMagic(String text){
        String str = text.substring(0, 31);
        char[] chars = str.toCharArray();
        for(char symbol: chars){
            if(symbol == '1'){
                if(wasOnTop){
                    draw1Down();
                } else {
                    draw1Up();
                }
                wasOnTop = !wasOnTop;
            } else {
                draw0();
            }
        }
        save("AMI", "png");
    }

    private void draw1Up(){
        drawText(getHTextOffset(), vTextOffset, "1");
        drawVerticalLineUp(hGraphOffset, vGraphOffset, vBaseLength);
        vGraphOffset -= vBaseLength;
        drawHorizontalLine(hGraphOffset, vGraphOffset, hBaseLength);
        hGraphOffset += hBaseLength;
        drawVerticalLineDown(hGraphOffset,vGraphOffset, vBaseLength);
        vGraphOffset += vBaseLength;
    }

    private void draw1Down(){
        drawText(getHTextOffset(), vTextOffset, "1");
        drawVerticalLineDown(hGraphOffset, vGraphOffset, vBaseLength);
        vGraphOffset += vBaseLength;
        drawHorizontalLine(hGraphOffset, vGraphOffset, hBaseLength);
        hGraphOffset += hBaseLength;
        drawVerticalLineUp(hGraphOffset,vGraphOffset, vBaseLength);
        vGraphOffset -= vBaseLength;
    }

    private void draw0(){
        drawText(getHTextOffset(), vTextOffset, "0");
        drawHorizontalLine(hGraphOffset, vGraphOffset, hBaseLength);
        hGraphOffset += hBaseLength;
    }

}
