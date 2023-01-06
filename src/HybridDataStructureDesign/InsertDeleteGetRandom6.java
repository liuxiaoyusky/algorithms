package HybridDataStructureDesign;

import java.util.*;

/*
Implement the RandomizedSet class:
RandomizedSet() Initializes the RandomizedSet obiect.
bool insert(int val) Inserts an item val into the set if not present. Returns true if the item was not present, false otherwise. bool remove(int val) Removes an item val from the set if present. Returns true if the item was present, false otherwise. int getRandom) Returns a random element from the current set of elements (it's guaranteed that at least one element exists when this method is called). Each element must have the same probability of being returned.
You must implement the functions of the class such that each function works in average O(1) time complexity.

Step 1: Clarification and Assumption
reservoir sampling
API: insertO remove
getRandom()
关于randomness的一些key points:
1. 不要被这个你不太熟悉的词语给吓到，这里需要大家去implement一个牛掰的随机算法么？需要去impmlement传说中的
reservior sampling ? Big NONONO!
2．我们有现成的工具可以用：
a. Random random = new Random ( )
b. random.nextInt () = Returns the next pseudorandom, uniformly distributed int value from this
random number generator's sequence.
c. Math.random ()

3. 还有一个一直被大家忽略的默默无闻的数据结构，叫 array/arraylist，拿到一个random的index，可以0(1)时问access到这个index对应的元素。独此一家，别无分号，因此，对于随机性问题，randomness这个词本身就是破题点！
Step 2: Finalize Operations
insert
- insert new element remove (element)
- remove the element
getRandom()
- getRandomIndex + get the corresponding element.
removeRandom)
put(key, value)
- insert new element
get(key)
remove (key)
- remove the element
getRandom()
- getRandomIndex + get the corresponding element.
removeRandom()

Step 1:破题点在哪儿？
getRandom() -› array/arraylist
这个题它还是个set的常规操作我需要也都能是O（1)的
Step 2: Data structure proposal:
HashMap + array/arraylist 18 ₴
Step 3: step 2的proposal靠不靠谱？
-六字口诀：存什么干什么
-存什么？
- option 1: Map <key, value>, List<value> ?????
- remove 怎么办？一，需要一个从key到在list里的index的mapping
- option 2: HashMap<Key, index in the array for the Key> indexMap;
- List里存什么？key,value一个都不能少
- HashMap<Key, index in the array for the Key> indexMap + ArrayList<Entry> array;
class Entry {
K key;
V value;
}
-千什么：

insertO
- insert new element
getRandom(
- getRandomIndex + get the corresponding element.
remove element)
- remove the element
indexMap: {1:0, 2:1, 3:2, 4:3}
array: [<1,1>, <2,2>, <3,3>, <4,4>] -> [<1,1>, null, null, <4,4>]
O
1
2
3
e.g. remove(2)
step 1 -> find the index of key 2 in the array -> HashMap<K, index>
step 2 -› how to remove it from the array?
* Option 1:
array remove certain index, move all the right side elements, update indexMap -› O(n) time
* Option 2:
放着坑不管一，循环筛除法一，random (array size0），如果选到坑，那就继续再来一遍，直到选的不是坑为止
worst case getRandom() -› expected O(n)
* Option 3:
注意我们只有一个坑一，只填一个坑 一，用谁来填？
indexMap: {1:0, 2:1, 3:2, 4:3} -> {1:0, 3:2, 4:1}
array: [<1,1>, <2,2>, <3,3>, <4,4>] -> [<1,1>, null, <3,3>, <4,4>] -> [<1,1>, <4,4>, <3,3>, <4,4>]
2
3
e.g. remove(2)

Cover the corner case of ? -,remove的刚好是tail
--> fill in the position with the tail element of the array.
 */
public class InsertDeleteGetRandom6 {
    private Map<Integer, Integer> map;//value, index
    private Random random;
    private List<Integer> list;
    InsertDeleteGetRandom6(){
        map = new HashMap<>();
        list = new ArrayList<>();
        random = new Random();
    }

    public boolean insert(int value) {
        if (map.get(value) != null) {
            return false;
        }
        map.put(value, list.size());
        list.add(value);
        return true;
    }

    public boolean remove(int value) {
        Integer index = map.remove(value);
        if (index == null) {
            return false;
        }



        Integer swapTarget = list.get(list.size() - 1);
        swapToBack(index);
        list.remove(list.size() - 1);

        if (value != swapTarget){
            map.put(swapTarget,index);
        }

        return true;
    }

    private void swapToBack(int index) {
        Integer temp = list.get(index);
        list.set(index, list.get(list.size() - 1));
        list.set(list.size() - 1, temp);
    }

    public int getRandom(){
        int randomIndex = random.nextInt(list.size());
        return list.get(randomIndex);
    }

}
