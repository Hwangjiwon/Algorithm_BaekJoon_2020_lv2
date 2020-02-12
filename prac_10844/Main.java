package prac_10844;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	static long mod = 1000000000;

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		long[][] dp = new long[101][10];

		for (int i = 0; i < 9; i++)
			dp[1][i] = 1;

		for (int i = 2; i <= N; i++) {
			for (int j = 0; j <= 9; j++) {
				if (j == 0)
					dp[i][j] = (dp[i - 1][j + 1]) % mod;
				else if (j == 9)
					dp[i][j] = (dp[i - 1][j - 1]) % mod;
				else
					dp[i][j] = (dp[i - 1][j - 1] + dp[i - 1][j + 1]) % mod;
			}
		}

		long sum = 0;
		for (int i = 0; i <= 9; i++)
			sum += dp[N][i];

		System.out.println(sum % mod);

		br.close();
	}

}
