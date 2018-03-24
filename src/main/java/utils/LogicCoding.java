package utils;

import java.util.HashMap;

public class LogicCoding {
    private static final HashMap<String, String> coddingTable = new HashMap<String, String>(){{
        put("0000", "11110");
        put("0001", "01001");
        put("0010", "10100");
        put("0011", "10101");
        put("0100", "01010");
        put("0101", "01011");
        put("0110", "01110");
        put("0111", "01111");
        put("1000", "10010");
        put("1001", "10011");
        put("1010", "10110");
        put("1011", "10111");
        put("1100", "11010");
        put("1101", "11011");
        put("1110", "11100");
        put("1111", "11101");
    }};

    public static String encode(String str){
        StringBuilder stringBuilder = new StringBuilder();
        for(int i = 0; i < str.length(); i += 4){
            stringBuilder.append(coddingTable.get(str.substring(i, i+4)));
        }

        return stringBuilder.toString();
    }
}
