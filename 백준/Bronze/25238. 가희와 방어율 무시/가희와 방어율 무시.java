import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer st = new StringTokenizer(br.readLine());
		int a = Integer.parseInt(st.nextToken());
		int b = Integer.parseInt(st.nextToken());

		double ret = a * ((double)(100 - b) / 100);

		if (ret >= 100) {
			bw.write("0");
		} else {
			bw.write("1");
		}
		bw.newLine();
		bw.flush();
	}
}
