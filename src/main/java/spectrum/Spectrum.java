package spectrum;

import java.util.HashMap;

public class Spectrum {
     HashMap<Integer, Integer> intervals;
     int bitsLength;
    public String toString(int c){
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("f0 : " + getF0(c)/1000+ "mhz");
        stringBuilder.append("Max freq: " + getMax(c) /1000 + "mhz\n");
        stringBuilder.append("Min freq: " + getMin(c) /1000+ "mhz\n");
        stringBuilder.append("S = " + getF0(c) /1000 + " - " + getMin(c) /1000 + " = " + (getF0(c) /1000 - getMin(c) /1000) );
        stringBuilder.append("F = " + getMax(c) /1000 + " - " + getMin(c) /1000 + " = " + (getMax(c) /1000 - getMin(c) /1000) );
        stringBuilder.append("\nMean freq: \nfср = (");// + getMean(c) /1000 + "mhz\n");
        for(Integer i: intervals.keySet()){
            stringBuilder.append(intervals.get(i) + "*" + c/i/1000 + " + ");
        }
        stringBuilder.append(") /" + bitsLength + " = " + getMean(c)/1000 + "\n");
        return stringBuilder.toString();
    }

    public Double getF0(int c){
        return null;
    }
    public Double getMax(int c){
        return null;
    }
    public Double getMin(int c){
        return null;
    }
    public Double getMean(int c){
        return null;
    }

}
