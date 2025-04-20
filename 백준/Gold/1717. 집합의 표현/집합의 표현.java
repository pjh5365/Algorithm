import java.io.*;
import java.util.*;

public class Main {

    static int[] parent;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        parent = new int[n + 1];

        for (int i = 0; i <= n; i++) {
            parent[i] = i;
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int num = Integer.parseInt(st.nextToken());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            if (num == 0) { // 집합 병합
                union(a, b);
            } else { // 두 원소가 같은 집합인지 확인
                if (check(a, b)) { // 같은 집합이라면 YES
                    sb.append("YES").append("\n");
                } else { // 아니라면 NO
                    sb.append("NO").append("\n");
                }
            }
        }

        bw.write(String.valueOf(sb));
        bw.flush();
    }

    static int findRoot(int x) {
        if (x == parent[x]) { // 루트라면 반환
            return x;
        }
        return findRoot(parent[x]); // 부모 노드 탐색
    }

    static void union(int x, int y) {
        x = findRoot(x);
        y = findRoot(y);

        if (x != y) { // 두 집합이 서로 다른 곳에 존재한다면 병합
            parent[y] = x;
        } else {
        }
    }

    static boolean check(int x, int y) {
        x = findRoot(x);
        y = findRoot(y);

        if (x != y) {
            return false;
        } else {
            return true;
        }
    }
}
