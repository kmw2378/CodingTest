class Solution {
    public int[] solution(String[] wallpaper) {
        int lux = getLux(wallpaper);
        int luy = Integer.MAX_VALUE;
        int rdx = getRdx(wallpaper);
        int rdy = 0;
        
        for (String line : wallpaper) {
            if (!line.contains("#")) {
                continue;
            }
            luy = Math.min(luy, line.indexOf("#"));
            rdy = Math.max(rdy, line.lastIndexOf("#") + 1);
        }
        
        return new int[]{lux, luy, rdx, rdy};
    }
    
    private int getLux(String[] wallpaper) {
        for (int i = 0; i <= wallpaper.length; i++) {
            if (wallpaper[i].contains("#")) {
                return i;
            }
        }
        
        return 0;
    }
    
    private int getRdx(String[] wallpaper) {
        for (int i = wallpaper.length - 1; i >= 0; i--) {
            if (wallpaper[i].contains("#")) {
                return i + 1;
            }
        }
        
        return 0;
    }
}
