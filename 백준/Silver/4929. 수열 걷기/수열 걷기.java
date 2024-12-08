import java.io.*;
import java.util.*;

public class Main {
	/**
	 * 4929 - 우선 교차점을 찾아서 저장해놓고 그 사이의 구간합을 계산해서 최대값으로만 계속 더하기
	 */
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();

		while (true) {
			Set<Integer> s = new HashSet<>(); // 교차점을 찾기 위한 집합
			Set<Integer> cross = new HashSet<>(); // 교차점 리스트
			ArrayList<Integer> sum1 = new ArrayList<>(); // 첫번째 구간합 리스트
			ArrayList<Integer> sum2 = new ArrayList<>(); // 두번쨰 구간합 리스트
			String s1 = br.readLine();
			if (s1.equals("0")) {
				break;
			}
			String s2 = br.readLine();
			StringTokenizer st1 = new StringTokenizer(s1);
			StringTokenizer st2 = new StringTokenizer(s2);
			int N1 = Integer.parseInt(st1.nextToken());
			int N2 = Integer.parseInt(st2.nextToken());

			int[] arr1 = new int[N1];
			int[] arr2 = new int[N2];

			for (int i = 0; i < N1; i++) {
				arr1[i] = Integer.parseInt(st1.nextToken());
				s.add(arr1[i]);
			}
			int sum = 0;
			for (int i = 0; i < N2; i++) { // 두번째 길은 교차로를 찾으며 구간합 계산하기
				arr2[i] = Integer.parseInt(st2.nextToken());
				sum += arr2[i];
				if (s.contains(arr2[i])) {
					cross.add(arr2[i]);
					sum2.add(sum);
					sum = 0;
				}
			}
			sum2.add(sum);
			sum = 0;
			for (int i = 0; i < N1; i++) { // 교차로를 찾으며 구간합 계산하기
				sum += arr1[i];
				if (cross.contains(arr1[i])) {
					sum1.add(sum);
					sum = 0;
				}
			}
			sum1.add(sum);
			int ret = 0;
			for (int i = 0; i < sum1.size(); i++) {
				ret += Math.max(sum1.get(i), sum2.get(i));
			}
			sb.append(ret).append("\n");
		}

		bw.write(String.valueOf(sb));
		bw.flush();
	}
}
