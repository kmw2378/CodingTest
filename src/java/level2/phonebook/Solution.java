import java.util.*;
import java.util.stream.Collectors;

class Solution {
    public boolean solution(String[] phone_book) {
        List<String> list = Arrays.stream(phone_book).sorted((s1, s2) -> Integer.compare(s1.length(), s2.length())).collect(Collectors.toList());
        int st = list.get(0).length();
        
        Set<String> set = new HashSet<>();
        for (String num : phone_book) {
            for (int i = st; i < num.length(); i++) {
                set.add(num.substring(0, i));
            }
        }
        
        int cnt = set.size();
        for (String num : phone_book) {
            set.add(num);
            if (set.size() != ++cnt) {
                return false;
            }
        }
        
        return true;
    }
}
