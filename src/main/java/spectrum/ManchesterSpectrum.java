package spectrum;

import java.util.HashMap;

public class ManchesterSpectrum extends Spectrum {
    public ManchesterSpectrum(String text){
        intervals = new HashMap<Integer, Integer>();
        byte[] bytes = text.getBytes();
        int[] bits = new int[bytes.length];
        bitsLength = bits.length;
        for(int i = 0; i < bits.length; i++) {
            bits[i] = bytes[i] - 48;
        }
        int state = bits[0];
        for(int i = 1; i < bits.length; i++) {
            int currentBit = bits[i] ;
            if(currentBit != state){
                Integer currentCountInMap = intervals.get(2);
                intervals.put(2, (currentCountInMap == null) ? 1 : currentCountInMap + 1);
            } else {
                Integer currentCountInMap = intervals.get(1);
                intervals.put(1, (currentCountInMap == null) ? 1 : currentCountInMap + 1);
            }
            state = currentBit;
        }
        intervals.put(1, intervals.get(1) == null ? 1 : intervals.get(1) + 1 );
    }

    public Double getMax(int c){
        return (double)(c)*7;
    }

    public Double getF0(int c){
        return (double)c;
    }

    public Double getMin(int c) {
        return (double)c/2;
    }

    public Double getMean(int c) {
        double mean = 0.0;
        for (Integer i : intervals.keySet()) {
            mean += c * intervals.get(i) / i;
        }
        return mean / bitsLength;
    }
}
