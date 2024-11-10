import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int N = Integer.parseInt(br.readLine());
		StringBuilder binary = new StringBuilder(Integer.toBinaryString(N));
		int ret = Integer.parseInt(binary.reverse().toString(), 2);

		bw.write(String.valueOf(ret));
		bw.flush();
	}
}
