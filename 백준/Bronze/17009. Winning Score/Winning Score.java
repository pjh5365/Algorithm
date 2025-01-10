import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int A = 0;
		int B = 0;
		String ret = "";

		A += Integer.parseInt(br.readLine()) * 3;
		A += Integer.parseInt(br.readLine()) * 2;
		A += Integer.parseInt(br.readLine());

		B += Integer.parseInt(br.readLine()) * 3;
		B += Integer.parseInt(br.readLine()) * 2;
		B += Integer.parseInt(br.readLine());

		if (A > B) {
			ret = "A";
		} else if (A < B) {
			ret = "B";
		} else {
			ret = "T";
		}

		bw.write(ret);
		bw.flush();
	}
}
