import java.io.*;
import java.math.BigInteger;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int L = Integer.parseInt(br.readLine());
		String input = br.readLine();

		BigInteger ret = new BigInteger("0");
		for (int i = 0; i < input.length(); i++) {
			int now = input.charAt(i) - 'a' + 1;
			BigInteger tmp = new BigInteger("31");
			tmp = tmp.pow(i);
			tmp = tmp.multiply(BigInteger.valueOf(now));
			ret = ret.add(tmp);
			ret = ret.remainder(BigInteger.valueOf(1234567891));
		}

		bw.write(String.valueOf(ret));
		bw.newLine();
		bw.flush();
	}
}
