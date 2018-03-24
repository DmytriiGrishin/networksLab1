package utils;

import java.lang.reflect.Array;
import java.math.BigInteger;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;

public class StringUtils {

    public static byte[] encode(String text, String charset){
        return text.getBytes(Charset.forName(charset));
    }

    public static String toHex(byte[] bytes) {
        return String.format("%010x", new BigInteger(1, bytes));
    }

    public static String toHex(Object[] bytes) {
        byte[] newBytes = new byte[bytes.length];
        for(int i = 0; i < bytes.length; i++){
            newBytes[i] = (Byte)bytes[i];
        }
        return String.format("%020X", new BigInteger(1, newBytes));
    }

    public static String toHex(String text, String charset) {
        byte[] bytes = encode(text, charset);
        return String.format("%010X", new BigInteger(1, bytes));
    }

    public static String toBinary(byte[] bytes){
        StringBuilder builder = new StringBuilder();
        for(byte i: bytes) {
            builder.append(String.format("%8s", Integer.toBinaryString(i & 0xFF)).replace(' ', '0'));
        }
        return builder.toString();
    }

    public static String toBinary(String text, String charset){
        byte[] bytes = encode(text, charset);
        StringBuilder builder = new StringBuilder();
        for(byte i: bytes) {
            builder.append(String.format("%4s", Integer.toBinaryString(i & 0xFF)).replace(' ', '0'));
        }
        return builder.toString();
    }
    public static String binaryToHex(String binary){
        ArrayList<Byte> bytes = new ArrayList<Byte>();
        for(int i = 0; i < binary.length(); i += 4){
            bytes.add(Byte.parseByte(binary.substring(i, i+4),2));
        }
        ArrayList<Byte> newbBytes = new ArrayList<Byte>();
        for(int i=0; i < bytes.size(); i+=2){
            newbBytes.add((byte)(bytes.get(i)*16 +bytes.get(i+1)));
        }
        return toHex(newbBytes.toArray());
    }
}
