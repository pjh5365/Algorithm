import java.io.*;
import java.util.*;

class Solution {
    public int[] solution(String[] enroll, String[] referral, String[] seller, int[] amount) {
        HashMap<String, String> p = new HashMap<>();
        HashMap<String, Integer> m = new HashMap<>();
        
        for (int i = 0; i < enroll.length; i++) {
            p.put(enroll[i], referral[i]);
            m.put(enroll[i], i);
        }
        
        int[] answer = new int[enroll.length];
        
        for (int i = 0; i < seller.length; i++) {
            String s = seller[i];
            
            int money = amount[i] * 100;
            
            while (!s.equals("-")) {
                int parent = money / 10;
                int my = money - parent;
                
                answer[m.get(s)] += my;
                
                s = p.get(s);
                money /= 10;
                
                if (money < 1) {
                    break;
                }
            }
        }
        
        return answer;
    }
}