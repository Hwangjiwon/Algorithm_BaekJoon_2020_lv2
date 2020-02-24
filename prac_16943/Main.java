package prac_16943;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	static int B, C, size;
	static int[] num;
	static boolean[] visited;

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] tmp = br.readLine().split(" ");
		size = tmp[0].length();
		num = new int[size];
		visited = new boolean[size];
		for (int i = 0; i < size; i++) {
			num[i] = (int) tmp[0].charAt(i) - '0';
		}
		B = Integer.parseInt(tmp[1]);
		C = -1;
		sol(0, "");

		System.out.println(C);
		br.close();
	}

	public static void sol(int len, String str) {
		if (len == size) {
			int result = Integer.parseInt(str);
			if (result <= B) {
				C = Math.max(C, result);
			}
			return;
		}

		for (int i = size - 1; i >= 0; i--) {
			if (len == 0 && num[i] == 0) //첫번째가 0이면 안됨
				continue;
			if (!visited[i]) {
				visited[i] = true;
				sol(len + 1, str + num[i] + "");
				visited[i] = false;
			}
		}
	}
}
