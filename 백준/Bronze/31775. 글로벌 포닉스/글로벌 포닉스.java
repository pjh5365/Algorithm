import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();

		boolean lCheck = false;
		boolean kCheck = false;
		boolean pCheck = false;

		String[] s = new String[3];
		for (int i = 0; i < 3; i++) {
			s[i] = br.readLine();
			if (s[i].startsWith("l")) {
				lCheck = true;
			} else if (s[i].startsWith("k")) {
				kCheck = true;
			} else if (s[i].startsWith("p")) {
				pCheck = true;
			}
		}

		if (lCheck && kCheck && pCheck) {
			bw.write("GLOBAL");
		} else {
			bw.write("PONIX");
		}
		bw.flush();
	}
}
