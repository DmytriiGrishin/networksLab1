import graphics.*;
import spectrum.*;
import utils.LogicCoding;
import utils.StringUtils;

import java.lang.reflect.Array;

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

        System.out.println(nrzSpectrum.toString(c));


        RZGraph rzGraph = new RZGraph(width, height);
        rzGraph.doMagic(binary);

        RZSpectrum rzSpectrum = new RZSpectrum(binary);
        System.out.println("RZ:");
        System.out.println(rzSpectrum.toString(c));

        AMIGraph amiGraph = new AMIGraph(width, height);
        amiGraph.doMagic(binary);

        NRZIGraph nrziGraph = new NRZIGraph(width, height);
        nrziGraph.doMagic(binary);

        NRZISpectrum nrziSpectrum = new NRZISpectrum(binary);
        System.out.println("NRZI:");
        System.out.println(nrziSpectrum.toString(c));

        ManchesterGraph manchesterGraph = new ManchesterGraph(width, height);
        manchesterGraph.doMagic(binary);

        ManchesterSpectrum manchesterSpectrum= new ManchesterSpectrum(binary);
        System.out.println("Manchester:");
        System.out.println(manchesterSpectrum.toString(c));

        ManchesterDiscreteGraph manchesterDiscreteGraph = new ManchesterDiscreteGraph(width, height);
        manchesterDiscreteGraph.doMagic(binary);

        ManchesterDiscreteSpectrum manchesterDiscreteSpectrum = new ManchesterDiscreteSpectrum(binary);
        System.out.println("Manchester discrete:");
        System.out.println(manchesterDiscreteSpectrum.toString(c));

        String logicCodedbinaryWithSpasec = LogicCoding.encode(binary);
        String logicCodedbinary = logicCodedbinaryWithSpasec.replaceAll("\\s", "");
        System.out.println("Binary: " +logicCodedbinaryWithSpasec + "\nBits = " + logicCodedbinary.length());
        String logicHexed = StringUtils.binaryToHex(logicCodedbinary);
        System.out.println("Hexed: " + logicHexed + "\nBytes = " + logicHexed.length()/2);

        NRZIGraph nrziLoicGraph = new NRZIGraph(width, height);
        nrziLoicGraph.doMagic(logicCodedbinary);

        NRZISpectrum nrziLogicSpectrum = new NRZISpectrum(logicCodedbinary);
        System.out.println("NRZI logic:");
        System.out.println(nrziLogicSpectrum.toString(c));

        ManchesterDiscreteGraph manchesterLogicDiscreteGraph = new ManchesterDiscreteGraph(width, height);
        manchesterLogicDiscreteGraph.doMagic(logicCodedbinary);

        ManchesterDiscreteSpectrum manchesterLogicDiscreteSpectrum = new ManchesterDiscreteSpectrum(logicCodedbinary);
        System.out.println("Manchester discrete logic:");
        System.out.println(manchesterLogicDiscreteSpectrum.toString(c));
    }

}