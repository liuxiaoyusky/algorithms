package CrossTrainingIII;
import java.util.*;
import java.util.function.Function;

class Point {
    public int x;
    public int y;
    public Point(int x, int y) {
      this.x = x;
      this.y = y;
    }
  }

public class MostPointsOnALine {
    //map<Slope, List of points>
    //remain a int for max counts
    //for each points, try make a line with all previous points
    public static int most(Point[] points) {
        Map<Double, List<Point>> map = new HashMap<>();
        int max = 0;
        for (int i = 1; i < points.length; i++) {
            for (int j = 0; j < i; j++) {
                //base case:same position
                if (checkEqualPoints(points[i],points[j])){
                    continue;
                }

                double slope = calculateSlope(points[i], points[j]);
                if (map.containsKey(slope)) {
                    //check if this point already exist
                    List <Point> list = map.get(slope);
                    list.add(points[i]);
                    max = Math.max(max, list.size());
                }

                //first slope ever
                else {
                    List<Point> list = new LinkedList<>();
                    list.add(points[i]);
                    list.add(points[j]);
                    if (max == 0) {
                        max = 2;
                    }
                }
            }
        }
        return max;
    }

    private static boolean checkEqualPoints(Point a, Point b) {
        if (a.x == b.x && a.y == b.y) {
            return true;
        }
        return false;
    }

    private static double calculateSlope(Point a, Point b) {
        double deltaX = Math.abs(a.x - b.x);
        double deltaY = Math.abs(a.y - b.y);
        return deltaY / deltaX;
    }
}