import java.io.*;

public class Main {

    static StringBuilder sb = new StringBuilder();
    static int count = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());

        hanoi(1, 2, 3, N);  // N 개의 원판이 1에서 시작해서 2를 이용해 3으로 도착한다.
        bw.write(String.valueOf(count));
        bw.newLine();
        bw.write(String.valueOf(sb));
        bw.newLine();
        bw.flush();
    }

    static void hanoi(int start, int mid, int end, int N) {
        if(N == 1) {    // 하나밖에 없다면 시작점에서 도착지로 이동
            sb.append(start).append(" ").append(end).append("\n");
            count++;
        }
        else {  // 아니라면
            hanoi(start, end, mid, N-1);    // 시작점에서 끝점을 이용해 중간까지 N-1개를 이동
            sb.append(start).append(" ").append(end).append("\n");  // 시작점에서 가장 큰 원판을 도착지로 이동
            count++;
            hanoi(mid, start, end, N-1);    // 중간으로 이동된 N-1개의 원판들을 시작점을 거쳐 도착지로 이동시키기
        }
    }
}