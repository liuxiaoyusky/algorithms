package OA.IdealConcepts;

/*
一串灯泡，左边关掉时紧挨着的右边灯泡会调整一次状态，后续灯泡随之调整
只能控制最左边的灯泡的开关，给一个初始状态，问开关K次后最左边的状态是什么
O = open, X = close
 */
public class Bulbs {
    public static String changeBulbs(long K, String input) {
        char [] array = input.toCharArray();
        int index = 0;
        while (index < array.length && K > 0) {
            K += input.charAt(index) == 'O' ? 1 : 0;
            char next = K % 2 == 0 ? 'X' : 'O';
            array[index] = next;
            index++;
            K /= 2;
        }
        return new String(array);
    }
}
