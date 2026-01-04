import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[] arr = new int[2 * N];
        boolean[] robot = new boolean[2 * N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 2 * N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int ret = 0;
        int end = N - 1; // 내리는 위치
        while (true) {
            // 벨트 회전
            int tmp = arr[2 * N - 1];
            for (int i = 2 * N - 1; i > 0; i--) {
                arr[i] = arr[i - 1];
            }
            arr[0] = tmp;
            for (int i = N - 1; i > 0; i--) {
                robot[i] = robot[i - 1];
            }
            robot[0] = false;
            robot[end] = false;

            // 로봇의 이동
            for (int i = N - 1; i > 0; i--) {
                if (robot[i - 1] && !robot[i] && arr[i] > 0) {
                    robot[i - 1] = false;
                    robot[i] = true;
                    arr[i]--;
                    robot[end] = false; // 로봇이 내린다
                }
            }

            if (arr[0] > 0) {
                arr[0]--;
                robot[0] = true;
            }

            ret++;

            int cnt = 0;
            for (int i = 0; i < 2 * N; i++) {
                if (arr[i] == 0) {
                    cnt++;
                }
            }
            if (cnt >= K) {
                break;
            }
        }

        bw.write(ret + "");
        bw.flush();
    }
}
