import java.io.*;
import java.util.*;

public class Main {

    static int[] parent;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int cnt = Integer.parseInt(st.nextToken());
        parent = new int[N + 1];
        int[] arr = new int[cnt]; // 진실을 아는 사람
        int[] party = new int[M + 1]; // 파티 참여자중 한명

        for (int i = 0; i < cnt; i++) { // 진실을 아는사람
            arr[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i <= N; i++) { // 집합 초기화
            parent[i] = i;
        }

        for (int i = 1; i <= M; i++) {
            ArrayList<Integer> now = new ArrayList<>();
            st = new StringTokenizer(br.readLine());
            int num = Integer.parseInt(st.nextToken());
            for (int j = 0; j < num; j++) {
                now.add(Integer.valueOf(st.nextToken()));
            }
            // 파티 참석자들은 하나의 집합으로 만들기
            for (int j = 0; j < now.size() - 1; j++) {
                union(now.get(j), now.get(j + 1));
            }
            party[i] = now.get(0);
        }

        int ret = 0;
        for (int i = 1; i <= M; i++) {
            boolean flag = true;

            for (int j : arr) {
                if (check(j, party[i])) { // 파티에 참석한 사람과 진실을 아는 사람이 연결되어 있다면
                    flag = false;
                    break;
                }
            }
            if (flag) {
                ret++;
            }
        }

        bw.write(String.valueOf(ret));
        bw.flush();
    }

    static int findParent(int x) {
        if (x == parent[x]) {
            return x;
        }
        return findParent(parent[x]);
    }

    static void union(int x, int y) {
        x = findParent(x);
        y = findParent(y);

        if (x != y) {
            parent[x] = y;
        }
    }

    static boolean check(int x, int y) {
        x = findParent(x);
        y = findParent(y);

        if (x != y) {
            return false;
        }
        return true;
    }
}
