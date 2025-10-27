import java.util.*;

class Solution {
    public int solution(String[] lines) {    
        List<Pair> list = new ArrayList<>();
        for (String line : lines) {
            StringTokenizer st = new StringTokenizer(line);
            st.nextToken();
            String S = st.nextToken();       
            String T = st.nextToken();
            double time = Double.parseDouble(T.substring(0, T.length() - 1)) * 1000;
            
            double endTime = parseDouble(S);
            double startTime = endTime - time + 1;
            list.add(new Pair(startTime, endTime));
        }
        
        int ret = 0;
        for (Pair now : list) {
            ret = Math.max(ret, Math.max(find(now.startTime, list), find(now.endTime, list)));
        }
        
        return ret;
    }
    
    static int find(double now, List<Pair> list) {
        int cnt = 0;
        double start = now;
        double end = start + 1000;
        
        for (Pair pair : list) {
            if (pair.startTime < end && pair.endTime >= start) {
                cnt++;
            }
        }
        return cnt;
    }
    
    static double parseDouble(String s) {
        double tmp = 0;
        StringTokenizer st = new StringTokenizer(s, ":");
        tmp += 3600 * Double.parseDouble(st.nextToken());
        tmp += 60 * Double.parseDouble(st.nextToken());
        tmp += Double.parseDouble(st.nextToken());
        
        return tmp * 1000;
    }
    
    static class Pair {
        double startTime;
        double endTime;
        
        public Pair(double startTime, double endTime) {
            this.startTime = startTime;
            this.endTime = endTime;
        }
    }
}