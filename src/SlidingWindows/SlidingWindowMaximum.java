package SlidingWindows;

import java.util.*;

/*
for sliding window of size k, find the max in each window
 */
public class SlidingWindowMaximum {
    //brute force, Time:O(nk), Space:O(1)
    public int [] solution1(int [] nums, int k) {
        if (nums == null || nums.length == 0 || k == 0) {
            return new int [0];
        }

        int [] result = new int [nums.length - k + 1];
        for (int i = k - 1; i < nums.length; i++) {
            int curMax = nums[i];
            for (int j = 0; j < k; j++) {
                curMax = Math.max(curMax, nums[i - j]);
            }
             result[i - k + 1] = curMax;
        }
        return result;
    }

    //use pq to find max in windows
    //time: O(nk) space: O(k)
    public int [] solution2(int [] nums, int k) {
        if (nums == null || nums.length == 0 || k == 0) {
            return new int [0];
        }
        int [] result = new int [nums.length - k  + 1];
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());

        for (int i = 0; i < nums.length; i++) {
            //add fast
            maxHeap.offer(nums[i]);

            //remove slow
            if (i > k - 1) {
                maxHeap.remove(nums[i - k]);//O(k)
            }

            if (i >= k - 1) {
                result[i - k + 1] = maxHeap.peek();
            }
        }

        return result;
    }

    //use pq, but only delete when the element is top and index > k
    //time: O(nlogn) space: O(n)

    class Element implements Comparable<Element>{
        int index;
        int value;
        public Element(int i, int v) {
            this.index = i;
            this.value = v;
        }

        public int compareTo(Element o) {
            if(this.value == o.value) {
                return Integer.compare(o.index, this.index);
            }

            return this.value < o.value ? 1 : -1;//reverse order
        }
    }

    //time: in worse case: O(nlogn)
    public int [] solution3(int [] nums, int k) {
        if (nums == null || nums.length == 0) {
            return new int [0];
        }
        int resultSize = k >= nums.length ? 1 : nums.length - k + 1;
        int [] result = new int [resultSize];
        PriorityQueue<Element> pq = new PriorityQueue<>();


        //first k elements
        for (int i = 0; i < k && i < nums.length; i++) {
            pq.offer(new Element(i, nums[i]));
        }

        result[0] = pq.peek().value;

        int resultIndex = 1;
        for (int i = k; i < nums.length; i++) {
            //remove slow if removedIndex <= curIndex - k
            while (!pq.isEmpty() && pq.peek().index <= i - k) {
                pq.poll();//logk
            }

            //add fast
            pq.offer(new Element(i, nums[i]));

            //update solution
            result[resultIndex] = pq.peek().value;
            resultIndex++;
        }
        return result;
    }

    //use treeset to replace priority queue, since treeset.last() gives the largest element
    //time: o(nlogk) space:O(k)
    public int [] solution4 (int [] nums, int k) {
        if (nums == null || nums.length == 0) {
            return new int [] {};
        }
        int resultSize = k >= nums.length ? 1 : nums.length - k + 1;
        int [] result = new int [resultSize];
        TreeSet<Element> set = new TreeSet<>(Collections.reverseOrder());//since current element is max heap
        for (int fast = 0; fast < nums.length; fast++) {
            //add fast
            set.add(new Element(fast, nums[fast]));

            //remove slow
            if (fast >= k) {
                //check by compare method defined by us
                set.remove(new Element(fast - k, nums[fast - k]));
            }

            //update solution
            if (fast >= k - 1) {
                result[fast - k + 1] = set.last().value;
            }
        }

        return result;
    }

    //use mono stack, poll max in O(1), class 26, next greater element, 直方图问题，largest rectangle of  one in matrix
    //time: O(n)
    public int [] maxSlidingWindow(int [] nums, int k) {
        if (nums == null || nums.length == 0) {
            return new int [] {};
        }
        int resultSize = k >= nums.length ? 1 : nums.length - k + 1;
        int [] result = new int [resultSize];
        Deque<Integer> deque = new ArrayDeque<>();
        for (int fast = 0;  fast < nums.length; fast ++) {
            //在尾部放入新的value，如果新的value更大，从尾部remove直到从左到右单调递减（实际存的是index）
            //删
            while (!deque.isEmpty() && nums[fast] > nums[deque.peekLast()]) {
                deque.pollLast();
            }
            deque.offer(fast);

            //把出界的index删掉(从左开始)
            if (fast >= k) {
                if (!deque.isEmpty() && deque.peek() == fast - k) {
                    deque.pollFirst();
                }
            }

            //左边是当前window最大值
            if (fast >= k - 1) {
                result[fast - k + 1] = nums[deque.peekFirst()];
            }
        }
        return result;
    }

}
