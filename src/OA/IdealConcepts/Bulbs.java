package OA.IdealConcepts;

/*
OX => XO
OOX => XXO
OXOXO => XOOXO
一串灯泡，左边关掉时紧挨着的右边灯泡会调整一次状态，后续灯泡随之调整
只能控制最左边的灯泡的开关，给一个初始状态，问开关K次后所有的灯泡的状态是什么
O = open, X = close

solution 0: 爆解
k个for loop循环，每个循环从灯泡串的最左边开始变化，让之后的灯泡随之变化 ，如果灯泡串长度为n，时间复杂度O(Kn)


solution 1：在0的基础上简化步骤
对单个灯泡来说，开关偶数次状态不变，开关奇数次状态flip，所以我们可不可以直接计算每个灯泡开关K次之后的状态？
初始灯泡亮等同于初始灯泡暗，k+1，所以所有灯泡都可以默认初始是暗得，对于亮的灯泡，k+1
for the left most bulb, if we change it K times, the final status is light if K % 2 == 1; else is dark
then, for next bulb, the number of changing is actually K / 2
same idea, if the second bulb start with light, it can be regarded as dark with K/2 + 1 changes
Time: O(n)
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
