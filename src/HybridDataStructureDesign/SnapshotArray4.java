package HybridDataStructureDesign;
/*
https://leetcode.com/problems/snapshot-array/
Implement a SnapshotArray that supports the following interface:
SnapshotArray(int length) initializes an array-like data structure with the given length. Initially, each element equals 0.
void set(index, val) sets the element at the given index to be equal to val.
int snap() takes a snapshot of the array and returns the snap id: the total number of times we called snap() minus 1. int get(index, snap _id returns the value at the given index, at the time we took the snapshot with the given snap_id

Example:
set(1,1)
set(1.2)
set(2,3)
snap()
set/3.4)
set(1,5)
get(1, 1)
get(1, 0)
get(3, 0)
get (2, 2) snap0
set(100, 100)
[null 1 null null (Version 0)
[null 2 null null (Version 0)
[null 2 3 null' (Version 0)
-> return 0
[null 2 3 41 (Version 1)
[null, 5 3 4] (Version 1)
-> return 5
-> return 2
-> return null
-› return 3
-> return 1 [null 5 3 4 null null ..... null 100] (Version 2)

Step 1: Clarification and Assumption void set (index, val)
sets the element at the given index to be equal to val.
int snap ()
takes a snapshot of the array and returns the snap id: the total number of times we called snap()
minus 1.
int get (index, snap_id)
returns the value at the given index, at the time we took the snapshot with the given snap_id
Step 2: Finalize Operations
update search other
set (index, value) get (index, snap_id) snap ()
≥我们需要快速的get到 某一个id对应的版本


Step 3: Proposal Different Data Structure and Compare then Finalize Solution
Proposal 1: Use List<Integer[]>
对于set(index,val)：
我们就直接把array里这个index 放成这个val 0(1)
XiJ*get(index,snap_id):
我们就直接人list里get出这个snap_ id 再返回出当前array里index的位置 0(1)
X F snap():
只需要把版本号加加即可，且我需要把整个array 再copy一遍 O(n)

Proposal 2:
为什么 Proposal 1 比较慢：
有不必要操作！不是所有元素值都有变化， 不需要存所有元素，没有改变的元素可以不存。每次只存变化的元素。
对于每个 index， 我需要知道这个index 在每个版本的变化值．

Map<Key: index, Value: List<Entry>> map
array index  versionld(snapld)

时空间复杂度 of Proposal 2:
Time Complexity:
set(index, value) -> O(1)
snap()
-> O(1)
get(index, version) -> O(logn) [floor(version) -› O(log(# of changes))
Space Complexity: List of snapArray - O(n*(snap id))


 */


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SnapshotArray4 {
    static class Entry{
        int id;
        int val;
        Entry(int id, int val) {
            this.id = id;
            this.val =val;
        }
    }

    private Map<Integer, List<Entry>> map;
    private int version;

    public SnapshotArray4(){
        map = new HashMap<>();
        version = 0;
    }

    public void set(int index, int value) {
        map.putIfAbsent(index, new ArrayList<>());
        List<Entry> versions = map.get(index);
        if (versions.isEmpty() || versions.get(versions.size() - 1).id != version - 1) {
            versions.add(new Entry(version - 1, value));
        } else {
            versions.get(versions.size() - 1).val = value;
        }
    }

    public int snap() {
        version++;
        return version - 1;
    }

    public Integer get(int index, int vId) {
        List<Entry> versions = map.get(index);
        if (versions == null) {
            return null;
        }
        return largestSmallestOrEquals(versions, vId - 1);
    }

    //BS
    private Integer largestSmallestOrEquals(List<Entry> list, int id) {
        int left = 0;
        int right = list.size() - 1;
        //until two left
        while (left + 1 < right) {
            int mid = left + (right - left) / 2;
            //check
            if (list.get(mid).id <= id){
                left = mid;
            } else {
                right = mid;
            }
        }

        if (list.get(right).id <= id) {
            return list.get(right).val;
        }
        if (list.get(left).id <= id) {
            return list.get(left).val;
        }
        return 0;
    }

}
