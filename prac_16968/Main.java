package prac_16968;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	static String[] input;
	static int C = 26;
	static int D = 10;
	static int cnt = 1;

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		input = br.readLine().split("");

		sol();
		System.out.println(cnt);
		br.close();
	}

	public static void sol() {
		for (int i = 0; i < input.length; i++) {
			if (input[i].equals("c")) {
				if (i - 1 >= 0) {
					if (input[i - 1].equals("c")) {
						cnt = cnt * (C - 1);
					} else {
						cnt = cnt * C;
					}
				} else {
					cnt = cnt * C;
				}
			} else {
				if (i - 1 >= 0) {
					if (input[i - 1].equals("d")) {
						cnt = cnt * (D - 1);
					} else {
						cnt = cnt * D;
					}
				} else {
					cnt = cnt * D;
				}
			}
		}
	}
}
