package spectrum;

import java.util.HashMap;
@Deprecated
public class AMISpectrum {

    private HashMap<Integer, Integer> intervals;
    private int bitsLength;
    public AMISpectrum(String text){
        intervals = new HashMap<Integer, Integer>();
        byte[] bytes = text.getBytes();
        int[] bits = new int[bytes.length];
        bitsLength = bits.length;
        for(int i = 0; i < bits.length; i++) {
            bits[i] = bytes[i] - 48;
        }
        int counter = 0;
        for(int i = 1; i < bits.length; i++) {
            int currentBit = bits[i] ;
            if(currentBit == 0){
                counter++;
            } else {
                if(counter != 0) {
                    intervals.put(counter, intervals.get(counter) == null ? 1 : intervals.get(counter) + 1);
                }
                Integer currentCountInMap = intervals.get(1);
                intervals.put(1, (currentCountInMap == null) ? 1 : currentCountInMap + 1);
                counter = 0;
            }
        }
       // intervals.put(1, intervals.get(counter) == null ? 1 : intervals.get(counter) +1 );
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

    public Double getMean(int c) {
        double mean = 0.0;
        for (Integer i : intervals.keySet()) {
            mean += c / 2  * intervals.get(i);
        }
        return mean / bitsLength;
    }
}
