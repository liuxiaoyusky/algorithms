package CrossTrainingIII;

import Recursion.ListNode;

import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class MergeKSortedLists {
    //Use pq
    class Entry {
        int value;
        ListNode node;
        public Entry(int value, ListNode node) {
            this.value = value;
            this.node = node;
        }
    }

    class NewComparator implements Comparator<Entry> {
        @Override
        public int compare(Entry o1, Entry o2) {
            if (o1.value == o2.value) {
                return 0;
            }
            return o1.value < o2.value ? -1 : 1;
        }
    }

    public ListNode merge(List<ListNode> listOfLists) {
        ListNode dummy = new ListNode(0);
        ListNode cur = dummy;
        int size = listOfLists.size();
        if (size < 1) {
            return dummy.next;
        }
        PriorityQueue<Entry> pq = new PriorityQueue<>(size, new NewComparator());
        for(ListNode node : listOfLists) {
            pq.offer(new Entry(node.key, node));
        }

        while(!pq.isEmpty()) {
            Entry entry = pq.poll();
            cur.next = entry.node;
            cur = cur.next;
            ListNode next = entry.node.next;
            cur.next = null;
            if (next != null) {
                entry.node = next;
                entry.value = next.key;
                pq.offer(entry);
            }
        }

        return dummy.next;
    }
}
