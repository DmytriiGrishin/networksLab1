//TODO Refactor and draw background
public class NRZGraph extends Drawer{
    private int vTextOffset;
    private int hGraphOffset;
    private int vGraphOffset;
    private int hBaseLenght;
    private int vBaseLength;
    private int prevState;
    private final int PIECES_COUNT = 78;

    public NRZGraph(int width, int height){
        super(width, height);
        hBaseLenght = width / (PIECES_COUNT + 1);
        vBaseLength = height / 5 * 3;
        vTextOffset = height / 5 ;
        vGraphOffset = height / 5 / 2 * 9;
        hGraphOffset = hBaseLenght / 2;
        prevState = 0;
    }

    public void doMagic(String text){
        String str = text;
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
        drawHorizontalLine(hGraphOffset, vGraphOffset, hBaseLenght);
        hGraphOffset += hBaseLenght;
        prevState = 1;
    }

    private void draw0(){
        drawText(getHTextOffset(), vTextOffset, "0");
        if(prevState == 1){
            drawVerticalLineDown(hGraphOffset, vGraphOffset, vBaseLength);
            vGraphOffset += vBaseLength;
        }
        drawHorizontalLine(hGraphOffset, vGraphOffset, hBaseLenght);
        hGraphOffset += hBaseLenght;
        prevState = 0;
    }

    private int getHTextOffset(){
        return hGraphOffset + hBaseLenght / 3;
    }

}
