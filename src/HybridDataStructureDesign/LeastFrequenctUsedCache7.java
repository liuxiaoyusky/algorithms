package HybridDataStructureDesign;

import java.util.HashMap;
import java.util.Map;

public class LeastFrequenctUsedCache7 {
    class TimeNode {
        TimeNode prev;
        TimeNode next;
        int value;
        int key;
        public TimeNode(int key, int value) {
            this.key = key;
            this.value = value;
            prev = null;
            next = null;
        }
    }

    class FreqNode {
        FreqNode prev;
        FreqNode next;
        TimeNode head;
        TimeNode tail;
        int freq;
        FreqNode(int freq) {
            this.freq = freq;
            prev = next = null;
            head = tail = null;
        }

        public boolean isEmpty() {
            return this.head == null && this.tail == null;
        }
    }

    private FreqNode freHead;
    private FreqNode freTail;
    private Map<Integer, TimeNode> cache;
    private Map<Integer, FreqNode> freqMap;
    final int CAP;

    public LeastFrequenctUsedCache7(int c) {
        this.CAP = c;
        freHead = freTail = null;
        cache = new HashMap<>();
        freqMap = new HashMap<>();
    }

    public int get(int key) {
        if (cache.containsKey(key)) {
            TimeNode timeNode = cache.get(key);
            FreqNode freqNode = freqMap.get(key);
            updateFreq(freqNode, timeNode);
            return timeNode.value;
        } else {
            return -1;
        }
    }

    private void updateFreq(FreqNode freq, TimeNode time) {
        int curFreq = freq.freq;
        FreqNode nextFreq = freq.next;

        //next frequency node
        if (nextFreq == null || nextFreq.freq != curFreq + 1) {
            nextFreq = new FreqNode(curFreq + 1);
            insertFreqNode(freq, nextFreq);//put new after cur
        }

        //remove cur timeNode from cur freq
        removeTimeNode(freq, time);


        //remove freqNode if needed
        if (freq.isEmpty()) {
            removeFreqNode(freq);
        }

        //insert time node to new freq
        insertTimeNode(nextFreq, time);

        int key = time.key;
        cache.put(key, time);
        freqMap.put(key, nextFreq);
    }

    //put it at last
    private void insertTimeNode(FreqNode freq, TimeNode time) {
        if (freq.head == null && freq.tail == null) {
            freq.head = freq.tail = time;
        } else {
            freq.tail.next = time;
            time.prev = freq.tail;
            freq.tail = time;
        }
    }

    private void removeFreqNode(FreqNode freq) {
        FreqNode prev = freq.prev;
        FreqNode next = freq.next;
        //remove the only node
        if (prev == null && next == null) {
            freHead = freTail = null;
        }

        //remove head node
        else if (prev == null) {
            freHead = freHead.next;
            freHead.prev = null;
        }

        //remove tail node
        else if (next == null) {
            freTail = freTail.prev;
            freTail.next = null;
        }

        else {
            prev.next = next;
            next.prev = prev;
        }

        freq.next = null;
        freq.prev = null;
    }

    private void removeTimeNode(FreqNode freq, TimeNode time) {
        TimeNode prev = time.prev;
        TimeNode next = time.next;
        //remove the only node
        if (prev == null && next == null) {
            freq.head = freq.tail = null;
        }

        //remove head node
        else if (prev == null) {
            freq.head = freq.head.next;
            freq.head.prev = null;
        }

        //remove tail node
        else if (next == null) {
            freq.tail = freq.tail.prev;
            freq.tail.next = null;
        }

        else {
            prev.next = next;
            next.prev = prev;
        }

        time.next = null;
        time.prev = null;
    }

    private void insertFreqNode(FreqNode prev, FreqNode cur) {
        //first freq node
        if (freHead == null && freTail == null) {
            freHead = cur;
            freTail = cur;
        } else if (prev == null) {
            //make cur new head
            cur.next = freHead;
            freHead.prev = cur;
            freHead = cur;
        }
        //new tail
        else if (prev.next == null) {
            cur.prev = prev;
            prev.next = cur;
            freTail = cur;
        }

        //middle: prev cur next
        else {
            FreqNode next = prev.next;
            prev.next = cur;
            cur.prev = prev;
            cur.next= next;
            next.prev = cur;
        }
    }


    public void put(int key, int value) {
        if (CAP == 0) {
            return;
        }
        if (cache.containsKey(key)) {
            TimeNode time = cache.get(key);
            FreqNode freq = freqMap.get(key);
            time.value = value;
            updateFreq(freq, time);
            return;
        } else {
            //delete if needed
            if (cache.size() >= CAP) {
                //remove least freqency or least recent used for same frequency
                FreqNode toRemoveFreq = this.freHead;
                TimeNode toRemoveTime = freHead.head;
                removeTimeNode(toRemoveFreq, toRemoveTime);
                cache.remove(toRemoveTime.key);
                freqMap.remove(toRemoveTime.key);
                if (toRemoveFreq.isEmpty()) {
                    removeFreqNode(toRemoveFreq);
                }
            }
            //insert new
            insertNewKeyValue(key, value);
            return;
        }
    }

    private void insertNewKeyValue(int key, int value) {
        TimeNode time = new TimeNode(key, value);
        if (freHead == null || freHead.freq != 1) {
            FreqNode freq = new FreqNode(1);
            insertFreqNode(null, freq);
            insertTimeNode(freq, time);
            freqMap.put(key, freq);
            cache.put(key, time);
        } else {
            insertTimeNode(freHead, time);
            freqMap.put(key, freHead);
            cache.put(key, time);
        }
    }

    public static void main(String [] args) {
        LeastFrequenctUsedCache7 l = new LeastFrequenctUsedCache7(2);
        l.put(1,1);
        l.put(2,2);
        l.get(1);
        l.put(3,3);
        l.get(2);
        l.get(3);
        l.put(4,4);
        l.get(1);
        l.get(3);
        l.get(4);
    }
}
