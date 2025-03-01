import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int d1 = Integer.parseInt(br.readLine());
		int d2 = Integer.parseInt(br.readLine());

		double ret = d1 * 2 + 2 * 3.141592 * d2;

		bw.write(String.valueOf(ret));
		bw.flush();
	}
}
