package goorm_2;

import java.io.*;

class Main {
	static int N, K;
	static int[] arr;
	static int cnt;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] input = br.readLine().split(" ");
		N = Integer.parseInt(input[0]);
		K = Integer.parseInt(input[1]);

		arr = new int[N];
		input = br.readLine().split(" ");
		for (int i = 0; i < N; i++)
			arr[i] = Integer.parseInt(input[i]);

		cnt = (int) Math.ceil((double)(N-1)/(K-1));
		System.out.println(cnt);

	}

}