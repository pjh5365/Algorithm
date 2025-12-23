import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        HashMap<Character, Integer> map = new HashMap<>();
        while (N-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String[] arr = new String[st.countTokens()];
            int tmp = 0;
            int max = 0;
            while (st.hasMoreTokens()) {
                arr[tmp++] = st.nextToken();
                max = Math.max(arr[tmp - 1].length(), max);
            }

            boolean flag = false;
            for (int strIdx = 0; strIdx < arr.length; strIdx++) {
                String now = arr[strIdx];
                char key = now.toLowerCase().charAt(0);
                if (!map.containsKey(key)) {
                    map.put(key, 1);
                    flag = true;
                    for (int i = 0; i < arr.length; i++) {
                        if (strIdx != i) {
                            sb.append(arr[i]).append(" ");
                        } else {
                            sb.append("[").append(now.charAt(0)).append("]");
                            for (int j = 1; j < now.length(); j++) {
                                sb.append(now.charAt(j));
                            }
                            sb.append(" ");
                        }
                    }
                    sb.append("\n");
                    break;
                }
            }


            if (!flag) {
                for (int strIdx = 0; strIdx < arr.length; strIdx++) {
                    String now = arr[strIdx];
                    for (int idx = 1; idx < now.length(); idx++) {
                        char key = now.toLowerCase().charAt(idx);
                        if (!map.containsKey(key)) {
                            flag = true;
                            map.put(key, 1);
                            for (int i = 0; i < arr.length; i++) {
                                if (strIdx != i) {
                                    sb.append(arr[i]).append(" ");
                                } else {
                                    for (int j = 0; j < now.length(); j++) {
                                        if (j != idx) {
                                            sb.append(now.charAt(j));
                                        } else {
                                            sb.append("[").append(now.charAt(j)).append("]");
                                        }
                                    }
                                    sb.append(" ");
                                }
                            }
                            sb.append("\n");
                            break;
                        }
                    }
                    if (flag) {
                        break;
                    }
                }
                if (!flag) {
                    for (int i = 0; i < arr.length; i++) {
                        sb.append(arr[i]).append(" ");
                    }
                    sb.append("\n");
                }
            }
        }

        bw.write(sb + "");
        bw.flush();
    }
}
