import java.io.*;
import java.util.*;

class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int sum = 0;
		for (int i = 0; i < 5; i++) {
			sum += Integer.parseInt(st.nextToken());
		}
		System.out.println(sum);
	}
}