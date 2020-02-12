package prac_11052_dfs_timeOver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	static int N;
	static int[] price;
	static int[] visited;
	static int max = Integer.MIN_VALUE;

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		price = new int[N + 1];
		visited = new int[N + 1];
		for (int i = 0; i < N; i++)
			visited[i + 1] = N - i;

		String[] tmp = br.readLine().split(" ");
		for (int i = 1; i <= N; i++)
			price[i] = Integer.parseInt(tmp[i - 1]);

		dfs(0, 0);
		System.out.println(max);
		br.close();
	}

	public static void dfs(int sum, int total) {
		if (sum == N) {
			max = Math.max(max, total);
			return;
		}
		for (int i = 1; i <= N; i++) {
			if (visited[i] == 0)
				continue;
			visited[i]--;
			dfs(sum + i, total + price[i]);
			visited[i]++;
		}
	}
}
