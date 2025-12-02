import java.util.*;

class Solution {
    public String solution(String code) {
        int mode = 0;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < code.length(); i++) {
            if ((code.charAt(i)) == '1') {
                if (mode == 1) {
                    mode = 0;
                } else {
                    mode = 1;
                }
            } else {
                if (mode == 1) {
                    if (i % 2 != 0) {
                        sb.append(code.charAt(i));
                    }
                } else if (mode == 0) {
                    if (i % 2 == 0) {
                        sb.append(code.charAt(i));
                    }
                }
            }
        }
        
        
        return sb.length() == 0 ? "EMPTY" : sb.toString();
    }
}