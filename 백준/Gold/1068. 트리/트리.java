import java.io.*;
import java.util.*;

public class Main {
    static ArrayList<ArrayList<Integer>> list = new ArrayList<>(); // 부모 노드를 가르키는 리스트
    static int N;
    static int remove;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            list.add(new ArrayList<>());
        }
        int root = 0;
        for (int i = 0; i < N; i++) {
            int now = Integer.parseInt(st.nextToken());
            if (now == -1) {
                root = i;
            } else {
                list.get(now).add(i);
            }
        }
        remove = Integer.parseInt(br.readLine());
        int ret = dfs(root);
        if (remove == root) {
            ret = 0;
        }

        bw.write(ret + " \n");
        bw.flush();
    }

    static int dfs(int now) {
        int ret = 0;
        int child = 0;
        for (int i : list.get(now)) {
            if (i == remove) { // 삭제된 노드라면 건너뛰기
                continue;
            }
            ret += dfs(i);
            child++;
        }
        if (child == 0) { // 리프노드라면
            return 1;
        }
        return ret;
    }
}
