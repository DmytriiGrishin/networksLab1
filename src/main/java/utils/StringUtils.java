package utils;

import java.math.BigInteger;
import java.nio.charset.Charset;

public class StringUtils {

    public static byte[] encode(String text, String charset){
        return text.getBytes(Charset.forName(charset));
    }

    public static String toHex(byte[] bytes) {
        return String.format("%010x", new BigInteger(1, bytes));
    }

    public static String toHex(String text, String charset) {
        byte[] bytes = encode(text, charset);
        return String.format("%010x", new BigInteger(1, bytes));
    }

    public static String toBinary(byte[] bytes){
        StringBuilder builder = new StringBuilder();
        for(byte i: bytes) {
            builder.append(Integer.toBinaryString(i & 0xFF));
        }
        return builder.toString();
    }

    public static String toBinary(String text, String charset){
        byte[] bytes = encode(text, charset);
        StringBuilder builder = new StringBuilder();
        for(byte i: bytes) {
            builder.append(Integer.toBinaryString(i & 0xFF));
        }
        return builder.toString();
    }
}
