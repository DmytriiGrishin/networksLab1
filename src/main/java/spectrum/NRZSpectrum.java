package spectrum;

import java.util.HashMap;

public class NRZSpectrum extends Spectrum {
    public NRZSpectrum(String text){
        intervals = new HashMap<Integer, Integer>();
        byte[] bytes = text.getBytes();
        int[] bits = new int[bytes.length];
        bitsLength = bits.length;
        for(int i = 0; i < bits.length; i++) {
            bits[i] = bytes[i] - 48;
        }
        int state = bits[0];
        int counter = 1;
        for(int i = 1; i < bits.length; i++) {
            int currentBit = bits[i] ;
            if(currentBit == state){
                counter++;
            } else {
                state = currentBit;
                Integer currentCountInMap = intervals.get(counter);
                intervals.put(counter, (currentCountInMap == null) ? 1 : currentCountInMap + 1);
                counter = 1;
            }
        }
        intervals.put(counter, intervals.get(counter) == null ? 1 : intervals.get(counter) +1 );
    }

    public Double getMax(int c){
        return (double)(c)/2*7;
    }

    public Double getMin(int c) {
        double min;
        int maxInterval = 0;
        for (Integer i : intervals.keySet()) {
            if (i > maxInterval) {
                maxInterval = i;
            }
        }
        min = (double) c / (maxInterval * 2);
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
        f0 = (double) c / (minInterval * 2);
        return f0;
    }
    public Double getMean(int c) {
        double mean = 0.0;
        for (Integer i : intervals.keySet()) {
            mean += c / 2  * intervals.get(i);
        }
        return mean / bitsLength;
    }

}
