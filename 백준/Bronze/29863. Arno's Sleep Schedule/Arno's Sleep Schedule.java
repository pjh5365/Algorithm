import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int A = Integer.parseInt(br.readLine());
		int B = Integer.parseInt(br.readLine());

		int result = 0;
		if (A >= 20) {
			result += 24 - A + B;
		} else {
			result += B - A;
		}

		bw.write(String.valueOf(result));
		bw.flush();
	}
}
