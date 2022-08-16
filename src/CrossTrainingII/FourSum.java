package CrossTrainingII;

import java.util.*;
/*
Determine if there exists a set of four elements in a given array that sum to the given target number.

Assumptions

    The given array is not null and has length of at least 4

Examples

    A = {1, 2, 2, 3, 4}, target = 9, return true(1 + 2 + 2 + 4 = 9)

    A = {1, 2, 2, 3, 4}, target = 12, return false
 */
public class FourSum {
    //could have dup, sort first

    class Element {
        int sum;
        int a;
        int b;
        public Element (int a, int b) {
            this.a = a;
            this.b = b;
        }
    }

    //maintain a map with value and list<element>, so we can look up elements for certain value
    //let element.a < element.b
    public boolean exist(int[] array, int target) {
        Arrays.sort(array);
        Map<Integer, List<Element>> map = new HashMap<>();
        for(int i = 0; i < array.length - 1; i++) {
            for (int j = i + 1; j < array.length; j++) {
                int sum = array[i] + array[j];
                List<Element> list = map.get(sum);
                if (list == null) {
                    list = new LinkedList<>();
                }
                list.add(new Element(i, j));
                map.put(sum, list);

                while(j < array.length - 1 && array[j] == array[j + 1]) {
                    j++;
                }
            }
            while(i < array.length - 1 && array[i] == array[i + 1]) {
                i++;
            }
        }

        //let a < b < i < j
        for (int i = 2; i < array.length - 1; i++) {
            for (int j = i + 1; j < array.length; j++) {
                int sum = array[i] + array[j];
                List<Element> list = map.get(target - sum);
                if (list == null) {
                    continue;
                } else {
                    for(Element e : list) {
                        if (e.b < i) {
                            return true;
                        }
                    }
                }
            }
        }

        return false;
    }
}
