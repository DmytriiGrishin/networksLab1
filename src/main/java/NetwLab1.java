import java.math.BigInteger;
import java.nio.charset.Charset;

public class NetwLab1{
    public static void main(String[] args) {
        String input = args[0] + " " + args[1] + " " + args[2];
        byte[] bytes = StringUtils.encode(input, "cp1251");
        String hexedInput = StringUtils.toHex(bytes);
        System.out.println(hexedInput);
        String binary = StringUtils.toBinary(bytes);
        System.out.println(binary);

        NRZGraph nrzGraph = new NRZGraph(800, 200);
        nrzGraph.doMagic(binary);
    }

}