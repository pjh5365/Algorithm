import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();

		int[] arr = new int[3];
		do {
			StringTokenizer st = new StringTokenizer(br.readLine());

			arr[0] = Integer.parseInt(st.nextToken());
			arr[1] = Integer.parseInt(st.nextToken());
			arr[2] = Integer.parseInt(st.nextToken());

			int max = 0;
			int maxIndex = 0;
			for (int i = 0; i < 3; i++) {
				if (max < arr[i]) {
					max = arr[i];
					maxIndex = i;
				}
			}
			int sum = 0;
			for (int i = 0; i < 3; i++) {
				if (i == maxIndex)
					continue;
				sum += arr[i];
			}

			if (arr[0] == 0 && arr[1] == 0 && arr[2] == 0)
				break;

			if (arr[0] == arr[1] && arr[0] == arr[2]) { // 세 변 모두 같음
				sb.append("Equilateral").append("\n");
			} else if (arr[0] == arr[1] || arr[1] == arr[2] || arr[0] == arr[2]) { // 두 변만 같음
				if (arr[maxIndex] < sum) {
					sb.append("Isosceles").append("\n");
				} else {
					sb.append("Invalid").append("\n");
				}
			} else {
				if (arr[maxIndex] < sum) {
					sb.append("Scalene").append("\n");
				} else {
					sb.append("Invalid").append("\n");
				}
			}

		} while(true);

		bw.write(String.valueOf(sb));
		bw.flush();
	}
}
