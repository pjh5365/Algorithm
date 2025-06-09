import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static int M;
    static int[][] map;
    static int[] arr;
    static ArrayList<Integer> chickenList = new ArrayList<>();
    static ArrayList<Integer> homeList = new ArrayList<>();
    static boolean[] check;
    static int ret = Integer.MAX_VALUE;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][N];
        arr = new int[M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == 1) {
                    homeList.add(N * i + j);
                } else if (map[i][j] == 2) {
                    chickenList.add(N * i + j);
                }
            }
        }
        check = new boolean[chickenList.size()];

        find(0);

        bw.write(ret + " ");
        bw.flush();
    }

    static void find(int depth) {
        if (depth == M) {
            int sum = 0;
            for (int i : homeList) {
                int min = Integer.MAX_VALUE;
                int homeX = i / N;
                int homeY = i % N;
                for (int j = 0; j < M; j++) {
                    int get = chickenList.get(arr[j]);
                    int cX = get / N;
                    int cY = get % N;

                    int tmp = Math.abs(cX - homeX) + Math.abs(cY - homeY);
                    min = Math.min(tmp, min);
                }
                sum += min;
            }
            ret = Math.min(ret, sum);
            return;
        }

        int start = 0;

        if (depth > 0) {
            start = arr[depth - 1];
        }

        for (int i = start; i < chickenList.size(); i++) {
            if (!check[i]) {
                check[i] = true;
                arr[depth] = i;
                find(depth + 1);
                check[i] = false;
            }
        }
    }
}
