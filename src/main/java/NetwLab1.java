import graphics.AMIGraph;
import graphics.NRZGraph;
import graphics.RZGraph;
import spectrum.NRZSpectrum;
import spectrum.RZSpectrum;
import utils.StringUtils;

public class NetwLab1{
    public static void main(String[] args) {
        int c = 1000000;
        int width = 800, height = 200;
        String input = args[0] + " " + args[1] + " " + args[2];
        byte[] bytes = StringUtils.encode(input, "cp1251");
        String hexedInput = StringUtils.toHex(bytes);
        System.out.println("Hexed: " + hexedInput + "\nBytes = " + hexedInput.length()/2);
        String binary = StringUtils.toBinary(bytes);
        System.out.println("Binary: " +binary + "\nBits = " + binary.length());

        NRZGraph nrzGraph = new NRZGraph(width, height);
        nrzGraph.doMagic(binary);

        NRZSpectrum nrzSpectrum = new NRZSpectrum(binary);
        System.out.println("NRZ:");
        System.out.println("f0 : " + c/2 + "khz");
        System.out.println("Max freq: " + nrzSpectrum.getMax(c) + "khz");
        System.out.println("Min freq: " + nrzSpectrum.getMin(c) + "khz");
        System.out.println("Mean freq: " + nrzSpectrum.getMean(c) + "khz");

        RZGraph rzGraph = new RZGraph(width, height);
        rzGraph.doMagic(binary);

        RZSpectrum rzSpectrum = new RZSpectrum(binary);
        System.out.println("RZ:");
        System.out.println("f0 : " + c + "khz");
        System.out.println("Max freq: " + rzSpectrum.getMax(c) + "khz");
        System.out.println("Min freq: " + rzSpectrum.getMin(c) + "khz");
        System.out.println("Mean freq: " + rzSpectrum.getMean(c) + "khz");

        AMIGraph amiGraph = new AMIGraph(width, height);
        amiGraph.doMagic(binary);
    }

}