import java.util.*;

class Solution {
    public String[] solution(String[] files) {
        Queue<File> queue = new PriorityQueue<>();
        for (int i = 0; i < files.length; i++) {
            int start = getStart(files[i]);
            int end = getEnd(start, files[i]);
            queue.add(new File(files[i], start, end, i));
        }
        
        List<String> list = new ArrayList<>();
        while (!queue.isEmpty()) {
            list.add(queue.poll().toString());
        }
        
        return list.stream().toArray(String[]::new);
    }
    
    private boolean isInteger(String s) {
        try {
            Integer.parseInt(s);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
    
    private int getStart(String s) {
        for (int i = 0; i < s.length(); i++) {
            if (isInteger(s.substring(i, i + 1))) {
                return i;
            }
        }
        
        return s.length();
    }
    
    private int getEnd(int i, String s) {
        while (i < s.length() && isInteger(s.substring(i, i + 1))) {
            i++;
        }
        
        return i;
    }
    
    static class File implements Comparable<File> {
        String name;
        String number;
        String tail;
        int order;
        
        public File(String s, int start, int end, int order) {
            this.name = s.substring(0, start);
            this.number = s.substring(start, end);
            this.tail = s.substring(end);
            this.order = order;
        }
        
        public int getParseNumber() {
            return Integer.parseInt(number);
        }
        
        public String getPureName() {
            return name.toLowerCase();
        }
        
        @Override
        public String toString() {
            return name + number + tail;
        }
        
        @Override
        public int compareTo(File o) {
            if (!this.getPureName().equals(o.getPureName())) {
                return this.getPureName().compareTo(o.getPureName());
            }
            
            if (this.getParseNumber() != o.getParseNumber()) {
                return this.getParseNumber() - o.getParseNumber();
            }
            
            return this.order - o.order;
        }
    }
}
