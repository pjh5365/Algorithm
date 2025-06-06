import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        int[] arr = new int[N];
        int[] ret = new int[N];
        Arrays.fill(ret, -1);
        StringTokenizer st = new StringTokenizer(br.readLine());
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            while (!stack.isEmpty() && arr[stack.peek()] < arr[i]) {
                ret[stack.peek()] = arr[i];
                stack.pop();
            }
            stack.push(i);
        }

        for (int i : ret) {
            bw.write(i + " ");
        }
        bw.flush();
    }
}
