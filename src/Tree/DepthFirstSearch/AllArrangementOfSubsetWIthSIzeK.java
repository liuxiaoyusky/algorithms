package Tree.DepthFirstSearch;

import java.util.*;

public class AllArrangementOfSubsetWIthSIzeK {

    public List<String> subSetsIIOfSizeK(String set, int k) {
        //assume with duplicate letters but dedup answer
        //hashmap first to see all possible candidates and then fill choose one of them to fill into current cell
        List<String> ans = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        HashMap<Character,Integer> map=mapSet(set);
        helper(ans,sb,map,0,k);
        return ans;
    }

    private void helper(List<String> ans, StringBuilder sb, HashMap map, int index, int k){
        if(sb.length()==k){
            ans.add(new String(sb));
            return;
        }
        //choose a letter from map if its num>0, auto deduped, go to next cell
        Iterator iter = map.entrySet().iterator();
        while(iter.hasNext()){
            Map.Entry entry = (Map.Entry) iter.next();
            Character cha =(Character) entry.getKey();
            Integer num =(Integer) entry.getValue();
            if(num>0){
                sb.append(cha);
                entry.setValue(num-1);
                helper(ans,sb,map,index+1,k);

                //backtrack
                sb.deleteCharAt(sb.length()-1);
                entry.setValue(num+1);
            }
        }
    }

    private HashMap<Character,Integer> mapSet(String set){
        HashMap<Character,Integer> map = new HashMap<>();
        for(int i=0;i<set.length();i++){
            Integer num = map.get(set.charAt(i));
            if(num==null){
                map.put(set.charAt(i),1);
            }else{
                map.put(set.charAt(i),num+1);
            }
        }
        return map;
    }
}
