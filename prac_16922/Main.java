package prac_16922;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;

public class Main {
	static int[] rome = { 1, 5, 10, 50 };
	static int N;
	static HashSet<Integer> result = new HashSet<Integer>();

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] tmp = br.readLine().split(" ");
		N = Integer.parseInt(tmp[0]);
		
		sol(0, 0, 0);
		System.out.println(result.size());
		br.close();
	}

	public static void sol(int len, int idx, int sum) {
		if (len == N) {
			result.add(sum);
			return;
		}

		for (int i = idx; i < 4; i++) {
			sol(len + 1, i, sum + rome[i]);
		}
	}
}
