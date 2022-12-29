package HybridDataStructureDesign;

import java.util.*;

/*
https://leetcode.com/problems/lru-cache/

 */
public class LRUCache5 {





    /*
    Step 1: Clarification and Assumption
Cache的本质是什么？
为了不每次都重新检索，先把检索的结果存下来，下次用户访问的时候直接给存好的检索结果
#AIN I'M: Map ‹Key, Value>: get a value by key 0(1)
Look Up Operation(Memo)：如果已经计算过了，直接get上次计算的过，否则就重新算一遍

    Least Recent Used Cache 时间上最早用过的Key
Used:增改查删：insert, update, query delete 都是used
Least Recently Used Cache From Java Side
LRUCache IRUCache = new LRUCache(2);
IRUCache.put(1, 1);
IRUCache.put(2, 2);
IRUCache.get(1);
RUCache.put(3, 3);
IRUCache.get(2);
IRUCache.put(4, 4);
IRUCache.put(3, 5);
2的意思就是这个LRU Cache 最多存两个K-V Pair
LRU: { Key: 1, Value: 1} LRU: {Key: 1, Value:1, Key: 2, Value:2}
{ Key: 1, Value: 1 [01, Key:2, Value:2[1]}
Should return 1，现在谁新？{Key:1,Value:1[21, Key:2,Value:2r11}LRU capacity was 2,满了 踢出一个最1日用过的Key, Evicts key 2,
Cache is {Key: 1, Value: 1 [2], Key:3, Value: 3[3]}
Returns null (Key not found)
LRU capacity was 2,满了，踢出一个最1日用过的Key,Evicts key 1,
Cache is {Key:4, Value:4[4], Key:3, Value: 3[31} Cache is {Key:4, Value:4[4], Key:3, Value:5[5]}

Step 2: Finalize Operations
get(key):
-map里不存在这个key, retur nullmap里存在这个key
- return node key£] value
- [a]ls=update 7-irgeti Noded]HJia] update() -> delete() + insert()
put(key, value)
Case 1:map里存在这个key
相当于update ：1.真的update value
2. update time info update() -› delete() + insert()
Case 2:map里不存在这个key
如果有地儿：直接insert
满了：踢出最老的key + insert -, delete( + insert(
Step 3: Proposal Different Data Structure and Compare then Finalize Solution
因为cache 天然就是个key-value pair，所以一定要用到HashMap，所有关于hashmap insert, lookup 操作都是0(1）
但是这儿还有一个要求，要能够踢出最老的key一，跟顺序有关

Hash-Based 数据结构特点是无序性
set.add(1)
set.add(2)
set.add(3)
一>
set: (2,3,1) (1,2,3) (3, 1,2).....
如果只用一个Map来存的话 必须要Keep 时间节点 本身Map是无序的 不能保证先放进来的东西一定存在前面必须要自己Keep时间信
息
既然Map不能保持时间顺序，有没有数据结构可以保持时问顺序？
复习一下，跟顺序有关的数据结构有哪些？
-55^#Heap(PriorityQueue) - Partially ordered,
- TreeSet/TreeMap - fully ordered
- Sorted array/arraylist - fully ordered

get(key):
-map里不存在这个key,return null o(1)
-map里存在这个key
- return node key value
O(1)
-同时要update这一次get的Node的时间 update( -, delete ( + inserto Ollogn)
put(key, value)
Case 1:map里存在这个key
相当于update ：1.真的update value 0(1)
2. update time info update() - delete () + insert() O(logn)
Case 2:map里不存在这个key
如果有地儿：直接insert 0(1)+ O(ogn)
满了：踢出最老的key + insert -> delete ( + inserto o(logn)
     */

    //solution 2: double linked list + hashmap
    /*
    除了TreeSet还有什么数据结构可以保持时间顺序？Queve 今 FFO(First In First out) 时间顺序
First-> Queue 逻辑上的数据结构
怎么实现这个Queue？ 增删改查全01
Queue<Integer> queue = new ArrayDeque<>);
Queue Integer> queue = new LinkedList<>);

Proposal 2: Map<Key, Node> + DoublyLinkedList <Key + Info> (Queue) -› LinkedHashMap/LinkedHashSet
get(key):
- mapET+EiX^key, return null 0(1)
-
map里存在这个key
- return node key value
0(1)
-同时要update这一次get的Node的时问 update( -, delete( + insert0 0(1)
put(key, value)
Case 1:map里存在这个key
相当于update ：1.真的update value
0(1)
2. update time info update() -› delete() + insert() O(1)
Case 2:map里不存在这个key
如果有地儿：直接insert 0(1)+0(1
满了：踢出最老的key + insert -> delete ( + inserto o(1)
Requirement: 0（1） 你给我一个Key 我就能知道Key对应的ListNode Object
Map<Key, ListNode> keyToNode = new HashMap<> ();
Least Recently Used Cache With 大哥组合
DLL左边的都是最老的，右边的都是新的


     */

    private static class Node{
        int key;
        int value;
        Node prev;
        Node next;
        Node(int key, int val) {
            this.key = key;
            this.value = val;
        }
    }

    private Map<Integer, Node> map;
    private Node head;
    private Node tail;
    private final int CAPACITY;
    public LRUCache5(int capacity) {
        this.CAPACITY = capacity;
        map = new HashMap<>();
    }

    public int get(int key) {
        Node node = map.get(key);
        if (node == null) {
            return -1;
        }
        delete(node);
        appendToHead(node);
        return node.value;
    }

    public void put(int key, int value) {
        Node cur = map.get(key);
        if (cur != null) {
            cur.value = value;
            delete(cur);
            appendToHead(cur);
            return;
        }

        cur = new Node(key, value);
        //remove last if out of space
        if (map.size() == CAPACITY) {
            delete(tail);
        }
        appendToHead(cur);
    }

    private void appendToHead(Node node) {
        map.put(node.key, node);
        if (head == null) {
            head = tail = node;
        }
        else {
            node.next = head;
            head.prev = node;
            head = head.prev;
        }
    }

    private void delete(Node node) {
        map.remove(node.key);
        if (node == head) {
            head = head.next;
        }
        if (node == tail) {
            tail = tail.prev;
        }

        if (node.next != null) {
            node.next.prev = node.prev;
        }

        if (node.prev != null) {
            node.prev.next = node.next;
        }

        node.prev = node.next = null;
    }

//    solution 1: hashmap + treeMap
//    static class Element implements Comparable<Element>{
//        int id;
//        int key;
//        int value;
//        Element(int id, int key, int value) {
//            this.id = id;
//            this.key = key;
//            this.value = value;
//        }
//
//        public int compareTo(Element o){
//            return Integer.compare(this.id, o.id);
//        }
//    }
//
//    private HashMap<Integer, Element> map;
//    private TreeSet<Element> set;
//    private int idCount;
//    private final int CAPACITY;
//
//    public LRUCache5(int capacity){
//        this.idCount = 0;
//        map = new HashMap<>();
//        set = new TreeSet<>();
//        CAPACITY = capacity;
//    }
//
//    public Integer get(int key) {
//        Element e = map.get(key);
//        if (e == null) {
//            return null;
//        }
//        set.remove(e);
//        e.id = idCount++;
//        set.add(e);
//        return e.value;
//    }
//
//    public void put(int key, int value) {
//        Element e = map.get(key);
//        if (e != null) {
//            e.value = value;
//            set.remove(e);
//            e.id = idCount++;
//            set.add(e);
//            return;
//        }
//
//        e = new Element(idCount++, key, value);
//        map.put(key, e);
//        set.add(e);
//        if (map.size() > CAPACITY) {
//            Element toBeDeleted = set.first();
//            map.remove(toBeDeleted.key);
//            set.remove(toBeDeleted);
//        }
//    }
}
