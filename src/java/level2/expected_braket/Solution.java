class Solution {
    public int solution(int n, int a, int b) {
        int answer = 0;

        while (a != b) {
            a = getNext(a);
            b = getNext(b);
            answer++;
        }

        return answer;
    }
    
    private int getNext(int n) {
        return n % 2 == 1 ? n / 2 + 1 : n / 2;
    }
}
