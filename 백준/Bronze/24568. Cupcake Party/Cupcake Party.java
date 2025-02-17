import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int R = Integer.parseInt(br.readLine());
		int S = Integer.parseInt(br.readLine());

		int ret = R * 8 + S * 3 - 28;


		bw.write(String.valueOf(ret));
		bw.flush();
	}
}
