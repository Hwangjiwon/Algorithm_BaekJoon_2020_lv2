package test_4;

import java.io.*;

class Main {
	static int cnt;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] input = br.readLine().split(" ");
		int n = Integer.parseInt(input[0]);

		hanoi(n, 'a', 'b', 'c');
		System.out.println(cnt);
	}

	public static void hanoi(int n, char from, char mid, char to) {
		if (n == 1) {
			++cnt;
		} else {
			hanoi(n - 1, from, to, mid);
			++cnt;
			hanoi(n - 1, mid, from, to);
		}

	}
}