package java.level2.emotionsale;

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
        int[] discounts = { 10, 20, 30, 40 };

        for (int emoticon : emoticons) {

            int subscribeCount = 0;
            int totalPrice = 0;

            for (int discount : discounts) {

                for (int[] user : users) {

                    int minDiscount = user[0];
                    int budget = user[1];

                    if (!availableForPurchase(minDiscount, discount)) {
                        continue;
                    }

                    int cumulativeAmount = 0;
                }
            }
        }

        return answer;
    }

    private int getDiscountPrice(int emoticon, int discount) {
        return emoticon * (100 - discount);
    }

    private boolean availableForPurchase(int minDiscount, int discount) {
        return minDiscount >= discount;
    }
    static class User {

        int purchaseAmount;
        boolean isSubscribed;

        public boolean isSubscribed() {
            return isSubscribed;
        }
    }

    static class Emoticon {

        int price;
        int discount;

        public Emoticon(int price, int discount) {
            this.price = price;
            this.discount = discount;
        }

        public int getPurchaseAmount() {
            return price * (100 - discount);
        }
    }
}