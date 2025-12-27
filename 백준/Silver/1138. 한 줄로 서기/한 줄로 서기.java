import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            int now = Integer.parseInt(st.nextToken());

            int cnt = 0;
            for (int idx = 0; idx < N; idx++) {
                if (arr[idx] == 0) { // 빈칸일때
                    if (cnt == now) { // 빈칸의 개수가 왼쪽 인원수랑 동일할때
                        arr[idx] = i + 1;
                        break;
                    }
                    cnt++; // 아니라면 빈칸개수 증가
                }
            }
        }

        for (int i = 0; i < N; i++) {
            sb.append(arr[i]).append(" ");
        }

        bw.write(sb + "");
        bw.flush();
    }
}
