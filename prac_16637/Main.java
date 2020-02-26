package prac_16637;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;

public class Main {
	static LinkedList<Integer> num = new LinkedList<>();
	static LinkedList<Character> op = new LinkedList<>();
	static int max = Integer.MIN_VALUE;
	static int N;

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] tmp = br.readLine().split(" ");
		int N = Integer.parseInt(tmp[0]);
		tmp = br.readLine().split("");

		for (int i = 0; i < N; i++) {
			if (tmp[i].equals("+") || tmp[i].equals("-") || tmp[i].equals("*"))
				op.add(tmp[i].charAt(0));
			else
				num.add(Integer.parseInt(tmp[i]));
		}
		dfs(0, num.get(0));
		System.out.println(max);
		br.close();
	}

	public static void dfs(int idx, int result) {
		if (idx >= op.size()) {
			if (max < result)
				max = result;
			return;
		}

		int tmp = cal(result, op.get(idx), num.get(idx + 1));
		dfs(idx + 1, tmp);

		if (idx + 1 < op.size()) {
			tmp = cal(result, op.get(idx), cal(num.get(idx + 1), op.get(idx + 1), num.get(idx + 2)));
			dfs(idx + 2, tmp);
		}

	}

	public static int cal(int n1, char op, int n2) {
		if (op == '+')
			return n1 + n2;
		else if (op == '-')
			return n1 - n2;
		else
			return n1 * n2;
	}
}
