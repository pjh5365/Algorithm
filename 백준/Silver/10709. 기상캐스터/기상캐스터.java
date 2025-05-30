import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine());

        int H = Integer.parseInt(st.nextToken());
        int W = Integer.parseInt(st.nextToken());

        int[][] map = new int[H][W];
        for (int i = 0; i < H; i++) {
            String s = br.readLine();
            for (int j = 0; j < W; j++) {
                if (s.charAt(j) == '.') {
                    map[i][j] = -1;
                } else {
                    map[i][j] = 0;
                }
                if (j > 0 && map[i][j] == -1 && map[i][j - 1] != -1) {
                    map[i][j] = map[i][j - 1] + 1;
                }
                sb.append(map[i][j]).append(" ");
            }
            sb.append("\n");
        }



        bw.write(sb + "");
        bw.flush();
    }
}
