import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		String input = br.readLine();
		double result = 0;

		if (input.equals("A+"))
			result = 4.3;
		else if (input.equals("A0"))
			result = 4.0;
		else if (input.equals("A-"))
			result = 3.7;
		else if (input.equals("B+"))
			result = 3.3;
		else if (input.equals("B0"))
			result = 3.0;
		else if (input.equals("B-"))
			result = 2.7;
		else if (input.equals("C+"))
			result = 2.3;
		else if (input.equals("C0"))
			result = 2.0;
		else if (input.equals("C-"))
			result = 1.7;
		else if (input.equals("D+"))
			result = 1.3;
		else if (input.equals("D0"))
			result = 1.0;
		else if (input.equals("D-"))
			result = 0.7;
		bw.write(String.valueOf(result));
		bw.flush();
	}
}
