import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer st = new StringTokenizer(br.readLine());
		int ret = 0;
		for (int i = 0; i < 6; i++) {
			ret += Integer.parseInt(st.nextToken()) * 5;
		}

		bw.write(String.valueOf(ret));
		bw.flush();
	}
}
