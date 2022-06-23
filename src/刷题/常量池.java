package 刷题;

public class 常量池 {
    //constant pool
    public static void main(String [] args){
        /*
        ————————————————
        版权声明：本文为CSDN博主「河海哥yyds」的原创文章，遵循CC 4.0 BY-SA版权协议，转载请附上原文出处链接及本声明。
        原文链接：https://blog.csdn.net/qq_41376740/article/details/80338158
         */

        //String
        String s1 = "Hello";
        String s2 = "Hello";
        String s3 = "Hel" + "lo";
        String s4 = "Hel" + new String("lo");
        String s5 = new String("Hello");
        String s6 = s5.intern();
        String s7 = "H";
        String s8 = "ello";
        String s9 = s7 + s8;

//        System.out.println(s1 == s2);  // true
//        System.out.println(s1 == s3);  // true
//        System.out.println(s1 == s4);  // false
//        System.out.println(s1 == s9);  // false
//        System.out.println(s4 == s5);  // false
//        System.out.println(s1 == s6);  // true

        //Integer
        Integer i1 = 700;
        Integer i2 = 400;
        Integer i3 = 300;
        Integer i4 = new Integer(700);
        Integer i5 = new Integer(700);
        Integer i6 = new Integer(0);
        Integer i7 = 1;
        Integer i8 = 2;
        Integer i9 = 3;

        System.out.println("i1=i2+i3   " + (i1 == i2 + i3));
        System.out.println("i1=i4   " + (i1 == i4));
        System.out.println("i4=i5   " + (i4 == i5));
        System.out.println("i4=i5+i6   " + (i4 == i5 + i6));
        System.out.println("400=i5+i6   " + (700 == i5 + i6));


    }
}
