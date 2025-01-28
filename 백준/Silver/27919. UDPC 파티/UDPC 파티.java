import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();

		String s = br.readLine();
		int cuCnt = 0;
		int dpCnt = 0;
		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) == 'U' || s.charAt(i) == 'C') {
				cuCnt++;
			} else if (s.charAt(i) == 'D' || s.charAt(i) == 'P') {
				dpCnt++;
			}
		}

		if (cuCnt > (dpCnt + 1) / 2) { // dpCut = 10 일때 D(5), P(5)로 나눈경우 U는 11이상이 되어야 출력가능
			sb.append("U");
		}
		if (dpCnt > 0) { // D, P가 한번이라도 나온다면 U는 C(기권)로 처리하여 DP가 뽑히게 할 수 있다.
			sb.append("DP");
		}
		sb.append("\n");

		bw.write(String.valueOf(sb));
		bw.flush();
	}
}
