import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine());
        String[] arr = new String[4];
        arr[0] = st.nextToken();
        arr[1] = st.nextToken();
        st = new StringTokenizer(br.readLine());
        arr[2] = st.nextToken();
        arr[3] = st.nextToken();

        Arrays.sort(arr);

        Set<String> set = new TreeSet<>();
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                String str = arr[i] + " " + arr[j];
                set.add(str);
            }
        }
        for (String str : set) {
            sb.append(str).append("\n");
        }

        bw.write(String.valueOf(sb));
        bw.flush();
    }
}
