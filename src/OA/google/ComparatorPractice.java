package OA.google;

import java.util.*;

public class ComparatorPractice {
    class SomeNode implements Comparable<SomeNode> {
        public int value;
        public String name;
        public SomeNode next;
        SomeNode (String name, int value) {
            this.name = name;
            this.value = value;
        }

//        public int compareTo(SomeNode o2) {
//            return this.name.compareTo(o2.name);
//        }

        @Override
        public int compareTo(SomeNode o) {
            return o.name.compareTo(this.name);
        }
    }

    PriorityQueue<SomeNode> minAtTop = new PriorityQueue<>(new Comparator<SomeNode>() {
        @Override
        public int compare(SomeNode o1, SomeNode o2) {
            return o1.name.compareTo(o2.name);
        }
    });
}


