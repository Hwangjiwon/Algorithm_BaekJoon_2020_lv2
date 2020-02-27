package prac_16938;

import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.IOException;

public class Main {
	static int N, L, R, X;
	static int[] num;
	static boolean[] visited;
	static int cnt;

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] tmp = br.readLine().split(" ");
		N = Integer.parseInt(tmp[0]);
		L = Integer.parseInt(tmp[1]);
		R = Integer.parseInt(tmp[2]);
		X = Integer.parseInt(tmp[3]);

		tmp = br.readLine().split(" ");
		num = new int[N];
		visited = new boolean[N];
		for (int i = 0; i < N; i++) {
			num[i] = Integer.parseInt(tmp[i]);
		}

		dfs(0, 0, (int) Math.pow(10, 6) + 1, 0, 0, "");
		System.out.println(cnt);
		br.close();
	}

	public static void dfs(int len, int idx, int min, int max, int sum, String str) {
		if (len >= 2) {
			if (L <= sum && sum <= R && (max - min) >= X)
				cnt++;
		}

		for (int i = idx; i < N; i++) {
			if (visited[i])
				continue;
			visited[i] = true;
			dfs(len + 1, i + 1, Math.min(min, num[i]), Math.max(max, num[i]), sum + num[i], str + num[i] + " ");
			visited[i] = false;
		}

	}

}
