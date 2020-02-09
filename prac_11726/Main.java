package prac_11726;

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

		dp[0] = 1;
		dp[1] = 1;
		// bottomUp();
		System.out.println(topDown(n));

		br.close();
	}

	public static void bottomUp() { // 작은 것부터 차례대로 푼다
		for (int i = 2; i <= n; i++) {
			dp[i] = (dp[i - 1] + dp[i - 2]) % 10007;
		}
		System.out.println(dp[n]);
	}

	public static int topDown(int n) { // 작은문제로 나눈다, memoization에 있는지 검사 후 쓰기
		if (n == 0 || n == 1)			
			return dp[n];
		
		if (dp[n] > 0)
			return dp[n];

		dp[n] = (topDown(n - 1) + topDown(n - 2)) % 10007;
		return dp[n];
	}
}
