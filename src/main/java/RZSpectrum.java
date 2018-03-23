import java.util.HashMap;

public class RZSpectrum {
    private HashMap<Integer, Integer> intervals;
    private int bitsLength;
    RZSpectrum(String text){
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
                if(drop){
                    Integer currentCountInMap = intervals.get(counter);
                    intervals.put(4, (currentCountInMap == null) ? 1 : currentCountInMap + 1);
                    counter = 1;
                    drop = false;
                } else {
                    counter ++;
                    drop = true;
                }
                state = currentBit;
            } else {
                Integer currentCountInMap = intervals.get(counter);
                intervals.put(counter, (currentCountInMap == null) ? 1 : currentCountInMap + 1);
                counter = 1;
                drop = false;
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

    public Double getMean(int c) {
        double mean = 0.0;
        for (Integer i : intervals.keySet()) {
            mean += c  * intervals.get(i);
        }
        return mean / bitsLength;
    }
}
