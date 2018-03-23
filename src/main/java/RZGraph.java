public class RZGraph extends Drawer {
    RZGraph(int width, int height){
        super(width, height);
        drawBackground();
        vBaseLength /= 2;
        hBaseLength /= 2;
        vGraphOffset -= vBaseLength;
    }

    public void doMagic(String text){
        String str = text.substring(0, 31);
        char[] chars = str.toCharArray();
        for(char symbol: chars){
            if(symbol == '1'){
                draw1();
            } else {
                draw0();
            }
        }
        save("RZ", "png");
    }

    private void draw1(){
        drawText(getHTextOffset(), vTextOffset, "1");
        drawVerticalLineUp(hGraphOffset, vGraphOffset, vBaseLength);
        vGraphOffset -= vBaseLength;
        drawHorizontalLine(hGraphOffset, vGraphOffset, hBaseLength);
        hGraphOffset += hBaseLength;
        drawVerticalLineDown(hGraphOffset,vGraphOffset, vBaseLength);
        vGraphOffset += vBaseLength;
        drawHorizontalLine(hGraphOffset, vGraphOffset, hBaseLength);
        hGraphOffset += hBaseLength;
    }

    private void draw0(){
        drawText(getHTextOffset(), vTextOffset, "0");
        drawVerticalLineDown(hGraphOffset, vGraphOffset, vBaseLength);
        vGraphOffset += vBaseLength;
        drawHorizontalLine(hGraphOffset, vGraphOffset, hBaseLength);
        hGraphOffset += hBaseLength;
        drawVerticalLineUp(hGraphOffset,vGraphOffset, vBaseLength);
        vGraphOffset -= vBaseLength;
        drawHorizontalLine(hGraphOffset, vGraphOffset, hBaseLength);
        hGraphOffset += hBaseLength;
    }

    private int getHTextOffset(){
        return hGraphOffset + hBaseLength / 3;
    }
}
