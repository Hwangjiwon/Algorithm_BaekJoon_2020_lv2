package prac_16198;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	static int n;
	static int[] energy;
	static boolean[] visited;
	static int max = Integer.MIN_VALUE;

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		String[] tmp = br.readLine().split(" ");
		energy = new int[n];
		visited = new boolean[n];

		for (int i = 0; i < n; i++)
			energy[i] = Integer.parseInt(tmp[i]);

		dfs(0, 0);
		System.out.println(max);
		br.close();
	}

	public static int getLeft(int idx) {
		int left = idx;
		while (true) {
			left--;
			if (!visited[left])
				break;
		}
		return energy[left];
	}

	public static int getRight(int idx) {
		int right = idx;
		while (true) {
			right++;
			if (!visited[right])
				break;
		}
		return energy[right];
	}

	public static void dfs(int cnt, int result) {
		if (cnt == n - 2) {
			max = Math.max(max, result);
		}

		for (int i = 1; i < n - 1; i++) {
			if (!visited[i]) {
				visited[i] = true;
				dfs(cnt + 1, result + getLeft(i) * getRight(i));
				visited[i] = false;
			}
		}
	}
}
