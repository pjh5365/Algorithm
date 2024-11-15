import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int N = Integer.parseInt(br.readLine());
		int ret = 10;
		int len = 1;

		while (N >= len * 2) {
			len *= 2;
			ret++;
		}

		bw.write(String.valueOf(ret));
		bw.flush();
	}
}
