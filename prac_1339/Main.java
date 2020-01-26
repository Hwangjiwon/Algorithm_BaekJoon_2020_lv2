package prac_1339;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;

public class Main {
	static LinkedList<String> alpha = new LinkedList<>();
	static int[] value;
	static ArrayList<String> input = new ArrayList<>();
	static boolean[] visited;
	static int max;

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		for (int i = 0; i < n; i++) {
			input.add(br.readLine());
			String[] str = input.get(i).split("");
			for (int j = 0; j < str.length; j++) {
				if (!alpha.contains(str[j]))
					alpha.add(str[j]);
			}
		}

		visited = new boolean[alpha.size()];
		value = new int[alpha.size()];

		dfs(0, 0);
		System.out.println(max);

		br.close();
	}

	public static void dfs(int len, int idx) {
		if (len == alpha.size()) {
			chk();
			return;
		}

		for (int i = 0; i < alpha.size(); i++) {
			if (visited[i])
				continue;

			visited[i] = true;
			value[idx] = 10 - alpha.size() + i;
			dfs(len + 1, idx + 1);
			visited[i] = false;
			value[idx] = 0;
		}
	}

	public static void chk() {
		int sum = 0;
		for (int i = 0; i < input.size(); i++) {
			int num = 0;
			for (int j = 0; j < input.get(i).length(); j++) {
				num *= 10;
				num += value[alpha.indexOf(Character.toString(input.get(i).charAt(j)))];
			}
			sum += num;
		}
		max = Math.max(sum, max);
	}
}
