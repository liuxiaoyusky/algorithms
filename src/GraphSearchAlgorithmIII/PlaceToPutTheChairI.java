package GraphSearchAlgorithmIII;

import java.util.*;

public class PlaceToPutTheChairI {
    //go through the gym to find all chairs
    //make a cost map from each chair to every possible place in gym
    //go through the gym again to find min cost

    class Equip {
        int row;
        int column;
        int [][] cost;
        public Equip (int row, int column, int [][] cost) {
            this.row = row;
            this.column = column;
            this.cost = cost;
        }
    }

    class Chair{
        int row;
        int column;
        int cost;
        public Chair (int row, int column) {
            this.row = row;
            this.column = column;
            this.cost = Integer.MAX_VALUE;
        }
    }

    public List<Integer> putChair(char[][] gym) {
        List<Chair> chairs = new ArrayList<>();
        List<Equip> equips = new ArrayList<>();
        int m = gym.length;
        int n = gym[0].length;

        //go through the first time find all chairs and equips
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (gym[i][j] - 'E' == 0) {
                    equips.add(new Equip(i,j, new int [m][n]));
                } else if(gym[i][j] - 'C' == 0) {
                    chairs.add(new Chair(i, j));
                }
            }
        }

        for (Equip e:equips) {
            findCost(e, gym);
        }

        int cost = Integer.MAX_VALUE;
        Chair cur = null;

         for (Chair c: chairs) {
           int curCost = 0;
           int curRow = c.row;
           int curColumn = c.column;
           for(Equip e: equips) {
             curCost += e.cost[curRow][curColumn];
           }

           if (cost > curCost) {
             cost = curCost;
             cur = c;
           }
         }
        List <Integer> ans = null;
        if (cur == null) {
            ans = new ArrayList<Integer>(Arrays.asList(-1, -1));
            return ans;
        }
        ans = new ArrayList<Integer>(Arrays.asList(cur.row,cur.column));
        return ans;
    }

    private void findCost(Equip e, char [][] gym) {
        int [][] moves = new int [][] {{-1,0},{1,0},{0,-1},{0,1}};
        int [][] costs = e.cost;
        Deque<Chair> queue = new LinkedList<>();
        queue.add(new Chair(e.row, e.column));
        costs[e.row][e.column] = 1;

        while(!queue.isEmpty()) {
            Chair cur = queue.poll();
            int curRow = cur.row;
            int curColumn = cur.column;
            //fill in the up, down, left, right cost
            for (int i = 0; i < moves.length; i++) {
                int nextRow = curRow + moves[i][0];
                int nextColumn = curColumn + moves[i][1];
                if (nextRow < costs.length && nextRow >= 0 && nextColumn < costs[0].length
                        && nextColumn >= 0) {
                    //check if we already visited this spot or this spot is occupied
                    if (costs[nextRow][nextColumn] != 0 || gym[nextRow][nextColumn] == 'O') {
                        continue;
                    }

                    //put value to it and move it to the queue
                    costs[nextRow][nextColumn] = costs[curRow][curColumn] + 1;
                    queue.offer(new Chair(nextRow,nextColumn));
                }
            }
        }
    }

    public static void main(String [] args) {
        PlaceToPutTheChairI c = new PlaceToPutTheChairI();
        List<Integer> ans = c.putChair(new char[][] {
                {'C','C','E','O','C'},
                {'C','C','O','C','E'},
                {'C','C','E','E','C'},
                {'C','O','C','E','E'},
                {'C','C','O','C','C'},
        });

        System.out.println(ans);
    }
}
