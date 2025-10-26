import java.util.*;

class Solution {
    public String solution(String m, String[] musicinfos) {
        String ret = "(None)";
        int playTime = 0;
        
        for (String s : musicinfos) {
            StringTokenizer st = new StringTokenizer(s, ",");
            
            String start = st.nextToken();
            String end = st.nextToken();
            
            int startTime = getTime(start);
            int endTime = getTime(end);
            String name = st.nextToken();
            String melody = st.nextToken();
            
            int time = endTime - startTime; // 노래 재생 시간
            
            String totalMelody = "";
            
            m = m.replaceAll("C#", "1")
                .replaceAll("D#", "2")
                .replaceAll("F#", "3")
                .replaceAll("G#", "4")
                .replaceAll("A#", "5")
                .replaceAll("B#", "6")
                .replaceAll("E#", "7");
            
            melody = melody.replaceAll("C#", "1")
                .replaceAll("D#", "2")
                .replaceAll("F#", "3")
                .replaceAll("G#", "4")
                .replaceAll("A#", "5")
                .replaceAll("B#", "6")
                .replaceAll("E#", "7");
            
            int size = time;
            
            for (int i = 0; i < size; i++) {
                char now = melody.charAt(i % melody.length());
                totalMelody += now;
            }
            
            if (totalMelody.contains(m)) {
                if (ret.equals("(None)")) {
                    ret = name;
                    playTime = time;
                } else {
                    if (playTime < time) {
                        ret = name;
                        playTime = time;
                    } 
                } 
            }
        }
        
        return ret;
    }
    
    public int getTime(String s) {
        StringTokenizer st = new StringTokenizer(s, ":");
        int time = Integer.parseInt(st.nextToken()) * 60;
        time += Integer.parseInt(st.nextToken());
        return time;
    }
}