package CrossTrainingIII;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CommonElementsInKSortedListsTest {

    @Test
    void commonElementsInKSortedArrays() {
        CommonElementsInKSortedLists c = new CommonElementsInKSortedLists();
        List<List<Integer>> list = new LinkedList<>();
        List<Integer> list1 = List.of(new Integer []{-1,0,0,2,2,2,4,6,7,7,9,9,10,12});
        List<Integer> list2 = List.of(new Integer []{0,0,0,1});
        List<Integer> list3 = List.of(new Integer []{0,0,1,3,5,5,6,7,9,11,11});
        List<Integer> list4 = List.of(new Integer []{0,0,2});
        List<Integer> list5 = List.of(new Integer []{0,2});
        List<Integer> list6 = List.of(new Integer []{1,1,3,5,7,9,9,9});
        list.add(list1);
        list.add(list2);
        list.add(list3);
        list.add(list4);
        List<List<Integer>> l2 = new ArrayList<>();
        l2.add(list5);
        l2.add(list6);
        c.commonElementsInKSortedArrays(l2);
    }
}