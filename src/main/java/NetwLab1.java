import java.math.BigInteger;
import java.nio.charset.Charset;

public class NetwLab1{
    public static void main(String[] args) {
        String input = args[0] + " " + args[1] + " " + args[2];
        byte[] bytes = StringUtils.encode(input, "cp1251");
        String hexedInput = StringUtils.toHex(bytes);
        System.out.println("Hexed: " + hexedInput + "\nBytes = " + hexedInput.length()/2);
        String binary = StringUtils.toBinary(bytes);
        System.out.println("Binary: " +binary + "\nBits = " + binary.length());
        NRZGraph nrzGraph = new NRZGraph(800, 200);
        nrzGraph.doMagic(binary);

        NRZSpectrum nrzSpectrum = new NRZSpectrum(binary);
        System.out.println("NRZ:");
        System.out.println("Max freq in hz: " + nrzSpectrum.getMax(1000000));
        System.out.println("Min freq in hz: " + nrzSpectrum.getMin(1000000));

        System.out.println("Mean freq in hz: " + nrzSpectrum.getMean(1000000));
    }

}