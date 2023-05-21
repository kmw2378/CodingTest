class Solution {
    public int solution(String s) {
        int answer = 0;
        for (int i = 0; i < s.length(); i++) {
            answer = Math.max(answer, getPalindromeSize(s, i - 1, i + 1));
            answer = Math.max(answer, getPalindromeSize(s, i, i + 1));
        }

        return answer;
    }
    
    private int getPalindromeSize(String s, int sp, int ed) {
        while (sp >= 0 && ed < s.length() && s.charAt(sp) == s.charAt(ed)) {
            sp--;
            ed++;
        }
        
        while (ed == s.length() && sp >= 0 && s.charAt(sp) == s.charAt(ed - 1)) {
            sp--;
        }
        
        while (sp == -1 && ed < s.length() && s.charAt(sp + 1) == s.charAt(ed)) {
            ed++;
        }
        
        return ed - sp - 1;
    }
}
