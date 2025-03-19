import java.io.*;
import java.util.*;

public class Main {
    // 참고: https://velog.io/@ewoo97/BOJ-%EB%B0%B1%EC%A4%80-30804%EB%B2%88-%EA%B3%BC%EC%9D%BC-%ED%83%95%ED%9B%84%EB%A3%A8-JAVA
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        HashMap<Integer, Integer> cnt = new HashMap<>();
        int ret = 0;
        int left = 0;

        for (int right = 0; right < N; right++) {
            cnt.put(arr[right], cnt.getOrDefault(arr[right], 0) + 1);

            while (cnt.size() > 2) {
                cnt.put(arr[left], cnt.get(arr[left]) - 1);

                if (cnt.get(arr[left]) == 0) {
                    cnt.remove(arr[left]);
                }

                left++;
            }
            ret = Math.max(ret, right - left + 1);
        }
        
        bw.write(String.valueOf(ret));
        bw.flush();
    }
}
