import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        Pair[] arr = new Pair[N];
        int max = 0;
        int maxLen = 0;
        int maxIdx = 0;
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int L = Integer.parseInt(st.nextToken());
            int H = Integer.parseInt(st.nextToken());

            arr[i] = new Pair(L, H);
        }

        Arrays.sort(arr);

        for (int i = 0; i < N; i++) {
            if (max < arr[i].H) {
                max = arr[i].H;
                maxIdx = arr[i].L;
                maxLen = 1;
            } else if (max == arr[i].H) {
                maxLen = arr[i].L - (maxIdx - 1);
            }
        }

        int ret = 0;
        int idx = 0;
        for (int i = 1; i < N; i++) {
            if (arr[idx].H < arr[i].H) {
                ret += (arr[i].L - arr[idx].L) * arr[idx].H;
                idx = i;
            }
            if (arr[idx].H == max) {
                break;
            }
        }

        idx = N - 1;
        for (int i = N - 2; i >= 0; i--) {
            if (arr[idx].H < arr[i].H) {
                ret += (arr[idx].L - arr[i].L) * arr[idx].H;
                idx = i;
            }
            if (arr[idx].H == max) {
                break;
            }
        }
        ret += max * maxLen;
        bw.write(ret + "");
        bw.flush();
    }

    static class Pair implements Comparable<Pair> {

        int L;
        int H;

        public Pair(int l, int h) {
            L = l;
            H = h;
        }

        @Override
        public int compareTo(Pair o) {
            return Integer.compare(this.L, o.L);
        }
    }
}
