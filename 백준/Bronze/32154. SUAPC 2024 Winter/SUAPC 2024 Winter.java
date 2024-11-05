import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();

		int N = Integer.parseInt(br.readLine());

		switch (N) {
			case 1:
				sb.append("11").append("\n");
				sb.append("A B C D E F G H J");
				break;
			case 2:
				sb.append("9").append("\n");
				sb.append("A C E F G H I");
				break;
			case 3:
				sb.append("9").append("\n");
				sb.append("A C E F G H I");
				break;
			case 4:
				sb.append("9").append("\n");
				sb.append("A B C E F G H");
				break;
			case 5:
			case 6:
			case 7:
			case 8:
			case 9:
				sb.append("8").append("\n");
				sb.append("A C E F G H");
				break;
			case 10:
				sb.append("8").append("\n");
				sb.append("A B C F G H");
				break;
		}
		sb.append(" L M \n");

		bw.write(String.valueOf(sb));
		bw.flush();
	}
}
