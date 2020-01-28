package prac_6603;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	static int k;
	static int[] num;
	static boolean[] visited;

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] str;
		while (true) {
			str = br.readLine().split(" ");
			k = Integer.parseInt(str[0]);
			if (k == 0)
				break;

			num = new int[k + 1];
			visited = new boolean[k + 1];
			for (int i = 0; i < k; i++) {
				num[i] = Integer.parseInt(str[i + 1]);
			}

			dfs(0, 0, "");
			System.out.println();
		}
		br.close();
	}

	public static void dfs(int len, int idx, String result) {
		if (len == 6) {
			System.out.println(result);
		}

		for (int i = idx; i < k; i++) {
			if (visited[i])
				continue;
			visited[i] = true;
			dfs(len + 1, i, result + String.valueOf(num[i]) + " ");
			visited[i] = false;
		}
	}

}
