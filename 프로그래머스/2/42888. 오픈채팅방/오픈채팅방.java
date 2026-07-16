import java.util.*;

class Solution {
    public String[] solution(String[] record) {
        ArrayList<String> list = new ArrayList<>();
        HashMap<String, String> nameMap = new HashMap<>();
        for (String str : record) {
            StringTokenizer st = new StringTokenizer(str);
            String cmd = st.nextToken();
            String uid = st.nextToken();
            
            if (cmd.equals("Enter") || cmd.equals("Change")) {
                String name = st.nextToken();
                nameMap.put(uid, name);
            }
            if (!cmd.equals("Change")) {
                list.add(cmd + " " + uid);
            }
        }
        
        String[] ret = new String[list.size()];
        
        for (int i = 0; i < list.size(); i++) {
            StringTokenizer st = new StringTokenizer(list.get(i));
            String cmd = st.nextToken();
            String uid = st.nextToken();
            
            if (cmd.equals("Enter")) {
                ret[i] = nameMap.get(uid) + "님이 들어왔습니다.";
            } else {
                ret[i] = nameMap.get(uid) + "님이 나갔습니다.";
            }
        }
        return ret;
    }
}