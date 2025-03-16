import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        PriorityQueue<Integer> plusQ = new PriorityQueue<>();
        PriorityQueue<Integer> minusQ = new PriorityQueue<>(Collections.reverseOrder());

        int N = Integer.parseInt(br.readLine());
        while (N-- > 0) {
            int x = Integer.parseInt(br.readLine());
            if (x == 0) {
                if (!plusQ.isEmpty() && !minusQ.isEmpty()) {
                    if (plusQ.peek() > Math.abs(minusQ.peek())) {
                        sb.append(minusQ.poll()).append("\n");
                    } else if (plusQ.peek() < Math.abs(minusQ.peek())) {
                        sb.append(plusQ.poll()).append("\n");
                    } else {
                        sb.append(minusQ.poll()).append("\n");
                    }
                } else if (plusQ.isEmpty() && !minusQ.isEmpty()) {
                    sb.append(minusQ.poll()).append("\n");
                } else if (minusQ.isEmpty() && !plusQ.isEmpty()) {
                    sb.append(plusQ.poll()).append("\n");
                } else {
                    sb.append(0).append("\n");
                }
            } else if (x > 0) {
                plusQ.add(x);
            } else {
                minusQ.add(x);
            }
        }

        bw.write(String.valueOf(sb));
        bw.flush();
    }
}
