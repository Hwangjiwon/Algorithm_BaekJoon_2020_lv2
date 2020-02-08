package prac_1463;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	static int n;
	static int[] dp;

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		dp = new int[n + 1];

		//buttomUp();
		System.out.println(topDown(n));
		br.close();
	}

	public static void buttomUp() { // ����ó��, ���� �ͺ��� ���ʴ�� Ǭ��
		dp[1] = 0;
		for (int i = 2; i <= n; i++) {
			dp[i] = dp[i - 1] + 1;
			if (i % 2 == 0)
				dp[i] = Math.min(dp[i], dp[i / 2] + 1);
			if (i % 3 == 0) {
				dp[i] = Math.min(dp[i], dp[i / 3] + 1);
			}
		}
		System.out.println(dp[n]);
	}

	public static int topDown(int n) { // ����ó��, ���������� ������, memoization�� �ִ��� �˻� �� ����
		if (n == 1)
			return 0;
		if (dp[n] > 0)
			return dp[n];

		dp[n] = topDown(n - 1) + 1;
		if (n % 2 == 0)
			dp[n] = Math.min(dp[n], topDown(n / 2) + 1);
		if (n % 3 == 0)
			dp[n] = Math.min(dp[n], topDown(n / 3) + 1);
		return dp[n];

	}
}
