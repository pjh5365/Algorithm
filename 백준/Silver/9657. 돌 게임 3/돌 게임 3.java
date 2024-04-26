import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int N = Integer.parseInt(br.readLine());
		int result = N % 7;

		if (result == 0 || result == 2) {
			bw.write("CY");
		} else {
			bw.write("SK");
		}
		bw.flush();
	}
}
