import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int sum = 0;
		int ret = 0;
		boolean flag = false;
		for (int i = 0; i < 10; i++) {
			int tmp = Integer.parseInt(br.readLine());
			if (sum + tmp >= 100 && !flag) {
				if (100 - sum < sum + tmp - 100) {
					ret = sum;
				} else {
					ret = sum + tmp;
				}
				flag = true;
			}
			sum += tmp;
		}
		if (!flag) {
			ret = sum;
		}
		bw.write(String.valueOf(ret));
		bw.flush();
	}
}
