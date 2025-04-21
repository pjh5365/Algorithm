import java.io.*;
import java.util.*;

public class Main {
    static int[] parent;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());

        parent = new int[N + 1];
        for (int i = 0; i <= N; i++) {
            parent[i] = i;
        }
        StringTokenizer st;
        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= N; j++) {
                int tmp = Integer.parseInt(st.nextToken());
                if (tmp == 1) {
                    union(i, j);
                }
            }
        }
        st = new StringTokenizer(br.readLine());
        int start = Integer.parseInt(st.nextToken());
        int next;
        boolean flag = true;
        for (int i = 1; i < M; i++) {
            next = Integer.parseInt(st.nextToken());
            if (check(start, next)) {
                start = next;
            } else {
                flag = false;
                break;
            }
        }
        if (flag) {
            bw.write("YES");
        } else {
            bw.write("NO");
        }

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
