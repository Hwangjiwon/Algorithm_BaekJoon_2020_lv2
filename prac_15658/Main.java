package prac_15658;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	static int N;
	static int[] num;
	static int[] op;
	static int min = Integer.MAX_VALUE;
	static int max = Integer.MIN_VALUE;

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		num = new int[N];
		String[] tmp = br.readLine().split(" ");
		for (int i = 0; i < N; i++)
			num[i] = Integer.parseInt(tmp[i]);

		op = new int[4];
		tmp = br.readLine().split(" ");
		for (int i = 0; i < 4; i++)
			op[i] = Integer.parseInt(tmp[i]);

		dfs(1, num[0]);
		System.out.println(max);
		System.out.println(min);

		br.close();
	}

	public static void dfs(int idx, int result) {
		if (idx == N) {
			max = Math.max(max, result);
			min = Math.min(min, result);
			return;
		}

		for (int i = 0; i < 4; i++) {
			if (op[i] != 0) {
				op[i]--;
				switch (i) {
				case 0: // +
					dfs(idx + 1, result + num[idx]);
					break;
				case 1: // -
					dfs(idx + 1, result - num[idx]);
					break;
				case 2: // *
					dfs(idx + 1, result * num[idx]);
					break;
				case 3: // /
					dfs(idx + 1, result / num[idx]);
					break;
				}
				op[i]++;
			}
		}
	}

}
