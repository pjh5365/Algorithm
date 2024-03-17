import java.io.*;
import java.util.*;

public class Main{
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer st = new StringTokenizer(br.readLine());
		int H = Integer.parseInt(st.nextToken());
		int W = Integer.parseInt(st.nextToken());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		int h = (H - 1) / (N + 1) + 1; // 1,1 은 고정이므로 빼서 계산한 다음 고정한 1,1 더해주기
		int w = (W - 1) / (M + 1) + 1;

		bw.write(String.valueOf(h * w));
		bw.flush();
	}
}
