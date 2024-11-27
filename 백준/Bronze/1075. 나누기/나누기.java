import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int N = Integer.parseInt(br.readLine());
		int F = Integer.parseInt(br.readLine());

		int sNum = N - (N % 100);
		int eNum = sNum + 100;
		String ret = "";
		for (int i = sNum; i <= eNum; i++) {
			if (i % F == 0) {
				ret = String.valueOf(i);
				ret = ret.substring(ret.length() - 2);
				break;
			}
		}

		bw.write(ret);
		bw.flush();
	}
}
