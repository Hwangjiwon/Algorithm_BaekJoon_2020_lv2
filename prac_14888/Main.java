package prac_14888;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
	static int n;
	static List<Integer> num;
	static int[] op;
	static int min = Integer.MAX_VALUE;
	static int max = Integer.MIN_VALUE;

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		String[] str = br.readLine().split(" ");
		num = new ArrayList<>();
		for (int i = 0; i < n; i++) {
			num.add(Integer.parseInt(str[i]));
		}
		str = br.readLine().split(" ");
		op = new int[4]; // + - * / 개수
		for (int i = 0; i < 4; i++) {
			op[i] = Integer.parseInt(str[i]);
		}

		dfs(1, num.get(0)); // 다음 idx, result
		System.out.println(max);
		System.out.println(min);

		br.close();
	}

	public static void dfs(int idx, int result) {
		if (idx == n) {
			max = Math.max(max, result);
			min = Math.min(min, result);
			return;
		}

		for (int i = 0; i < 4; i++) {
			if (op[i] != 0) {
				op[i]--;
				switch (i) {
				case 0: // +
					dfs(idx + 1, result + num.get(idx));
					break;
				case 1: // -
					dfs(idx + 1, result - num.get(idx));
					break;
				case 2: // *
					dfs(idx + 1, result * num.get(idx));
					break;
				case 3: // /
					dfs(idx + 1, result / num.get(idx));
					break;
				}
				op[i]++;
			}
		}
	}

}
