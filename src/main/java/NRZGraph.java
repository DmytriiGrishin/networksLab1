public class NRZGraph extends Drawer{
    private int prevState;

    public NRZGraph(int width, int height){
        super(width, height);
        prevState = 0;
    }

    public void doMagic(String text){
        drawBackground();
        String str = text.substring(0, 31);
        char[] chars = str.toCharArray();
        for(char symbol: chars){
            if(symbol == '1'){
                draw1();
            } else {
                draw0();
            }
        }
        save("NRZ", "png");
    }

    private void draw1(){
        drawText(getHTextOffset(), vTextOffset, "1");
        if(prevState == 0){
            drawVerticalLineUp(hGraphOffset, vGraphOffset, vBaseLength);
            vGraphOffset -= vBaseLength;
        }
        drawHorizontalLine(hGraphOffset, vGraphOffset, hBaseLength);
        hGraphOffset += hBaseLength;
        prevState = 1;
    }

    private void draw0(){
        drawText(getHTextOffset(), vTextOffset, "0");
        if(prevState == 1){
            drawVerticalLineDown(hGraphOffset, vGraphOffset, vBaseLength);
            vGraphOffset += vBaseLength;
        }
        drawHorizontalLine(hGraphOffset, vGraphOffset, hBaseLength);
        hGraphOffset += hBaseLength;
        prevState = 0;
    }

    private int getHTextOffset(){
        return hGraphOffset + hBaseLength / 3;
    }

}
