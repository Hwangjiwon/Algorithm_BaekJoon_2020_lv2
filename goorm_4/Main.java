package goorm_4;

import java.io.*;

class Main {
	static int N, K;
	static boolean[] visited;
	static int cnt;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] input = br.readLine().split(" ");
		N = Integer.parseInt(input[0]);
		K = Integer.parseInt(input[1]);
		cnt = 0;
		visited = new boolean[N];
		dfs(0, 0, 0, "");
		System.out.println(cnt);
	}

	public static void dfs(int len, int idx, int sum, String str) {
		if (len == K) {
			System.out.println(str);
			cnt++;
			
			return;
		}

		for (int i = idx; i < N; i++) {
			if (!visited[i]) {
				visited[i] = true;
				dfs(len + 1, i, sum + i, str + i + " ");
				visited[i] = false;
			}
		}
	}
	
	
}
