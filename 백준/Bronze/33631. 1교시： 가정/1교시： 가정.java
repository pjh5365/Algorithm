import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine());
        int Fs = Integer.parseInt(st.nextToken());
        int Cs = Integer.parseInt(st.nextToken());
        int Es = Integer.parseInt(st.nextToken());
        int Bs = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int Fn = Integer.parseInt(st.nextToken());
        int Cn = Integer.parseInt(st.nextToken());
        int En = Integer.parseInt(st.nextToken());
        int Bn = Integer.parseInt(st.nextToken());

        int Q = Integer.parseInt(br.readLine());

        int ret = 0;
        while (Q-- > 0) {
            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            if (a == 1) {
                if (!(Fs - (Fn * b) >= 0 && Cs - (Cn * b) >= 0 && Es - (En * b) >= 0 && Bs - (Bn * b) >= 0)) {
                    sb.append("Hello, siumii \n");
                } else {
                    Fs -= Fn * b;
                    Cs -= Cn * b;
                    Es -= En * b;
                    Bs -= Bn * b;
                    ret += b;
                    sb.append(ret + "\n");
                }
            } else if (a == 2) {
                Fs += b;
                sb.append(Fs + "\n");
            } else if (a == 3) {
                Cs += b;
                sb.append(Cs + "\n");
            } else if (a == 4) {
                Es += b;
                sb.append(Es + "\n");
            } else if (a == 5) {
                Bs += b;
                sb.append(Bs + "\n");
            }
        }


        bw.write(sb + "\n");
        bw.flush();
    }
}
