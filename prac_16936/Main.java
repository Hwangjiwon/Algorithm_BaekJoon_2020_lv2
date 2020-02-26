package prac_16936;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	static int N;
	static long[] arr;
	static boolean[] visited;

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] tmp = br.readLine().split(" ");

		N = Integer.parseInt(tmp[0]);
		arr = new long[N];
		visited = new boolean[N];

		tmp = br.readLine().split(" ");
		for (int i = 0; i < N; i++) {
			arr[i] = Long.parseLong(tmp[i]);
		}

		dfs(0, "");

		br.close();
	}

	public static void dfs(int len, String str) {
		if (len == N) {
			if(chk(str))
				System.out.println(str);
			return;
		}

		for (int i = 0; i < N; i++) {
			if (visited[i])
				continue;
			visited[i] = true;
			dfs(len + 1, str + arr[i] + " ");
			visited[i] = false;
		}
	}

	public static boolean chk(String str) {
		long[] num = new long[N];
		String[] tmp = str.split(" ");

		for (int i = 0; i < N; i++)
			num[i] = Long.parseLong(tmp[i]);

		for (int i = 0; i < N - 1; i++) {
			if (num[i] * 2 == num[i + 1] || ((num[i] % 3 == 0) && (num[i] / 3 == num[i + 1])))
				continue;
			else
				return false;
		}
		return true;
	}
}
