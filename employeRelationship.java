import java.util.*;
class Solution {
    public  Map<Character, Set<Character>> employeeRelationship(char[][] arrays){
        Map<Character, Set<Character>> result = new HashMap<>();
        if(arrays == null || arrays.length == 0){
            return result;
        }

        Map<Character, Set<Character>> map = new HashMap<>();
        Map<Character, Integer> count = new HashMap<>();
        Queue<Character> queue = new LinkedList<>();

        for(int i = 0; i < arrays.length; i++){
            if (!map.containsKey(arrays[i][0])){
                map.put(arrays[i][0], new HashSet<>());
            }

            map.get(arrays[i][0]).add(arrays[i][1]);
            count.put(arrays[i][1], count.getOrDefault(arrays[i][1], 0) + 1);
        }

        for(int i = 0; i < arrays.length; i++){
            if(!count.containsKey(arrays[i][0])){
                queue.offer(arrays[i][0]);
                result.put(arrays[i][0], new HashSet<>());
            }
        }

        while(!queue.isEmpty()){
            char current = queue.poll();
            if(!map.containsKey(current)){
                continue;
            }
            for(char c : map.get(current)){
                if(count.get(c) == 1){
                    queue.offer(c);
                    count.remove(c);
                }else{
                    count.put(c, count.get(c) - 1);
                }
                if(!result.containsKey(c)){
                    result.put(c, new HashSet<>());
                }
                result.get(c).add(current);
                result.get(c).addAll(result.get(current));
            }
        }

        return result;
    }
}