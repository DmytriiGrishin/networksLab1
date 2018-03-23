import java.util.HashMap;

public class NRZSpectrum {
    private HashMap<Integer, Integer> intervals;
    private Double mean;
    private Double max;
    private Double min;

    NRZSpectrum(String text){
        intervals = new HashMap<Integer, Integer>();
        byte[] bytes = text.getBytes();
        int[] bits = new int[bytes.length];
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

    public Double getMax(){
        if(max == null){

            for(Integer i: intervals.keySet()){

            }
        }
        return max;
    }
}
