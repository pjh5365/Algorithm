import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        while (T-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());
            int t = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());

            int[][] score = new int[n + 1][k + 1]; // 팀당 문제별 점수
            int[] cnt = new int[n + 1]; // 팀당 제출횟수
            int[] time = new int[n + 1]; // 팀당 마지막 제출 시간


            for (int l = 0; l < m; l++) {
                st = new StringTokenizer(br.readLine());
                int i = Integer.parseInt(st.nextToken());
                int j = Integer.parseInt(st.nextToken());
                int s = Integer.parseInt(st.nextToken());

                cnt[i]++;
                time[i] = l;
                score[i][j] = Math.max(score[i][j], s);
            }

            int[] sum = new int[n + 1];
            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= k; j++) {
                    sum[i] += score[i][j];
                }
            }

            Pair[] arr = new Pair[n];
            for (int i = 0; i < n; i++) {
                arr[i] = new Pair(sum[i + 1], cnt[i + 1], time[i + 1], i + 1);
            }

            Arrays.sort(arr, (o1, o2) -> {
                if (o1.score > o2.score) {
                    return -1;
                } else if (o1.score < o2.score) {
                    return 1;
                } else {
                    if (o1.cnt > o2.cnt) {
                        return 1;
                    } else if (o1.cnt < o2.cnt) {
                        return -1;
                    } else {
                        if (o1.time > o2.time) {
                            return 1;
                        } else if (o1.time < o2.time) {
                            return -1;
                        } else {
                            return 0;
                        }
                    }
                }
            });

            for (int i = 0; i < n; i++) {
                if (arr[i].idx == t) {
                    sb.append(i + 1).append("\n");
                }
            }
        }

        bw.write(sb + "");
        bw.flush();
    }

    static class Pair {
        int score;
        int cnt;
        int time;
        int idx;

        public Pair(int score, int cnt, int time, int idx) {
            this.score = score;
            this.cnt = cnt;
            this.time = time;
            this.idx = idx;
        }
    }
}
