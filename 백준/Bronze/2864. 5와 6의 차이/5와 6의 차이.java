import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer st = new StringTokenizer(br.readLine());

		String A = st.nextToken();
		String B = st.nextToken();

		int maxA = Integer.parseInt(A.replace('5', '6'));
		int minA = Integer.parseInt(A.replace('6', '5'));

		int maxB = Integer.parseInt(B.replace('5', '6'));
		int minB = Integer.parseInt(B.replace('6', '5'));


		bw.write((minA + minB) + " " + (maxA + maxB));
		bw.flush();
	}
}
