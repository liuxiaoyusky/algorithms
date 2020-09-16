package HashTableAndString;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class TopKFrequent {
    public String [] topKFrenquent(String [] combo,int k){
        if(combo.length==0){
            return new String[0];
        }
        Map<String,Integer> freqMap=getFreqMap(combo);
        PriorityQueue<Map.Entry<String,Integer>> minHeap=new PriorityQueue<>(k,
                new Comparator<Map.Entry<String,Integer>>(){
                    @Override
                    public int compare(Map.Entry<String,Integer> e1, Map.Entry<String,Integer> e2){
                        return e1.getValue().compareTo(e2.getValue());
                    }

                });
        for(Map.Entry<String,Integer> entry:freqMap.entrySet()){
            if(minHeap.size()<k){
                minHeap.offer(entry);
            }else if(entry.getValue()>minHeap.peek().getValue()){
                minHeap.poll();
                minHeap.offer(entry);
            }
        }
        return freqArray(minHeap);
    }

    private Map<String, Integer> getFreqMap(String[] combo) {
        Map<String,Integer> freqMap=new HashMap<>();
        for(String str: combo){
            Integer temp=freqMap.get(str);
            if(temp==null){
                freqMap.put(str,1);
            }else{
                freqMap.put(str,temp+1);
            }
        }
        return freqMap;
    }

    private String[] freqArray(PriorityQueue<Map.Entry<String, Integer>> minHeap) {
        return null;
    }
}
