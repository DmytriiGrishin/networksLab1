package spectrum;

import java.util.HashMap;

public class RZSpectrum extends Spectrum {
    public RZSpectrum(String text){
        intervals = new HashMap<Integer, Integer>();
        byte[] bytes = text.getBytes();
        int[] bits = new int[bytes.length];
        bitsLength = bits.length;
        for(int i = 0; i < bits.length; i++) {
            bits[i] = bytes[i] - 48;
        }
        int state = bits[0];
        boolean drop = false;
        int counter = 1;
        for(int i = 1; i < bits.length; i++) {
            int currentBit = bits[i] ;
            if(currentBit != state){
                    Integer currentCountInMap = intervals.get(2);
                    intervals.put(2, (currentCountInMap == null) ? 1 : currentCountInMap + 1);
                    state = currentBit;
            } else {
                    Integer currentCountInMap = intervals.get(1);
                    intervals.put(1, (currentCountInMap == null) ? 1 : currentCountInMap + 1);
            }
        }
        intervals.put(1, intervals.get(1) == null ? 1 : intervals.get(counter) + 1);
    }

    public Double getMax(int c){
        return (double)(c)*7;
    }

    public Double getMin(int c) {
        double min;
        int maxInterval = 0;
        for (Integer i : intervals.keySet()) {
            if (i > maxInterval) {
                maxInterval = i;
            }
        }
        min = (double) c / maxInterval;
        return min;
    }

    public Double getF0(int c){
        double f0;
        int minInterval = Integer.MAX_VALUE;
        for (Integer i : intervals.keySet()) {
            if (i < minInterval) {
                minInterval = i;
            }
        }
        f0 = (double) c / (minInterval );
        return f0;
    }

    public Double getMean(int c) {
        double mean = 0.0;
        for (Integer i : intervals.keySet()) {
            mean += c  * intervals.get(i) / i;
        }
        return mean / bitsLength;
    }
}
