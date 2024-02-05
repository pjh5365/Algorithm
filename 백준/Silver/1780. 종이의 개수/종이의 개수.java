import java.io.*;
import java.util.StringTokenizer;

public class Main {

    static int minus = 0;
    static int zero = 0;
    static int plus = 0;

    static int[][] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();


        int N = Integer.parseInt(br.readLine());
        arr = new int[N][N];

        for(int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j = 0; j < N; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        cut(0, 0, N);
        sb.append(minus).append("\n");
        sb.append(zero).append("\n");
        sb.append(plus).append("\n");

        bw.write(String.valueOf(sb));
        bw.flush();
    }

    static void cut(int x, int y, int N) {
        int check = arr[x][y];
        boolean isOk = true;

        for(int i = x; i < x + N; i++) {
            for(int j = y; j < y + N; j++) {
                if(arr[i][j] != check) {
                    isOk = false;
                    break;
                }
            }
        }

        if(isOk || N == 1) {
            if(check == -1)
                minus++;
            else if(check == 0)
                zero++;
            else
                plus++;
            return;
        }
        N /= 3;

        for(int i = 0; i < 3; i++) {
            for(int j = 0; j < 3; j++)
                cut(x+(i*N), y+(j*N), N);
        }
    }
}