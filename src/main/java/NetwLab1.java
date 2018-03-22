import java.math.BigInteger;
import java.nio.charset.Charset;

public class NetwLab1{
    public static void main(String[] args) {
        String input = args[0] + " " + args[1] + " " + args[2];
        byte[] binaryArray = input.getBytes(Charset.forName("cp1251"));
        String hexedInput = toHex(binaryArray);
        System.out.println(hexedInput);
        String binary;
        StringBuilder builderForBinary = new StringBuilder();
        for(byte i: binaryArray) {
            builderForBinary.append(Integer.toBinaryString(i & 0xFF));
        }
        binary = builderForBinary.toString();
        System.out.println(binary);

        NRZGraph nrzGraph = new NRZGraph(800, 200);
        nrzGraph.doMagic(binary);
    }
    private static String toHex(byte[] binary) {
        return String.format("%010x", new BigInteger(1, binary));
    }
}