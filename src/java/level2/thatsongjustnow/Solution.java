import java.util.*;

class Solution {
    public String solution(String m, String[] musicinfos) {
        int maxMin = 0;
        String result = "(None)";
        for (String musicinfo : musicinfos) {
            String[] split = musicinfo.split(",");
            int min = getMin(split[1]) - getMin(split[0]);
            String melody = getMelody(min, split[3]);
            if (contain(melody, m) && maxMin < min) {
                maxMin = min;
                result = split[2];
            }
        }

        return result;
    }

    private int getMin(String s) {
        String[] split = s.split(":");
        return Integer.parseInt(split[0]) * 60 + Integer.parseInt(split[1]);
    }

    private String getMelody(int min, String m) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < min; i++) {
            char s = m.charAt(i % m.length());
            if (s == '#') {
                continue;
            }

            stringBuilder.append(s);
            char next = m.charAt((i + 1) % m.length());
            if (next == '#') {
                stringBuilder.append(next);
                min++;
            }
        }

        return stringBuilder.toString();
    }

    private boolean contain(String melody, String m) {
        int start = 0;
        for (int i = 0; i < melody.length() - m.length(); i++) {
            String substring = melody.substring(i, i + m.length());
            if (substring.equals(m) && melody.charAt(i + m.length()) != '#') {
                start = i;
            }
        }

        if (start != 0) {
            return true;
        }

        String s = melody.replaceAll(m, " ");
        int i = s.lastIndexOf(" ");

        if (i == -1) {
            return false;
        }

        if (i == s.length() - 1) {
            return true;
        }

        return s.charAt(i + 1) != '#';
    }
}

/* 다른 사람 풀이 참조하여 수정한 코드
import java.util.*;

class Solution {
    public String solution(String m, String[] musicinfos) {
        int maxMin = 0;
        String result = "(None)";
        m = refactor(m);
        
        for (String musicinfo : musicinfos) {
            String[] split = musicinfo.split(",");
            int min = getMin(split[1]) - getMin(split[0]);
            String melody = getMelody(min, refactor(split[3]));
            if (melody.contains(m) && maxMin < min) {
                maxMin = min;
                result = split[2];
            }
        }
        
        return result;
    }
    
    private String refactor(String s) {
        return s.replaceAll("A#", "a")
            .replaceAll("C#", "c")
            .replaceAll("D#", "d")
            .replaceAll("E#", "e")
            .replaceAll("F#", "f")
            .replaceAll("G#", "g");
    }
    
    private int getMin(String s) {
        String[] split = s.split(":");
        return Integer.parseInt(split[0]) * 60 + Integer.parseInt(split[1]);
    }
    
    private String getMelody(int min, String m) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < min; i++) {
            stringBuilder.append(m.charAt(i % m.length()));
        }
        
        return stringBuilder.toString();
    }
}
*/
