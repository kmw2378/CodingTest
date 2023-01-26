package level1.report;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

public class Main {
    public static void main(String[] args) {

        Solution solution = new Solution();

        String[] id_list =  {"muzi", "frodo", "apeach", "neo"};
        String[] report = {"muzi frodo", "apeach frodo", "frodo neo", "muzi neo", "apeach muzi"};
        int k = 2;

        int[] answer = solution.solution(id_list, report, k);

        System.out.println(Arrays.toString(answer));
    }
}
class Solution {
    public int[] solution(String[] id_list, String[] report, int k) {

        int[] answer = new int[id_list.length];
        Map<String, Set<String>> reportList = new ConcurrentHashMap<>();

        for (String id : id_list) {
            reportList.put(id, new HashSet<>());
        }

        for (String value : report) {

            int index = value.indexOf(" ");

            String userId = value.substring(0, index);
            String reportedId = value.substring(index + 1);

            reportList.get(reportedId).add(userId);
        }

        for (String key : reportList.keySet()) {

            Set<String> stringSet = reportList.get(key);

            if (stringSet.size() >= k) {

                for (int i = 0; i < id_list.length; i++) {

                    for (String id : stringSet) {
                        if (id.equals(id_list[i])) {
                            answer[i]++;
                        }
                    }
                }
            }
        }

        return answer;
    }
}