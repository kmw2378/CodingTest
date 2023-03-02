package java.level2.ranksearch;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Main {

    public static void main(String[] args) {

        String[] infos = {"java backend junior pizza 150","python frontend senior chicken 210","python frontend senior chicken 150","cpp backend senior pizza 260","java backend junior chicken 80","python backend senior chicken 50"};
        String[] queries = {"java and backend and junior and pizza 100","python and frontend and senior and chicken 200","cpp and - and senior and pizza 250","- and backend and senior and - 150","- and - and - and chicken 100","- and - and - and - 150"};

//        testMethod(infos, queries);

        int[] answer = new Solution().solution(infos, queries);
        System.out.println("answer = " + Arrays.toString(answer));
    }

    private static void testMethod(String[] infos, String[] queries) {
        System.out.println("info");
        for (String info : infos) {
            String[] split = info.split(" ");
            System.out.println(Arrays.toString(split));
        }

        System.out.println("============================");

        System.out.println("query");
        for (String query : queries) {
            String[] split = query.replaceAll(" and ", " ").split( " ");
            System.out.println(Arrays.toString(split));
        }
    }
}

/** XXXSplit[] 인덱스 별 값
 * 0 : 언어
 * 1 : 직군
 * 2 : 경력
 * 3 : 소울 푸드
 * 4 : 점수
 */
class Solution {

    int[][] totalInfo;
    public int[] solution(String[] infos, String[] queries) {
        int[] answer = new int[queries.length];
        int idx = 0;

        Map<Integer, TypeAndCount> total = new HashMap<>();

        for (String info : infos) {
            String[] infoSplit = info.split(" ");

            for (int i = 0; i < infoSplit.length; i++) {
//                total.put(i, );
            }
        }

        initTotalInfo();

        for (String info : infos) {

            String[] infoSplit = info.split(" ");

            if (infoSplit[0].equals("java")) {
                totalInfo[0][0]++;
            } else if (infoSplit[0].equals("python")) {
                totalInfo[0][1]++;
            } else if (infoSplit[0].equals("cpp")) {

            }
        }

        for (String query : queries) {

            int count = 0;

            String[] querySplit = query.replaceAll(" and ", " ").split( " ");

            int currentQueryScore = Integer.parseInt(querySplit[4]);

            for (String info : infos) {
                String[] infoSplit = info.split(" ");
                int currentInfoScore = Integer.parseInt(infoSplit[4]);

                if (currentQueryScore > currentInfoScore) {
                    continue;
                }

                boolean suitable = true;

                for (int i = 0; i < 4; i++) {

                    if (querySplit[i].equals("-")) {
                        continue;
                    }

                    if (!querySplit[i].equals(infoSplit[i])) {
                        suitable = false;
                        break;
                    }
                }

                if (suitable) {
                    count++;
                }
            }

            answer[idx++] = count;
        }

        return answer;
    }

    private void initTotalInfo() {
        totalInfo = new int[5][];
        totalInfo[0] = new int[4];
        totalInfo[1] = new int[3];
        totalInfo[2] = new int[3];
        totalInfo[3] = new int[3];
        totalInfo[4] = new int[1];
    }

    static class TypeAndCount {
        String type;
        int count;

    }
}
