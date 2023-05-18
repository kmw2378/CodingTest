import java.util.*;
import java.util.stream.Collectors;

class Solution {
    public int solution(String[] userIds, String[] bannedIds) {
        return rSolution(initMap(userIds), bannedIds, 0, new PriorityQueue<>(), new LinkedList<>());
    }
    
    private int rSolution(Map<Integer, String> map, String[] bannedIds, int depth, Queue<Integer> queue, List<Integer> orderList) {
        
        if (depth == bannedIds.length) {
            int current = getOrder(queue);
            if (!orderList.contains(current)) {
                orderList.add(current);
                return 1;
            } else {
                return 0;
            }
        }
        
        String bannedId = bannedIds[depth];
        
        int cnt = 0;
        for (int i : map.keySet()) {
            String userId = map.get(i);
            if (suitable(userId, bannedId)) {
                Queue<Integer> newQueue = new PriorityQueue<>(queue);
                newQueue.add(i);
                cnt += rSolution(getRefactorMap(map, i), bannedIds, depth + 1, newQueue, orderList);
            }
        }
        
        return cnt;
    }
    
    private Map<Integer, String> initMap(String[] userIds) {
        Map<Integer, String> map = new HashMap<>();
        
        for (int i = 0; i < userIds.length; i++) {
            map.put(i + 1, userIds[i]);
        }
        
        return map;
    }
    
    private Map<Integer, String> getRefactorMap(Map<Integer, String> beforeMap, int i) {
        Map<Integer, String> map = new HashMap<>(beforeMap);
        map.remove(i);

        return map;
    }
    
    private int getOrder(Queue<Integer> queue) {
        int order = 0;
        while (!queue.isEmpty()) {
            order = order * 10 + queue.poll();
        }
        
        return order;
    }
    
    private boolean suitable(String userId, String bannedId) {
        
        if (userId.length() != bannedId.length()) {
            return false;
        }
        
        for (int i = 0; i < userId.length(); i++) {
            char u = userId.charAt(i);
            char b = bannedId.charAt(i);
            if (b == '*') {
                continue;
            }
            
            if (u != b) {
                return false;
            }
        }
        
        return true;
    }
}
