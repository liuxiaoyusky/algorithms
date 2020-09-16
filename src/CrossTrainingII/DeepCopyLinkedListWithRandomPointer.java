package CrossTrainingII;
/*
Each of the nodes in the linked list has another pointer pointing to a random node in the list or null.
Make a deep copy of the original list.
 */

import java.util.HashMap;

public class DeepCopyLinkedListWithRandomPointer {
    static class RandomListNode {
        public int value;
        public RandomListNode next;
        public RandomListNode random;
        public RandomListNode(int value) {
            this.value = value;
        }
    }

    public RandomListNode copy(RandomListNode head) {
        // naive solution: two rounds, first round copy value and next, second round copy random
        //three cases in random:
        //pointing to null, skip
        //pointing to a node before(already copyed)**
        //point to a node after(not yet copyed)**
        //need to check if a node/next/random is exist, if not, create, and link to it--> need a hashmap
        //input:head output:newHead
        HashMap<RandomListNode,RandomListNode> exist = new HashMap<>();//old and new
        RandomListNode dummy = new RandomListNode(0);
        RandomListNode prev = dummy;
        while (head != null) {
            //check if the node exists
            if (!exist.containsKey(head)) {
                exist.put(head, new RandomListNode(head.value));
            }

            //link prev to head
            prev.next = exist.get(head);

            //check if the random exists
            if (head.random != null) {
                if (!exist.containsKey(head.random)) {
                    exist.put(head.random, new RandomListNode(head.random.value));
                }
                prev.next.random = exist.get(head.random);
            }

            //go to next node
            prev = prev.next;
            head = head.next;
        }
        return dummy.next;
    }
}