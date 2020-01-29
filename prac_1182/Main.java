package prac_1182;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	static int N, S;
	static int[] num;
	static boolean[] visited;
	static int cnt;

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] str = br.readLine().split(" ");
		N = Integer.parseInt(str[0]);
		S = Integer.parseInt(str[1]);

		num = new int[N];
		visited = new boolean[N];
		str = br.readLine().split(" ");
		for (int i = 0; i < N; i++) {
			num[i] = Integer.parseInt(str[i]);
		}

		dfs(0, 0);
		//S==0일때, 공집합인 경우도 카운트하기때문에 -1해줘야 함!
		if (S == 0)
			cnt--;
		System.out.println(cnt);
		br.close();
	}

	public static void dfs(int idx, int result) {
		if (result == S)
			cnt++;

		for (int i = idx; i < N; i++) {
			if (!visited[i]) {
				visited[i] = true;
				dfs(i, result + num[i]);
				visited[i] = false;
			}
		}
	}
}
