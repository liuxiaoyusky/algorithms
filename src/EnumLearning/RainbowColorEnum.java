package EnumLearning;

public class RainbowColorEnum {
    public static void main(String args[]) {
        RainbowColor color = RainbowColor.BLUE;
        for (RainbowColor c : RainbowColor.values()) {
            System.out.println(c);
            System.out.println(c.ordinal());
        }
        System.out.println(RainbowColor.valueOf("RED"));//return "RED"
        System.out.println(RainbowColor.valueOf("red"));//error
    }
}

enum RainbowColor {RED, ORANGE, YELLOW, GREEN,CYAN, BLUE, PURPLE}
