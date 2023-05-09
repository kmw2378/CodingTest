import java.util.*;

class Solution {
    public String[] solution(String[] records) {
        List<String> result = new ArrayList<>();
        
        Map<String, String> map = new HashMap<>();
        for (String record : records) {
            String[] split = record.split(" ");
            
            if (split.length < 3) {
                continue;
            }
            
            String command = split[0];
            String id = split[1];
            String nickname = split[2];
            
            if (command.equals("Enter")) {
                map.put(id, nickname);
            }
            
            if (command.equals("Change")) {
                map.replace(id, nickname);
            }
        }
        
        for (String record : records) {
            String[] split = record.split(" ");
            String command = split[0];
            String id = split[1];
            
            if (command.equals("Change")) {
                continue;
            }
            
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(map.get(id));
            stringBuilder.append("님이 ");
            
            if (command.equals("Enter")) {
                stringBuilder.append("들어왔습니다.");
            } else {
                stringBuilder.append("나갔습니다.");
            }
            
            result.add(stringBuilder.toString());
        }
        
        return result.stream().toArray(String[]::new);
    }
}
