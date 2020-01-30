package prac_14225;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	static int N;
	static int[] S;
	static boolean[] visited;
	static boolean[] sum;

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		S = new int[N];
		visited = new boolean[N];
		String[] num = br.readLine().split(" ");
		for (int i = 0; i < N; i++) {
			S[i] = Integer.parseInt(num[i]);
		}
		sum = new boolean[2000001];
		dfs(0, 0);

		for (int min = 0; min < sum.length; min++) {
			if (!sum[min]) {
				System.out.println(min);
				break;
			}
		}
		br.close();
	}

	public static void dfs(int idx, int result) {
		sum[result] = true;
		for (int i = idx; i < N; i++) {
			if (visited[i])
				continue;
			visited[i] = true;
			dfs(i, result + S[i]);
			visited[i] = false;
		}
	}
}
