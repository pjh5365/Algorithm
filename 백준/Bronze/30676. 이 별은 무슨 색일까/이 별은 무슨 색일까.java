import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		String s = "";
		int n = Integer.parseInt(br.readLine());
		if (n >= 620 && n <= 780) {
			s = "Red";
		} else if (n >= 590 && n <= 620) {
			s = "Orange";
		} else if (n >= 570 && n <= 590) {
			s = "Yellow";
		} else if (n >= 495 && n <= 570) {
			s = "Green";
		} else if (n >= 450 && n <= 495) {
			s = "Blue";
		} else if (n >= 425 && n <= 450) {
			s = "Indigo";
		} else if (n >= 380 && n <= 425) {
			s = "Violet";
		}
		bw.write(s);
		bw.flush();
	}
}
