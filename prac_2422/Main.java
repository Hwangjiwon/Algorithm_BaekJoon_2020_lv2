package prac_2422;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	static int N, M;

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] str = br.readLine().split(" ");
		N = Integer.parseInt(str[0]);
		M = Integer.parseInt(str[1]);

		dfs(0, 1, "");

		br.close();
	}

	public static void dfs(int len, int idx, String str) {
		if (len == 3) {
			System.out.println(str);
			return;
		}

		for (int i = idx; i <= N; i++) {
			dfs(len + 1, i + 1, str + i + " ");
		}
	}
}
