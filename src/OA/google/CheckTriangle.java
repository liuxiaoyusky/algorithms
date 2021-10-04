package OA.google;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class CheckTriangle {

    public static boolean checkTriangle(String bottom, List<String> patterns) {
        HashMap<String, List<Character>> upper_letters = findAllLetter(patterns);
        boolean [] findSolution = new boolean[1];
        checkTriangleHelper(bottom,upper_letters, findSolution);
        return findSolution[0];
    }

    private static void checkTriangleHelper(String bottom, HashMap<String, List<Character>> upper_letters,boolean [] findSolution) {
        //base case: found solution
        if (findSolution[0]) {
            return;
        }

        //base case: find the first solution
        if (bottom.length() == 1) {
            findSolution[0] = true;
            return;
        }

        StringBuilder newBottom = new StringBuilder();
        List<String> toppingBottoms = new ArrayList<>();
        findAllToppingBottom(bottom,upper_letters,0,newBottom, toppingBottoms);
        for (String upperBottom: toppingBottoms) {
            checkTriangleHelper(upperBottom, upper_letters, findSolution);
        }
    }

    private static void findAllToppingBottom(String bottom, HashMap<String,
            List<Character>> upper_letters, int index, StringBuilder newBottom,List<String> newBottoms) {
        if (index == bottom.length() - 1) {
            newBottoms.add(newBottom.toString());
            return;
        }
        String curBottomPart = bottom.substring(index,index + 2);
        List<Character> upperLetter = upper_letters.get(curBottomPart);
        if (upperLetter == null) {
            return;
        }
        for(Character letter: upperLetter){
            newBottom.append(letter);
            findAllToppingBottom(bottom,upper_letters,index + 1, newBottom, newBottoms);
            newBottom.deleteCharAt(index);
        }
    }



    //add all topings of pattern to the map
    private static HashMap<String, List<Character>> findAllLetter(List<String> patterns) {
        HashMap<String, List<Character>> upper_letters = new HashMap<>();
        for (String pattern: patterns) {
            String cur = pattern.substring(0,2);
            List<Character> top = upper_letters.get(cur);
            if (top == null) {
                top = new ArrayList<>();
            }
            top.add(pattern.charAt(2));
            upper_letters.put(cur,top);
        }
    return upper_letters;
    }

    public static void main(String [] args) {
        //System.out.println(checkTriangle("AAAA",List.of("AAA")));
        System.out.println(checkTriangle("AABB",List.of("AAA","ABC","BBA","ACA","CAC")));
    }

}
