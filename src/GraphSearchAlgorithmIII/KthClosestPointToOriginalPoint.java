package GraphSearchAlgorithmIII;

import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
/*
Given three arrays sorted in ascending order. Pull one number from each array to form a coordinate <x,y,z> in a 3D space. Find the coordinates of the points that is k-th closest to <0,0,0>.

We are using euclidean distance here.

Assumptions

    The three given arrays are not null or empty, containing only non-negative numbers
    K >= 1 and K <= a.length * b.length * c.length

Return

    a size 3 integer list, the first element should be from the first array, the second element should be from the second array and the third should be from the third array

Examples

    A = {1, 3, 5}, B = {2, 4}, C = {3, 6}

    The closest is <1, 2, 3>, distance is sqrt(1 + 4 + 9)

    The 2nd closest is <3, 2, 3>, distance is sqrt(9 + 4 + 9)
 */
public class KthClosestPointToOriginalPoint {
    //pq
    class Point implements Comparable<Point> {
        int x;
        int y;
        int z;
        long dis;

        public Point(int x, int y, int z, long dis) {
            this.x = x;
            this.y = y;
            this.z = z;
            this.dis = dis;
        }

        public int compareTo(Point o) {
            if(this.dis == o.dis) {
                return 0;
            }
            return this.dis < o.dis ? -1 : 1;
        }
    }

    private long findDis (int a, int b, int c) {
        return a * a + b * b + c * c;
    }
    public List<Integer> closest(int[] a, int[] b, int[] c, int k) {
        PriorityQueue<Point> pq = new PriorityQueue<>(k);
        pq.offer(new Point(0, 0, 0, findDis(a[0], b[0], c[0])));
        boolean [][][] visited = new boolean [a.length][b.length][c.length];
        visited[0][0][0] = true;
        Point cur = pq.peek();
        while (k > 1) {
            cur = pq.poll();
            int x = cur.x;
            int y = cur.y;
            int z = cur.z;
            if (x + 1 < a.length && !visited[x + 1][y][z]) {
                pq.offer(new Point(x + 1, y, z, findDis(a[x + 1],b[y],c[z])));
                visited[x + 1][y][z] = true;
            }
            if (y + 1 < b.length && !visited[x][y + 1][z]) {
                pq.offer(new Point(x, y + 1, z, findDis(a[x],b[y + 1],c[z])));
                visited[x][y + 1][z] = true;
            }
            if (z + 1 < c.length && !visited[x][y][z + 1]) {
                pq.offer(new Point(x, y, z + 1, findDis(a[x],b[y],c[z + 1])));
                visited[x][y][z + 1] = true;
            }
            k--;
        }
        List<Integer> ans = new LinkedList<>();
        cur = pq.peek();
        ans.add(a[cur.x]);
        ans.add(b[cur.y]);
        ans.add(c[cur.z]);
        return ans;
    }
}
