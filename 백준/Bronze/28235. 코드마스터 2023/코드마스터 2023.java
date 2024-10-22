import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		String s = br.readLine();
		String ret = "";

		if (s.equals("SONGDO")) {
			ret = "HIGHSCHOOL";
		} else if (s.equals("CODE")) {
			ret = "MASTER";
		} else if (s.equals("2023")) {
			ret = "0611";
		} else if (s.equals("ALGORITHM")) {
			ret = "CONTEST";
		}

		bw.write(ret);
		bw.newLine();
		bw.flush();
	}
}
