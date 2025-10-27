import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        double totalScore = 0;
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            double S = Double.parseDouble(st.nextToken());
            double A = Double.parseDouble(st.nextToken());
            double T = Double.parseDouble(st.nextToken());
            double M = Double.parseDouble(st.nextToken());

            totalScore += (S * (1 + 1 / A) * (1 + M / T)) / 4;
        }
        int P = Integer.parseInt(br.readLine());
        List<Double> list = new ArrayList<>();
        list.add(totalScore);
        for (int i = 0; i < P; i++) {
            double p = Double.parseDouble(br.readLine());
            list.add(p);
        }
        list.sort(Comparator.reverseOrder());

        double tmp = list.size() * 0.15;


        String name = "Younghoon";
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i) == totalScore) {
                if (i <= tmp - 1) {
                    name = "Younghoon \"The God\"";
                }
                break;
            }
        }

        System.out.printf("The total score of %s is %.2f.\n", name, totalScore);

        // bw.write(ret + "\n");
        bw.flush();
    }
}
