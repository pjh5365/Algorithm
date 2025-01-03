import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int ret = 0;
		for (int i = 1; i <= 3; i++) {
			int tmp = Integer.parseInt(br.readLine());
			ret += tmp * i;
		}

		if (ret >= 10) {
			bw.write("happy");
		} else {
			bw.write("sad");
		}
		bw.flush();
	}
}
