package 刷题.递归;
/*
You are given a list of airline tickets where tickets[i] = [fromi, toi]
represent the departure and the arrival airports of one flight.
Reconstruct the itinerary in order and return it.

All of the tickets belong to a man who departs from "JFK", thus, the itinerary must begin with "JFK".
If there are multiple valid itineraries,
you should return the itinerary that has the smallest lexical order when read as a single string.
    For example, the itinerary ["JFK", "LGA"] has a smaller lexical order than ["JFK", "LGB"].
You may assume all tickets form at least one valid itinerary.
 You must use all the tickets once and only once.

Example 1:
Input: tickets = [["MUC","LHR"],["JFK","MUC"],["SFO","SJC"],["LHR","SFO"]]
Output: ["JFK","MUC","LHR","SFO","SJC"]

Example 2:
Input: tickets = [["JFK","SFO"],["JFK","ATL"],["SFO","ATL"],["ATL","JFK"],["ATL","SFO"]]
Output: ["JFK","ATL","JFK","SFO","ATL","SFO"]
Explanation: Another possible reconstruction is ["JFK","SFO","ATL","JFK","ATL","SFO"] but it is larger in lexical order.

Constraints:
    1 <= tickets.length <= 300
    tickets[i].length == 2
    fromi.length == 3
    toi.length == 3
    fromi and toi consist of uppercase English letters.
    fromi != toi

 */

import javax.print.attribute.standard.Destination;
import java.util.*;

public class ReconstructItinerary332 {
    //start airport: for cur airport, what destination can I go(mark by boolean), Map<String, sorted list<destination>>
    //for all destination, which destination should I try first(alphabetically)
    //base case: when used all tickets, size = tickets + 1, return this as answer, and stop recursion
    class Destination implements Comparable<Destination> {
        String destination;
        boolean beenThere;
        public Destination(String destination) {
            this.destination = destination;
            this.beenThere = false;
        }

        @Override
        public int compareTo(Destination o) {
             return this.destination.compareTo(o.destination);
        }
    }
    public List<String> findItinerary(List<List<String>> tickets) {
        Map<String, List<Destination>> map = new HashMap<>();
        for (List<String> list : tickets) {
            Destination destination = new Destination(list.get(1));
            List<Destination> destinationList = map.get(list.get(0));
            if (destinationList == null) {
                destinationList = new LinkedList<>();
            }
            destinationList.add(destination);
            map.put(list.get(0), destinationList);
        }

        for(List<Destination> list : map.values()){
            Collections.sort(list);
        }

        List<String> cur = new LinkedList<>();
        List<List<String>> ans = new LinkedList<>();
        cur.add("JFK");
        helper(map,"JFK",tickets.size(),cur, ans);
        return ans.get(0);
    }

    private void helper(Map<String, List<Destination>> map,  String start, int ticketsLeft, List<String> cur, List<List<String>> ans) {
        //base case
        if (ans.size() > 0) {
            return;
        }

        //base case
        if (ticketsLeft == 0) {
            ans.add(new LinkedList<>(cur));
            return;
        }

        //general case
        List<Destination> list = map.get(start);
        //corner case: no return flight,it is not possible that this is last fight since base case before, so dead end
        if (list == null) {
            return;
        }
        for(Destination des : list) {
            if (des.beenThere) {
                continue;
            }
            des.beenThere = true;
            cur.add(des.destination);
            helper(map, des.destination, ticketsLeft - 1, cur, ans);

            //backtrack
            des.beenThere = false;
            cur.remove(cur.size() - 1);
        }
    }
}
