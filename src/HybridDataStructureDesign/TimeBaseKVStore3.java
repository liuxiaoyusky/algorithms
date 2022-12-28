package HybridDataStructureDesign;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class TimeBaseKVStore3 {
    /*
    Question:
    Design a time-based key-value data structure that can store multiple values for the same key at different time stamps and retrieve the key's value at a certain timestamp.
Implement the TimeMap class:
TimeMap() Initializes the object of the data structure.
void set(String key, String value, int timestamp) Stores the key key with the value value at the given time timestamp.
String get(String key, int timestamp) Returns a value such that set was called previously, with timestamp_prev <= timestamp.
If there are multiple such values, it returns the value associated with the largest timestamp prev. If there are no values, it returns
Explanation
TimeMap timeMap = new TimeMap();
timeMap.set("foo", "bar", 1); // store the key "foo" and value "bar" along with timestamp = 1.
timeMap.get("foo", 1);
// return "bar"
timeMap.get("foo", 3);
I return "bar", since there is no value corresponding to foo at timestamp 3 and timestamp 2, then the
only value is at timestamp 1 is "bar".
timeMap.set("foo", "bar2", 4); // store the key "foo" and value "bar2" along with timestamp = 4.
timeMap.get("foo", 2);
// return "bar"
timeMap.get("foo", 4);
Il return "bar2"
timeMap.get("foo", 5);
Il return "bar2"

Step 1: Clarification and Assumption
public boolean set(String key, String value, int timestamp):
Stores the key key with the value value at the given time timestamp
public String get (String key, int timestamp):
Returns a value such that set was called previously, with timestamp_prev <= timestamp. If
there are multiple such values, it returns the value associated with the largest timestamp_prev. If there are no values, it returns

Step 2: Finalize Operations
insert -
put(K,V)
search - get(K)-
我们需要对同样的Key， 保持时间顺序。
timeOrder need
put(K, V, timestamp)
get(K,timestamp)

Step 3: Proposal Different Data Structure and Compare then Finalize Solution
Proposal 1: Use Map + List
对于put:
对于时间顺序：
我们可以用一个 Map<Key, Value>
但是对于同一个Key里，我们可以用一个List来保持 index本质上就是timestamp，自动保持时序
detail logic:
set (String key, String value, int timestamp)
0(1)
如果没有这个key，我们就放一个空1ist，然后把它加进去
如果已经有了，我们就把这个value加到这个key所在的List里
get (String key, int timestamp)
如果没有这个key，那我们就return w
0(1)
如果已经有了，在这个key的List里找到 这个timestamp，因为array里的元素一定是按时问先后顺序排列的，可以通过binary search来查找
O(logn)


    clarify:
    set: set key, value at given time stamp
    get: return a value such that its timestamp less than or equal to given;
    return "" if not exist; return the most recent timestamp < given if multiple value
     */
    Map<String, TreeMap<Integer, String>> timeMap;
    public TimeBaseKVStore3(){
        timeMap = new HashMap<>();
    }

    public void set(String key, String value, int timeStamp) {
        timeMap.putIfAbsent(key, new TreeMap<>());
        timeMap.get(key).put(timeStamp, value);
    }

    public String get(String key, int timeStamp) {
        TreeMap<Integer, String> map = timeMap.get(key);
        if (map == null) {
            return "";
        }

        Map.Entry<Integer, String> entry = map.floorEntry(timeStamp);
        return entry == null ? "" : entry.getValue();
    }
}
