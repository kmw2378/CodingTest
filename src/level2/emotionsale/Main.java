package level2.emotionsale;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {

        /**
         * users[i][0] : 할인율
         * users[i][1] : 가격
         */
        int[][] users = {{40, 10000}, {25, 10000}};

        /**
         * 이모티콘 정가
         */
        int[] emoticons = {7000, 9000};

        Solution solution = new Solution();
        int[] result = solution.solution(users, emoticons);

        System.out.println(Arrays.toString(result));
    }
}
class Solution {

    /**
     * @param users 최소 할인율, 최대 사용 금액
     * @param emoticons 이모티콘 가격
     * @return 이모티콘 플러스 가입자 수, 증가한 이모티콘 판매액
     */
    public int[] solution(int[][] users, int[] emoticons) {
        int[] answer = new int[2];

        int emoticonPlusCnt = 0;
        int emoticonSaleAmount = 0;
        int[] emoticonDiscountRates = {10, 20, 30, 40};

        for (int[] user : users) {

            int minDiscountRate = user[0];
            int maxAmount = user[1];
            int maxSaleAmount = 0;

            for (int emoticonDiscountRate : emoticonDiscountRates) {

                boolean isPurchaseEmoticonPlus = false;
                int currentEmoticonSaleAmount = 0;

                if (emoticonDiscountRate >= minDiscountRate) {

                    for (int emoticon : emoticons) {

                        int currentEmoticonPrice = emoticon * (100 - emoticonDiscountRate) / 100;
                        if (currentEmoticonSaleAmount + currentEmoticonSaleAmount < maxAmount) {
                            currentEmoticonSaleAmount += currentEmoticonPrice;
                        } else {
                            isPurchaseEmoticonPlus = true;
                            break;
                        }

                        if (currentEmoticonSaleAmount > maxSaleAmount) {
                            maxSaleAmount = currentEmoticonSaleAmount;
                        }
                    }

                    if (isPurchaseEmoticonPlus) {
                        emoticonPlusCnt++;
                        break;
                    }
                }

                emoticonSaleAmount += currentEmoticonSaleAmount;
            }
        }

        answer[0] = emoticonPlusCnt;
        answer[1] =emoticonSaleAmount;

        return answer;
    }
}